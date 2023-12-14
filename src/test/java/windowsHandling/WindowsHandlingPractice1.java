package windowsHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlingPractice1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		String parent = driver.getWindowHandle();
		WebElement selenium = driver.findElement(By.linkText("Test Selenium"));
		Thread.sleep(2000);
		selenium.click();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		while(it.hasNext()) {
			String child = it.next();
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				break;
			}
		}
		
		WebElement radiobttn = driver.findElement(By.linkText("Radio Button"));
		radiobttn.click();
		WebElement text = driver.findElement(By.xpath("//p[text()='please choose your favorite contact method']"));
		if(text.isDisplayed()) {
			System.out.println(text.getText());
		}
		
		WebElement email = driver.findElement(By.id("email"));
		if(email.isDisplayed() && email.isEnabled() && !email.isSelected()) {
			email.click();
			System.out.println("email radioBttn is selected " );
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} 

}
