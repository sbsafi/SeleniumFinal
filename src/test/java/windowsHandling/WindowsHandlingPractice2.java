package windowsHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlingPractice2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		WebElement testSelenium = driver.findElement(By.linkText("Test Selenium"));
		testSelenium.click();
		
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		while(it.hasNext()) {
			String child = it.next();
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				break;
			}
		}
		WebElement dropDown = driver.findElement(By.linkText("Drop Down"));
		dropDown.click();
		
		WebElement element = driver.findElement(By.id("programmingLanguageSelect"));
		Select select = new Select(element);
		Thread.sleep(2000);
		select.selectByValue("java");
		Thread.sleep(2000);
		select.selectByVisibleText("Erlang");
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
