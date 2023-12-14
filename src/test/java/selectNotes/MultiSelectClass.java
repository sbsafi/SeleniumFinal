package selectNotes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		WebElement months = driver.findElement(By.name("Month"));
		Select selectMonths = new Select(months);
		selectMonths.selectByIndex(1);
		selectMonths.selectByIndex(2);
		selectMonths.selectByIndex(3);
		selectMonths.selectByIndex(4);
		selectMonths.selectByIndex(5);
		selectMonths.selectByIndex(6);
		List<WebElement> list = selectMonths.getAllSelectedOptions();

		for (WebElement elements : list) {
			System.out.println("All Selected Elements " + elements.getText());

		}
		if (selectMonths.isMultiple()) {
			System.out.println("This is Multi Select");
		} else {
			System.out.println("It is not multi Select");
		}
		driver.close();
	}

}
