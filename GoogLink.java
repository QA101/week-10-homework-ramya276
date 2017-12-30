import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.google.common.io.Files;
		

public class GoogLink {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marut\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.navigate().to("http://demoqa.com");
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Ramya Velusamy+Issaquah+LinkedIn Profile");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenShot(scrFile, "1");
		driver.findElement(By.name("btnK")).submit();
		
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenShot(scrFile, "2");
		try {
			Thread.sleep(7000);
		}catch(Exception e){
			e.printStackTrace();
		}
		  List<WebElement> result = driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a"));
		  String firstLink = result.get(0).getAttribute("href");
		  driver.navigate().to(firstLink);
		  driver.navigate();
		  scrWait(4000);
		  driver.switchTo().activeElement();
		  scrWait(4000);
		  driver.findElement(By.partialLinkText("Sign in")).click();
		  driver.switchTo().activeElement();
		  driver.findElement(By.id("login-email")).sendKeys("r4kk4r@gmail.com");
		  driver.findElement(By.id("login-password")).sendKeys("270685rk");
		  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  screenShot(scrFile, "3");
		  driver.findElement(By.id("login-submit")).submit();
		  scrWait(3000);
		  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  screenShot(scrFile, "4");
	}
	
	public static void screenShot(File scrFile, String s) {	
		try {
		Files.copy(scrFile,  new File("R:\\SeleniumJava\\GoogLinkScrSht"+s+".png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void scrWait(long waitTime) {
		try {
			Thread.sleep(waitTime);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
