package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PressTab_PressEnter {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchField = driver.findElement(By.id("searchInput"));
		searchField.sendKeys("amazon fire tv");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.TAB)
		.keyUp(Keys.TAB)
		.keyDown(Keys.ENTER)
		.keyUp(Keys.ENTER)
		.build().perform();
		
		
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
