package uploadingFileInSelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingFile {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		WebElement testSelenium = driver.findElement(By.linkText("Test Selenium"));
		testSelenium.click();
		
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		while(it.hasNext()) {
			String child = it.next();
			System.out.println("This is the child's name " + child);
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				break;
				
			}
		}
		String uploadFile = System.getProperty("user.dir") + "\\ForUploading";
		WebElement fileBttn = driver.findElement(By.linkText("Upload Image"));
		fileBttn.click();
		WebElement upload = driver.findElement(By.id("fileInput"));
		upload.sendKeys(uploadFile);
		
		
		
		
		
		
	}

}
