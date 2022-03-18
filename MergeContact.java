package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//img)[1]")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> allwindowHandlesList = new ArrayList<String>(windowHandlesSet);
		String newWindow = allwindowHandlesList.get(1);
		driver.switchTo().window(newWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-panel-ml']//a[@class='linktext'])[1]")).click();
		String newWindow1 = allwindowHandlesList.get(0);
		driver.switchTo().window(newWindow1);
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//img)[2]")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> allwindowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		String newWindow2 = allwindowHandlesList1.get(1);
		driver.switchTo().window(newWindow2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-panel-ml']//a[@class='linktext'])[6]")).click();
		driver.switchTo().window(newWindow1);
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//a)[3]")).click();
Alert alert = driver.switchTo().alert();
alert.accept();
System.out.println(driver.getTitle());
if (driver.getTitle().contains("View Contact")) {
	System.out.println("i confirm the title has View Contact");
}
else {
	System.out.println("i confirm the title doesn't have View Contact");

}
	}

}
