package windowsHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowshandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		String parentTab = driver.getWindowHandle();
		System.out.println("This is the Parent Window info" + parentTab);
		WebElement testSelenium = driver.findElement(By.linkText("Test Selenium"));
		testSelenium.click();
		Set<String> allTabs = driver.getWindowHandles();
		Iterator<String> it = allTabs.iterator();
		while (it.hasNext()) {
			String childTabs = it.next();
			if (!parentTab.equals(childTabs)) {
				driver.switchTo().window(childTabs);
				break;
			}
		}
		Thread.sleep(2000);
		WebElement addElement = driver.findElement(By.id("addBtn"));
		addElement.click();
		Thread.sleep(2000);
		WebElement remove = driver.findElement(By.xpath("//button[text()='Remove']"));
		remove.click();
		driver.quit();
		
	}
	
}
