package com.sts.util;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Util {

	public String getCurrentDate() {
		Date currentDate = new Date();
	    String dateTime = DateFormat.getDateInstance().format(currentDate);
		return dateTime;
	}

}
