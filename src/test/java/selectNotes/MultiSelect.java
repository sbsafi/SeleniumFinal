package selectNotes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		WebElement multiSelect = driver.findElement(By.name("Month"));
		Select selectall = new Select(multiSelect);
		selectall.selectByIndex(3);
		Thread.sleep(2000);
		selectall.selectByValue("July");
		Thread.sleep(2000);
		selectall.selectByVisibleText("August");
		Thread.sleep(2000);
		selectall.deselectAll();
		Thread.sleep(2000);
		selectall.selectByIndex(9);
		if (selectall.isMultiple()) {
			System.out.println("This is multi select");

		} else {
			System.out.println("This is not Multi Select option");

		}
		List<WebElement> list = selectall.getAllSelectedOptions();

		for (WebElement elements : list) {
			System.out.println(" List of elements " + elements.getText());

		}

	}

}
