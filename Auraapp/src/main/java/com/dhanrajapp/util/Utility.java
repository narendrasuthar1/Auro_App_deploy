package com.dhanrajapp.util;

import java.text.SimpleDateFormat;
import java.util.Collection;

public class Utility {

	public final static int noOfStaff=10;
	public static String licenseNumber="15000";
	
	public static boolean listIsNullOrEmpty (Collection<?> list) {
		return (list==null) || (list.size() ==0);
	}
	
	public static boolean stringIsNullOrEmpty(String str) {
		return (str==null) || (str.length() ==0);
	}

	public static String convertDate(String date,String fromFormat,String toFormat) {
		String formatedDate="";
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat(fromFormat);
		    SimpleDateFormat sdf2 = new SimpleDateFormat(toFormat);
		    System.out.println();
		    formatedDate=sdf2.format(sdf.parse(date));
		} catch (Exception e) {
		    System.out.println(e);
		}
		
		return formatedDate;
	}
}
