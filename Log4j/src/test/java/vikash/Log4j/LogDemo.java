package vikash.Log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
						//I created a maven project then created few folder named as drivers and jar 
					    //on desktop i created a notepad n wrote log4j configuration code n saved file named as Log4j.properties
public class LogDemo {  // copy that Log4j.properties file n paste into project level
					    //In jar folder i added selenium server jar and log4j.jar then build path
	public static void main(String[] args) {
				
		Logger log =Logger.getLogger("LogDemo");		
		PropertyConfigurator.configure("Log4j.properties");

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.info("Chrome opened");
		driver.manage().window().maximize();			// logs will be seen on console and also in [first refresh the project]
		log.info("Browser maximize");					// one log folder will be created, open it > double click on log file
		driver.get("https://www.facebook.com/");
		log.info("App launch");
		WebElement we =driver.findElement(By.xpath("//input[@type='text']"));
		log.info("Clicked on email textfield");
		we.sendKeys("vikash7044@gmail.com");
		log.info("email entered in username field");
		driver.close();
		log.info("window is closed");
	}
}