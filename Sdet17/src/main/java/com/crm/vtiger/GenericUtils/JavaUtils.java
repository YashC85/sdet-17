package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/*
 * @author Yash
 *
 * */
public class JavaUtils {
	
	/*
	 * generate random number
	 * @return
	 * */
public static String getRandomData()
{
	Random random = new Random();
	int ran = random.nextInt(1000);
	return ""+ran;
	
}

/*
 * Generate current system date
 */
public static String getCurrentSystemDate()
{
	Date date = new Date();
	String currentDate = date.toString();
	return currentDate.replace(" ", "_").replace(":", "_");
}
	
}
