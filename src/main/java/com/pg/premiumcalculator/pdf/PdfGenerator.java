package com.pg.premiumcalculator.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PdfGenerator {
    String companyName="";
    String pdfname="",
            name="",
            email="",
            phone="";
    
	private static Logger logger = LogManager.getLogger(PdfGenerator.class.getName());


    public PdfGenerator(String companyName, String pdfname,String name,String email,String phone) {
        this.companyName = companyName;
        this.pdfname = pdfname;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public ByteArrayInputStream createPdf(LinkedHashMap<String,String>basic,LinkedHashMap<String,String>od,LinkedHashMap<String,String>tp,LinkedHashMap<String,String>total)
    {
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            try {
                LineSeparator lineSeparator = new LineSeparator();
                lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));
                Font h1_font = new Font(Font.FontFamily.TIMES_ROMAN, 22.0f, Font.UNDERLINE, BaseColor.BLACK);
                Font h2_font = new Font(Font.FontFamily.TIMES_ROMAN, 19.0f, Font.NORMAL, BaseColor.BLACK);
                Font bold_font = new Font(Font.FontFamily.TIMES_ROMAN, 12.0f, Font.BOLD, BaseColor.BLACK);
                Font normal_font = new Font(Font.FontFamily.TIMES_ROMAN, 12.0f, Font.NORMAL, BaseColor.BLACK);
                document.add(new Chunk(lineSeparator));

                //add heading
                Chunk heading = new Chunk(companyName, h1_font);
                Paragraph heading_para = new Paragraph(heading);
                heading_para.setAlignment(Element.ALIGN_CENTER);
                document.add(heading_para);

                document.add(new Paragraph("\n"));

                Chunk qheading = new Chunk("QUOTATION", h2_font);
                Paragraph qheading_para = new Paragraph(qheading);
                qheading_para.setAlignment(Element.ALIGN_CENTER);
                document.add(qheading_para);
                document.add(new Paragraph("\n"));

                //basic details table
                PdfPTable basictable = new PdfPTable(4);
                basictable.setHorizontalAlignment(Element.ALIGN_CENTER);
                basictable.setTotalWidth(PageSize.A4.getWidth());
                basictable.setWidthPercentage(100);
                float[] relativeWidths = new float[]{11f, 9f, 11f, 5f};
                basictable.setWidths(relativeWidths);
                Set<String> keyss = basic.keySet();
                for(String k:keyss)
                {
                    String a=k,b=basic.get(k);
                    addCell(a, basictable, bold_font);
                    addCell(b, basictable, normal_font);
                }
                basictable.completeRow();
                basictable.setSpacingAfter(2f);
                document.add(basictable);
                document.add(new Paragraph("\n"));

                //premium table
                PdfPTable premiumtable = new PdfPTable(4);
                premiumtable.setHorizontalAlignment(Element.ALIGN_CENTER);
                premiumtable.setTotalWidth(PageSize.A4.getWidth());
                premiumtable.setWidthPercentage(100);
                premiumtable.setWidths(relativeWidths);

                addCell("OD Premium(A)", premiumtable, bold_font);
                addCell("Rupees", premiumtable, bold_font);
                addCell("Liability Premium(B)", premiumtable, bold_font);
                addCell("Rupees", premiumtable, bold_font);

                Set<String> keys1=tp.keySet(),keys2=od.keySet();
                int size1 = keys1.size(),size2 = keys2.size();
                Iterator i1 = keys1.iterator(),i2 = keys2.iterator();
                while(true)
                {
                    if(size1<=1 && size2<=1)
                        break;
                    if(i2.hasNext() && size2>1)
                    {
                        String a = (String)i2.next();
                        addCell(a, premiumtable, normal_font);
                        addCell(od.get(a), premiumtable, normal_font);
                        size2--;
                    }
                    else
                    {
                        addCell("", premiumtable, normal_font);
                        addCell("", premiumtable, normal_font);
                    }
                    if(i1.hasNext() && size1>1)
                    {
                        String a = (String) i1.next();
                        addCell(a, premiumtable, normal_font);
                        addCell(tp.get(a), premiumtable, normal_font);
                        size1--;
                    }
                    else
                    {
                        addCell("", premiumtable, normal_font);
                        addCell("", premiumtable, normal_font);
                    }
                }
                if(i2.hasNext()) {
                    String a = (String) i2.next();
                    addCell(a, premiumtable, bold_font);
                    addCell(od.get(a), premiumtable, bold_font);
                }
                if(i1.hasNext()) {
                    String a = (String) i1.next();
                    addCell(a, premiumtable, bold_font);
                    addCell(tp.get(a), premiumtable, bold_font);
                }

                addCellWithColSpan("  ", premiumtable, normal_font, 4);

                keyss = total.keySet();
                for(String k:keyss)
                {
                    addCellWithColSpan(k, premiumtable, bold_font, 2);
                    addCellWithColSpan(total.get(k), premiumtable, bold_font, 2);
                }
                premiumtable.completeRow();
                premiumtable.setSpacingAfter(2f);
                document.add(premiumtable);

                Paragraph p1 = new Paragraph("Kindly pay Cheque/DD in favor of "+companyName, bold_font);
                document.add(p1);
                document.add(new Paragraph("\n"));
                Paragraph p2 = new Paragraph("Documents Required:", normal_font);
                document.add(p2);
                document.add(new Paragraph("\n"));

                //doc table
                PdfPTable doctable = new PdfPTable(2);
                doctable.setHorizontalAlignment(Element.ALIGN_CENTER);
                doctable.setTotalWidth(PageSize.A4.getWidth());
                doctable.setWidthPercentage(100);
                float[] docwidth = new float[]{1f, 10f};
                doctable.setWidths(docwidth);
                addCell("1.", doctable, bold_font);
                addCell("Previous Policy copy", doctable, normal_font);
                addCell("2.", doctable, bold_font);
                addCell("RC Copy", doctable, normal_font);
                doctable.completeRow();
                doctable.setSpacingAfter(2f);
                document.add(doctable);

                Paragraph p3 = new Paragraph("Note: In case of any claim, NCB will be revised and hence Quotation is subject to change.", bold_font);
                document.add(p3);
                document.add(new Paragraph("\n"));

                document.add(new Paragraph("Name: "+name));
                document.add(new Paragraph("Email: "+email));
                document.add(new Paragraph("Phone: "+phone));
            }
            catch (DocumentException de)
            {
            	logger.debug("createPdf()","Document Exception :"+de);
            }
            finally {
                document.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    void addCell(String str, PdfPTable table, Font f)
    {
        Phrase para = new Phrase(str,f);
        PdfPCell cell = new PdfPCell();
        cell.addElement(para);
        cell.setPaddingRight(2f);
        table.addCell(cell);
    }

    void addCellWithColSpan(String str, PdfPTable table, Font f,int span)
    {
        Phrase para = new Phrase(str,f);
        PdfPCell cell = new PdfPCell();
        cell.addElement(para);
        cell.setColspan(span);
        cell.setPaddingRight(2f);
        table.addCell(cell);
    }
}
