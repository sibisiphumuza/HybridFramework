package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements BrowserManager{
	WebDriver driver;

	public WebDriver initDriver() {
			
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(firefoxOptions);
		
		driver.manage().window().maximize();	
		
		return driver;
	}

}
