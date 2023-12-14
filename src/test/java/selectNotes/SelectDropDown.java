package selectNotes;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://tek-retail-ui.azurewebsites.net/");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(2000);
	
	WebElement dropDown = driver.findElement(By.id("search"));
	Select select = new Select(dropDown);
	select.selectByIndex(1);
	Thread.sleep(3000);
	select.selectByValue("3");
	Thread.sleep(3000);
	select.selectByVisibleText("Automative");
	driver.close();
	
	
	
	
	
	
	
	
	
	
	}

}
