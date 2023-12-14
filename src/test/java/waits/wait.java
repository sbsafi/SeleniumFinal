package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// here webdriver waits for 15 seconds before it throws an exception.
		// if the element appeared less than 15 seconds the rest of the seconds will be ignored.
		
		// Explicit Wait - it waits for a sepcific elements on the DOM to appears.
		WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		explicitwait.until(ExpectedConditions.elementToBeClickable(By.id("pass the value"))); 
		// Waits for the element to be clickable.
		explicitwait.until(ExpectedConditions.elementToBeSelected(By.className("pass the value")));
		// Waits for the element to be selected.
		
		
		// Fluent Wait- it is same as explicit wait with one more condition it will check on a regular
		// frequency.
		Wait <WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(25)) // waits for 25 seconds before it throws an exception.
			.pollingEvery(Duration.ofSeconds(5)); // Here we assign a frequency of attempts. every 5 seconds it checks if the element is present.
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email")));

	}

	}


