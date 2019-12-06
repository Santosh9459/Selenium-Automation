package com.training.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateIncrement {
	
	public void IncrmntDate(String IncrDat){
		
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date dt = new Date();
	Calendar cl = Calendar.getInstance();
	cl.setTime(dt);;
	cl.add(Calendar.DAY_OF_YEAR, 1);
	dt=cl.getTime();
	String str = df.format(dt);
	 this.IncrmntDate(str);
	}

}


