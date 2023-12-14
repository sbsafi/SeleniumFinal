package tekRetail_UI_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);

		WebElement signIn = driver.findElement(By.id("signinLink"));
		signIn.click();
		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("sohrab.safi1@gmail.com");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("123Afghan$");
		WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
		logIn.click();

		
		String expectedTitle = "React App";
		String actualTitle = driver.getTitle();
		
		if (expectedTitle.equals(actualTitle) ) {
			System.out.println("user loged in succesffuly with credentials .");

		} else {
			System.out.println("LogIn is faild");

		}
		
		WebElement account = driver.findElement(By.id("accountLink"));
		account.click();
		WebElement phone = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
		phone.sendKeys("8179338749");
		WebElement update = driver.findElement(By.xpath("//button[@id='personalUpdateBtn']"));
		update.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(3000);
	}

}
