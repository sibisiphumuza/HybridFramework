package constants;

public final class GlobalConstants {
	
	private GlobalConstants() {}
	
	public static final String RUNSETUP = System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\RunSetup.csv";
	public static final String OBJECT_PROPERTIES = System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\object.properties";
	public static final String SCREENSHOT_FOLDER = System.getProperty("user.dir")+"\\Screenshots\\";
	public static final String EXTENTREPORT_HTML = System.getProperty("user.dir")+"\\ExtentReports\\ExtentReports.html";
	public static final String EXTENTREPORT_CONFIG = System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\ExentReport.properties";

}