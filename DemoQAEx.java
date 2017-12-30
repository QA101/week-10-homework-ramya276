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

public class DemoQAEx {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marut\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.navigate().to("http://demoqa.com");
		driver.manage().window().maximize();
		driver.get("http://demoqa.com");
		
		WebElement w=driver.findElement(By.partialLinkText("Registration"));
		w.click();
		if(driver.getCurrentUrl().contains("registration")) {
			System.out.println("We made it!!!!");	
		}
	
		driver.findElement(By.id("name_3_firstname")).sendKeys("Tamya");
		driver.findElement(By.id("name_3_lastname")).sendKeys("Elusamy");
		//Country --> id="dropdown_7" not a very clear naming convention hence use variables
		Select country=new Select(driver.findElement(By.id("dropdown_7")));
		country.selectByValue("India");
		//radio button
		List<WebElement> status=driver.findElements(By.name("radio_4[]"));
		for(WebElement we: status) {
			if(we.getAttribute("value").equals("married")) {
				we.click();
			}
		}
		List<WebElement> hobby=driver.findElements(By.name("checkbox_5[]"));
		for(WebElement chk:hobby) {
			System.out.println(chk);
			if(chk.getAttribute("value").equals("dance")) {
				chk.click();
				//if(chk.getAttribute("value").equals("reading"))
				//chk.click();
			}
		}
		//Date of Birth
		Select month=new Select(driver.findElement(By.id("mm_date_8")));
		month.selectByValue("5");
		Select date=new Select(driver.findElement(By.id("dd_date_8")));
		date.selectByValue("28");
		Select year=new Select(driver.findElement(By.id("yy_date_8")));
		year.selectByValue("1967");
		
		//PhoneNo
		driver.findElement(By.id("phone_9")).sendKeys("4256867334");
		driver.findElement(By.id("username")).sendKeys("r4kk4r1");
		driver.findElement(By.id("email_1")).sendKeys("r4kk4r1@gmail.com");
		driver.findElement(By.id("profile_pic_10")).sendKeys("C:\\Users\\Marut\\Desktop\\a894158733716e983680fb427ed6496b.jpg");
		driver.findElement(By.id("description")).sendKeys("All is Well");
		driver.findElement(By.id("password_2")).sendKeys("aroplane890!@A");
		driver.findElement(By.id("confirm_password_password_2")).sendKeys("aroplane890!@A");
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenShot(scrFile, "1");
		//driver.quit();
	
		driver.findElement(By.name("pie_submit")).click();
		try{
			Thread.sleep(7000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenShot(scrFile, "2");	
		
	}
	public static void screenShot(File scrFile, String s) {
		
		try {
		Files.copy(scrFile,  new File("R:\\SeleniumJava\\screenshot"+s+".png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
}
