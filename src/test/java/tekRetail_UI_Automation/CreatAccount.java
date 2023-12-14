package tekRetail_UI_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatAccount {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Thread.sleep(3000);
		WebElement signIn = driver.findElement(By.id("signinLink"));
		signIn.click();
		WebElement createAccnt = driver.findElement(By.id("newAccountBtn"));
		createAccnt.click();
		WebElement nameInput = driver.findElement(By.id("nameInput"));
		nameInput.sendKeys("Sohrab");
		WebElement email = driver.findElement(By.id("emailInput"));
		email.sendKeys("sohrab.safi1@gmail.com");
		WebElement pass = driver.findElement(By.id("passwordInput"));
		pass.sendKeys("123Afghan$");
		WebElement confirmPass = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		confirmPass.sendKeys("123Afghan$");
		WebElement signUp = driver.findElement(By.id("signupBtn"));
		if (pass == confirmPass) {
			signUp.click();
		}else { 
			System.out.println("Password does not match the requirement.");
			
		}
		
		
		
		
		

	}

}
