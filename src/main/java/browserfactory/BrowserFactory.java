package browserfactory;

public class BrowserFactory  {
	
	public static BrowserManager getDriverManager(String browser) {
        BrowserManager driverManager; 
             
        switch (browser) {
		case "chrome":
        	driverManager = new ChromeDriverManager();
			break;
		case "edge":
        	driverManager = new EdgeDriverManager();
        	break;
		case "firefox": 
			driverManager = new FirefoxDriverManager();
			break;
		default:
			throw new IllegalArgumentException(browser);
		}
        
        return driverManager;
    }
    
}
