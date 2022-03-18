package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev54857.service-now.com/navpage.do");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Siemens12$");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> allWindowHandlesList = new ArrayList<String>(windowHandlesSet);
		String newWindow = allWindowHandlesList.get(1);
		driver.switchTo().window(newWindow);
		driver.findElement(By.xpath("(//a[@class ='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(allWindowHandlesList.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.id("lookup.incident.short_description")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> allWindowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		String newWindow1 = allWindowHandlesList1.get(1);
		driver.switchTo().window(newWindow1);
		driver.findElement(By.linkText("Issue with a web page")).click();
		driver.switchTo().window(allWindowHandlesList.get(0));
		String IncidentNumber = "INC0010039";
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(IncidentNumber,Keys.ENTER);
	}
	}
	

