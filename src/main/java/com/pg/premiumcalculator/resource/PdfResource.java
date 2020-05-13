package com.pg.premiumcalculator.resource;

import java.io.ByteArrayInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pg.premiumcalculator.models.PremiumCalculationResponse;
import com.pg.premiumcalculator.pdf.PdfGenerator;

@CrossOrigin(origins = "*")
@RestController
public class PdfResource {
	
	PdfGenerator pdf;

	@PostMapping("users/{username}/pdf/{company}")
	public ResponseEntity<InputStreamResource> generatePdf(@RequestBody PremiumCalculationResponse pcResponse,@PathVariable String username,@PathVariable String company)
	{
		pdf = new PdfGenerator(company, "", "", "", "");
		ByteArrayInputStream bis = pdf.createPdf(pcResponse.getBasData(), pcResponse.getOdData(), pcResponse.getTpData(), pcResponse.getFinalData());
		var headers = new HttpHeaders();
		String filename = company+"_quotation.pdf";
        headers.add("Content-Disposition", "inline; filename="+filename);

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
}
