package br.com.fgb.helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utils {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	static NumberFormat numberFormat = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
	
	public static String dateToString(Date date) {
		return dateFormat.format(date);
	}
	
	public static Date stringToDate(String date) {
		try {
			return dateFormat.parse(date);
		}catch (ParseException e) {
			return null;
		}
	}
	
	public static String doubleToString(Double value) {
		return numberFormat.format(value);
	}
	
	public static Double stringToDouble(String value) {
		try {
			return (Double) numberFormat.parse(value);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static void pause(int seconds) {
		try {
		TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			System.out.println("Não foi possivel pausar por " + seconds + " segundos.");
		}
	}
}
