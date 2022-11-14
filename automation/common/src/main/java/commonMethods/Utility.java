package commonMethods;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class Utility {
	public static final String webElements_Property_File_Path = "PropertyFiles/webElements.properties";
	public static final String envConfig_Property_File_Path = "PropertyFiles/envConfig.properties";
	// Method to fetch value using key of it from config property file
	public static String fetchConfigPropertyValue(String key) throws IOException {
		InputStream is = Utility.class.getClassLoader().getResourceAsStream(envConfig_Property_File_Path);
		Properties property = new Properties();
		property.load(is);
		return property.getProperty(key);
	}
	// Method to fetch value using key of it from config property file
	public static String fetchElementPropertyValue(String key) throws IOException {
 		InputStream is = Utility.class.getClassLoader().getResourceAsStream(webElements_Property_File_Path);
		Properties property = new Properties();
		property.load(is);
		return property.getProperty(key);
	}
	public static String fetchLocatorKey(String value) {
		String userDefinedKey = "";
		InputStream is = null;
		try {
			is = Utility.class.getClassLoader().getResourceAsStream("PropertyFiles/webElements.properties");
			Properties property = new Properties();
			property.load(is);
			Enumeration<?> e = property.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String originalKeyName = property.getProperty(key);
				if (originalKeyName.equals(value)) {
					userDefinedKey = key;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in fetchLocatorKey method, " + e.getMessage());
		} finally {
			try {
				if (null != is)
					is.close();
			} catch (Exception e) {
				System.out.println("Exception in fetchLocatorKey method, " + e.getMessage());
			}
		}
		return userDefinedKey;
	}
	public static String capture(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Report/screenshots/" + screenShotName + ".png";
		File destination = new File(dest);
		FileHandler.copy(source, destination);
		return dest;
	}
	// Method to check whether value is Not null or empty
	public static boolean isNotEmpty(String value) {
		if (!value.equalsIgnoreCase("null") && !value.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	// Method to check whether value is null or empty
	public static boolean isEmpty(String value) {
		if (value.equalsIgnoreCase("null") || value.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	// Log file Code
	public static boolean WriteLog(String content) {
		boolean flag = false;
		String newline = System.getProperty("line.separator");
		String FilePath = System.getProperty("user.dir") + "/Report/" + "AutditTrax.log";
		content = content + newline;
		try {
			FileWriter fstream = new FileWriter(FilePath, true);
			for (int i = 0; i < content.length(); i++) {
				fstream.append(content.charAt(i));
			}
			fstream.close();
			return true;
		} catch (Exception ex) {
			flag = false;
		}
		return flag;
	}
	// Convert String to integer
	public static Integer parseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException ex) {
			System.out.println("Parsing is failed, for value :: " + value);
			return -100;
		}
	}
}
