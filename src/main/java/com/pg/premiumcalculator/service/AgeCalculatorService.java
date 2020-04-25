package com.pg.premiumcalculator.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class AgeCalculatorService {
	
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    Integer getDays(String currentString,String givenString)
    {
        Integer days = 0;
        Integer cd,cm,cy,gd,gm,gy;
        try {
            Date date1 = formatter.parse(givenString);
            Date date2 = formatter.parse(currentString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            gd = cal.get(Calendar.DAY_OF_MONTH);
            gm = cal.get(Calendar.MONTH);
            gm++;
            gy = cal.get(Calendar.YEAR);
            cal.setTime(date2);
            cd = cal.get(Calendar.DAY_OF_MONTH);
            cm = cal.get(Calendar.MONTH);
            cm++;
            cy = cal.get(Calendar.YEAR);
            Integer monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            Integer c1 = cy*365+cd;
            Integer c2 = gy*365+gd;
            for(int i=0;i<cm-1;i++)
                c1+=monthDays[i];

            for(int i=0;i<gm-1;i++)
                c2+=monthDays[i];
            days+=c1-c2+1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days<=0?0:days;
    }
}
