package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * @author nguyenlm Contains helper functions
 */
public class Utils {
	// SRP: Lớp này là GodClass khi nhận đa trách nhiệm :DateFormat và Logger

	//Violate SRP
	//coincidental cohesion: DATE_FORMATTER
	//solution: nên tách riêng vào 1 class DateUtil
	// singleton: use private static final for Logger and Date_Formatter
	public static DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	//coincidental cohesion: LOGGER, getLogger()
	//solution: nên tách riêng vào 1 class LoggerUtil
	private static Logger LOGGER = getLogger(Utils.class.getName());
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-4s] [%1$tF %1$tT] [%2$-7s] %5$s %n");
	}

	public static Logger getLogger(String className) {
		return Logger.getLogger(className);
	}

}