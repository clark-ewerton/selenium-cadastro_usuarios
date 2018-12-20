package br.ce.wcarquivo.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	};

	public static WebDriver getDriver() {
		// driver para Chrome
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		
		//driver para Firefox
		System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
		
		//driver para IE
		System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");

		// driver para Chrome
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\CLARK\\Documents\\selenium\\chromedriver.exe");
		 */

		if (driver == null) {
			switch (Propriedades.browser) {
			case CHROME:
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case IE:
				driver = new InternetExplorerDriver();
				break;
			}

			driver.manage().window().setSize(new Dimension(1200, 765));
		}

		return driver;
	}

	public static void KillDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
