package utils.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UUtilsTypes {
	
	public static final String DATE_FORMAT = "YYYY-MM-dd";
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String YEAR_FORMAT = "yyyy";
	
	public static final String PATTERN_BRACKETS = "[\\[\\]]";


	public static boolean isBoolean(Object s) {
		String sStr = convertObjectToString(s).trim();
		return ((sStr.equals("true")) || 
				(sStr.equals("false")) || 
				(sStr.equals("0")) || 
				(sStr.equals("1")));
	}

	public static boolean isByte(Object s) {

		try {
			
			// comprueba si es un entero
			if (!isInt(s)) return false;
			
			// comprueba si est� entre 0 y 255
			int sInt = convertObjectToInt(s);
			if ((sInt >= 0) && (sInt <= 255)) return true;
			
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static boolean isInt(Object s) {

		try {
			String foo = String.valueOf(s);
			Integer.valueOf(foo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isLong(Object s) {

		try {
			Long.valueOf(String.valueOf(s));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isFloat(Object s) {

		try {
			Float.valueOf(String.valueOf(s));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isDouble(Object s) {

		try {
			Double.valueOf(String.valueOf(s));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isString(Object s) {

		try {
			String.valueOf(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isCharset(Object value) {

		Map<?, ?> charSets = Charset.availableCharsets();
		boolean found = false;
		Iterator<?> it = charSets.keySet().iterator();

		while (it.hasNext()) {
			String csName = (String) it.next();
			if (csName.equals(value.toString())) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public static boolean isDate(Object value) {

		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			df.parse(convertObjectToString(value));
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean isDatetime(Object value) {

		try {
			DateFormat df = new SimpleDateFormat(DATETIME_FORMAT);
			df.setLenient(false);
			df.parse(convertObjectToString(value));
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	public static boolean isTimestamp(Object value) {

		try {
			DateFormat df = new SimpleDateFormat(TIMESTAMP_FORMAT);
			df.setLenient(false);
			df.parse(convertObjectToString(value));
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	

	public static boolean isYear(Object value) {

		try {
			DateFormat df = new SimpleDateFormat(YEAR_FORMAT);
			df.setLenient(false);
			df.parse(convertObjectToString(value));
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean isDateformat(Object value) {

		try {
			new SimpleDateFormat(value.toString());
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static boolean isTimezone(Object value) {

		try {
			ZoneId.of(value.toString());
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static boolean isBitArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		boolean[] array = new boolean[parts.length];
		for (int i = 0; i < parts.length; i++) {

			if (UUtilsTypes.isBoolean(parts[i])) {
				array[i] = Boolean.parseBoolean(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean isByteArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replaceAll(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		byte[] array = new byte[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isByte(parts[i])) {
				array[i] = (byte) (convertObjectToInt(parts[i]) & 0xff);
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean isIntArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		int[] array = new int[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isInt(parts[i])) {
				array[i] = convertObjectToInt(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean isLongArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		long[] array = new long[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isLong(parts[i])) {
				array[i] = convertObjectToLong(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean isFloatArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		float[] array = new float[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isFloat(parts[i])) {
				array[i] = convertObjectToFloat(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean isDoubleArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		double[] array = new double[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isDouble(parts[i])) {
				array[i] = convertObjectToDouble(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean isStringArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		String[] array = new String[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isString(parts[i])) {
				array[i] = convertObjectToString(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}
	
	public static boolean isDateArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		String[] array = new String[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isDate(parts[i])) {
				array[i] = convertObjectToString(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}
	
	public static boolean isDatetimeArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		String[] array = new String[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isDatetime(parts[i])) {
				array[i] = convertObjectToString(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}
	
	public static boolean isTimestampArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		String[] array = new String[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isTimestamp(parts[i])) {
				array[i] = convertObjectToString(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}
	
	public static boolean isYearArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return false;
		}
		if (value.endsWith("//]")) {
			return false;
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		String[] array = new String[parts.length];
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isYear(parts[i])) {
				array[i] = convertObjectToString(parts[i]);
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean isEmail(Object value) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(value.toString());
		return m.matches();
	}

	public static boolean isPassword(Object value) {

		if (value.toString().length() == 128) {
			return true;
		}

		// al menos un d�gito
		// al menos una min�scula
		// al menos una may�scula
		// no est�n permitidos los espacios
		// al menos 8 caracteres
		String password = UUtilsTypes.convertObjectToString(value);
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
		return password.matches(pattern);
	}
	
	public static boolean isDni(Object value) {

		String nif = UUtilsTypes.convertObjectToString(value);

		if (nif.toUpperCase().startsWith("X") || nif.toUpperCase().startsWith("Y")
				|| nif.toUpperCase().startsWith("Z")) {
			nif = nif.substring(1);
		}

		Pattern nifPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher m = nifPattern.matcher(nif);

		if (m.matches()) {

			String letra = m.group(2);

			// extrae letra del NIF
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

			int dni = Integer.parseInt(m.group(1)) % 23;
			String reference = letras.substring(dni, dni + 1);

			return (reference.equalsIgnoreCase(letra)) ? true : false;
	
		} else {
			return false;
		}
	}

	public static boolean isURL(Object value) {
		try {
			new URL(UUtilsTypes.convertObjectToString(value));
		} catch (MalformedURLException e) {
			return false;
		}
		return true;
	}

	// http://stackoverflow.com/questions/20725761/validate-credit-card-number-using-luhn-algorithm
	public static boolean isCreditCard(Object value, String cn) {

		String card = UUtilsTypes.convertObjectToString(value);
		String checkString = "" + cn;
		int check = Integer.parseInt(checkString);

		// drop the last digit.
		card = card.substring(0, (card.length() - 1));

		// reverse the digits.
		String cardrev = new StringBuilder(card).reverse().toString();

		// store it in an int array.
		char[] cardArray = cardrev.toCharArray();
		int[] cardWorking = new int[cardArray.length];
		int addedNumbers = 0;

		for (int i = 0; i < cardArray.length; i++) {
			cardWorking[i] = Character.getNumericValue(cardArray[i]);
		}

		// double odd positioned digits (which are really even in our case,
		// since index starts at 0).
		for (int j = 0; j < cardWorking.length; j++) {
			if ((j % 2) == 0) {
				cardWorking[j] = cardWorking[j] * 2;
			}
		}

		// subtract 9 from digits larger than 9
		for (int k = 0; k < cardWorking.length; k++) {
			if (cardWorking[k] > 9) {
				cardWorking[k] = cardWorking[k] - 9;
			}
		}

		// add all the numbers together.
		for (int l = 0; l < cardWorking.length; l++) {
			addedNumbers += cardWorking[l];
		}

		// finally, check if the number we got from adding all the other numbers
		// when divided by ten has a remainder equal to the check number.
		return (addedNumbers % 10 == check) ? true : false;
	}

	public static boolean isIPv4(Object value) {
		
		String ip = UUtilsTypes.convertObjectToString(value);
	    try {
	        Object res = InetAddress.getByName(ip);
	        return res instanceof Inet4Address || res instanceof Inet6Address;
	    } catch (final UnknownHostException exception) {
	        return false;
	    }
	}

	public static boolean isIPv6(Object value) {
		String ip = UUtilsTypes.convertObjectToString(value);
		Pattern pattern = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}");
		return pattern.matcher(ip).matches();
	}

	public static boolean isPort(Object value) {
		return (isInt(value) && (convertObjectToInt(value) >= 16) && (convertObjectToInt(value) <= 65535));
	}

	public static boolean isMacAddress(Object value) {
		String mac = UUtilsTypes.convertObjectToString(value);
		Pattern p = Pattern.compile("^([a-fA-F0-9]{2}[:-]){5}[a-fA-F0-9]{2}$");
		Matcher m = p.matcher(mac);
		return m.find();
	}

	public static boolean isMD5(Object value) {
		String md5 = UUtilsTypes.convertObjectToString(value);
		return md5.matches("[a-fA-F0-9]{32}");
	}

	public static boolean isHexColor(Object value) {
		String hexColor = UUtilsTypes.convertObjectToString(value);
		Pattern pattern = Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
		Matcher matcher = pattern.matcher(hexColor);
		return matcher.matches();
	}

	public static boolean isFQDN(Object value) {
		String fqdn = UUtilsTypes.convertObjectToString(value);
		Pattern pattern = Pattern.compile("([A-Za-z0-9-]+(-[A-Za-z0-9-]+)*.){3,}[A-Za-z0-9-]+(-[A-Za-z0-9-]+)*");
		Matcher matcher = pattern.matcher(fqdn);
		return matcher.matches();
	}

	public static boolean isFile(Object value) {
		File file = new File(value.toString());
		return file.isFile();
	}

	public static boolean isFilename(Object value) {

		if (value != null) {

			String valueStr = convertObjectToString(value);
			if ((valueStr.length() > 0) && (valueStr.length() <= 256)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isFilenameWithExtension(Object value) {

		if ((value != null) && (isFilename(value))) {

			String valueStr = convertObjectToString(value);
			int pos = valueStr.indexOf(".");
			if ((pos > 0) && (pos < valueStr.length())) {
				return true;
			}
		}

		return false;
	}

	public static boolean isDirectory(Object value) {
		File file = new File(value.toString());
		return file.isDirectory();
	}

	public static Boolean convertObjectToBoolean(Object value) {
		try {
			return Boolean.parseBoolean(String.valueOf(value));
		} catch (Exception e) {
			return false;
		}
	}

	public static byte convertObjectToByte(Object value) {
		try {
			return Byte.parseByte(String.valueOf(value));
		} catch (Exception e) {
			return 0;
		}
	}

	public static Integer convertObjectToInt(Object value) {
		try {
			return Integer.parseInt(String.valueOf(value));
		} catch (Exception e) {
			return 0;
		}
	}

	public static long convertObjectToLong(Object value) {
		try {
			return Long.parseLong(String.valueOf(value));
		} catch (Exception e) {
			return 1;
		}
	}

	public static float convertObjectToFloat(Object value) {
		try {
			return Float.parseFloat(String.valueOf(value));
		} catch (Exception e) {
			return 1;
		}
	}

	public static double convertObjectToDouble(Object value) {
		try {
			return Double.parseDouble(String.valueOf(value));
		} catch (Exception e) {
			return 1;
		}
	}

	public static String convertObjectToString(Object value) {
		try {
			return String.valueOf(value);
		} catch (Exception e) {
			return "";
		}
	}

	public static Date convertObjectToDate(Object date) {
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			return df.parse(convertObjectToString(date));
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date convertObjectToDatetime(Object date) {
		try {
			DateFormat df = new SimpleDateFormat(DATETIME_FORMAT);
			df.setLenient(false);
			return df.parse(convertObjectToString(date));
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date convertObjectToTimestamp(Object date) {
		try {
			DateFormat df = new SimpleDateFormat(TIMESTAMP_FORMAT);
			df.setLenient(false);
			return df.parse(convertObjectToString(date));
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date convertObjectToYear(Object date) {
		try {
			DateFormat df = new SimpleDateFormat(YEAR_FORMAT);
			df.setLenient(false);
			return df.parse(convertObjectToString(date));
		} catch (ParseException e) {
			return null;
		}
	}


	public static byte[] convertObjectToBLOB(Object value) {

		try {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(baos);
			oos.writeObject(value);
			return baos.toByteArray();

		} catch (Exception e) {
			return new byte[0];
		}
	}

	public static Object convertBLOBtoObject(Object value) {

		try {
			byte[] st = (byte[]) value;
			ByteArrayInputStream baip = new ByteArrayInputStream(st);
			ObjectInputStream ois;
			ois = new ObjectInputStream(baip);
			return ois.readObject();

		} catch (Exception e) {
			return null;
		}
	}
	public static List<Byte> convertStringtoByteArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return Collections.emptyList();
		}
		if (value.endsWith("//]")) {
			return Collections.emptyList();
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		ArrayList<Byte> array = new ArrayList<Byte>();
		for (int i = 0; i < parts.length - 1; i++) {

			if (UUtilsTypes.isByte(parts[i])) {
				array.add((byte) (convertObjectToInt(parts[i]) & 0xff));
			} else {
				return Collections.emptyList();
			}
		}

		return array;
	}

	public static List<Integer> convertStringtoIntArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return Collections.emptyList();
		}
		if (value.endsWith("//]")) {
			return Collections.emptyList();
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < parts.length; i++) {

			if (UUtilsTypes.isInt(parts[i])) {
				array.add(convertObjectToInt(parts[i]));
			} else {
				return Collections.emptyList();
			}
		}

		return array;
	}



	public static List<Double> convertStringtoDoubleArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return Collections.emptyList();
		}
		if (value.endsWith("//]")) {
			return Collections.emptyList();
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		ArrayList<Double> array = new ArrayList<Double>();
		for (int i = 0; i < parts.length; i++) {

			if (UUtilsTypes.isDouble(parts[i])) {
				array.add(convertObjectToDouble(parts[i]));
			} else {
				return Collections.emptyList();
			}
		}

		return array;
	}

	public static List<String> convertStringtoStringArray(String value) {

		value = value.trim();
		if (value.startsWith("//[")) {
			return Collections.emptyList();
		}
		if (value.endsWith("//]")) {
			return Collections.emptyList();
		}
		value = value.replace(PATTERN_BRACKETS, "");
		value = value.replace(" ", "");

		String[] parts = value.split(",");
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < parts.length; i++) {

			if (UUtilsTypes.isString(parts[i])) {
				array.add(convertObjectToString(parts[i]));
			} else {
				return Collections.emptyList();
			}
		}

		return array;
	}
}
