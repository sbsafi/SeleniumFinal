package windowsHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		String parentTab = driver.getWindowHandle();
		WebElement openNewTab = driver.findElement(By.id("newWindowBtn"));
		openNewTab.click();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		while (it.hasNext()) {
			String childTab = it.next();
			System.out.println("Child Window info" + childTab);
			if (!parentTab.equals(childTab)) {
				driver.switchTo().window(childTab);
				driver.manage().window().maximize();
				break;
			}

		}
		WebElement firsttName = driver.findElement(By.id("firstName"));
		Thread.sleep(3000);
		firsttName.sendKeys("Sohrab");
		WebElement lastName = driver.findElement(By.id("lastName"));
		Thread.sleep(3000);
		lastName.sendKeys("Safi");
		Thread.sleep(3000);
		WebElement maleRadioBttn = driver.findElement(By.id("malerb"));
		if (maleRadioBttn.isDisplayed() && maleRadioBttn.isEnabled() && !maleRadioBttn.isSelected()) {
			maleRadioBttn.click();
		}
		Thread.sleep(3000);
		WebElement eNglish = driver.findElement(By.id("englishchbx"));
		if(eNglish.isDisplayed() && eNglish.isEnabled() && !eNglish.isSelected() ) {
			eNglish.click();
		}
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("email"));
		Thread.sleep(3000);
		email.sendKeys("sohrab.safi@gmail.com");
		Thread.sleep(3000);
		WebElement pass = driver.findElement(By.id("password"));
		Thread.sleep(3000);
		pass.sendKeys("1234Safi");
		WebElement register = driver.findElement(By.id("registerbtn"));
		Thread.sleep(3000);
		register.click();
		Thread.sleep(3000);
		WebElement msg = driver.findElement(By.id("msg"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("No msg shown here");
		wait.until(ExpectedConditions.visibilityOf(msg));
		System.out.println("The msg from Registeration page " + msg.getText());	
		driver.close();
		
		
	}
}
