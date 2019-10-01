package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Drivers {
  @Test
  public static WebDriver getdriver(String browser) {
	  if(browser.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browser.contentEquals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		return null;
		
	  
  }
}
