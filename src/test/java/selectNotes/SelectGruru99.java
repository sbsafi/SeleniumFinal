package selectNotes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectGruru99 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		
		List<WebElement> about = driver.findElements(By.xpath("//div[@class='dropdown-menu']//child::a"));
		
		for(int i = 0; i < about.size(); i++) {
			if(about.get(i).getText().equalsIgnoreCase("History")) {
				about.get(i).click();
				break;
			}
		}
		
		// Does not RUN !!!
		
		
	}

}
