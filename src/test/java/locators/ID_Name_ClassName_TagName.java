package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ID_Name_ClassName_TagName {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement element1 = driver.findElement(By.id("searchInput"));  // //input[@id='searchInput']
		element1.click();
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.id("searchInput"));
		element2.sendKeys("Logitech C920x HD Pro Webcam");
		WebElement element3 = driver.findElement(By.id("searchBtn"));
		element3.click();
		WebElement element4 = driver.findElement(By.tagName("a"));
		System.out.println(element4.getText()+ " is present on the DOM");
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}

}
