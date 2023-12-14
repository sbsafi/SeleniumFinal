package windowsHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlingPractice3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		WebElement themse = driver.findElement(By.linkText("Download"));

		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(themse).keyUp(Keys.CONTROL).build().perform();

		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		while (it.hasNext()) {
			String childTab = it.next();
			if (!parent.equals(childTab)) {
				driver.switchTo().window(childTab);
				break;
			}
		}
		WebElement radioBttn = driver.findElement(By.xpath("//input[@id='version-1.11.4']"));
		WebElement text = driver.findElement(By.xpath("//span[text()='(Legacy, for jQuery1.6+)']"));
		if (text.isDisplayed()) {
			text.getText();
		}
		if (radioBttn.isDisplayed() && !radioBttn.isSelected() && radioBttn.isEnabled()) {
			Thread.sleep(2000);
			radioBttn.click();
			System.out.println("Radio Button is clicked " + text.getText());
		}

		Thread.sleep(3000);
		driver.quit();

	}
}