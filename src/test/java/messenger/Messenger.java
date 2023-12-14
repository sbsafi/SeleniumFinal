package messenger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Messenger {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.messenger.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		WebElement userID = driver.findElement(By.id("email"));
		String email = "sohrab_safi_ait@yahoo.com";
		userID.sendKeys(email);
		Thread.sleep(2000);
		String pass = "286 safi";
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys(pass);
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		Thread.sleep(2000);

		WebElement search = driver.findElement(By.xpath(
				"//*[@id=\"mount_0_0_2R\"]/div/div/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/label/span"));
		search.sendKeys("Elhamuddin Safi");
		WebElement MiladSafi = driver.findElement(By.xpath("//*[@id=\"100063548624894\"]/div/a/div"));
		MiladSafi.click();
		Thread.sleep(2000);
		WebElement msg = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div/div[4]/div[2]/div/div/div[1]/p"));
		msg.sendKeys("This text is sent through Automation/Selenium/Java");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/span[2]"));
		submit.click();
		WebElement account = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div/div/div[1]/div/div/div/svg/g/image"));
		account.click();
		WebElement logout = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div[1]/div/div/div[4]/div"));
		logout.click();

	}

}
