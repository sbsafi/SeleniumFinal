package selectNotes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectFB {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		
		WebElement createAccount = driver.findElement(By.partialLinkText("Create"));
		createAccount.click();
		WebElement month =driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select select = new Select(month);
		select.selectByIndex(2);
		Thread.sleep(3000);
		select.selectByVisibleText("Jul");
		

	}

}
