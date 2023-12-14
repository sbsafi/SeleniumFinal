package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PressControlToOpenWithANewWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement themes = driver.findElement(By.linkText("Themes"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL)
		.click(themes)
		.keyUp(Keys.CONTROL)
		.build().perform();
		Thread.sleep(3000);
		
		
		
		
		// This line of code is gonna open "Themes" link in a new window by using Keys.CONTROL methode.
		
		

	}

}
