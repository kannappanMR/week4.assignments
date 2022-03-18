package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndFrames1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("(//i[@class='fa fa-align-justify'])[1]")).click();
		driver.findElement(By.xpath("(//label[text()='FLIGHTS'])[1]")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandleslist = new ArrayList<String>(windowHandlesSet);
		String newWindow = windowHandleslist.get(1);
		driver.switchTo().window(newWindow);
		driver.findElement(By.xpath("(//a[@id='dropdown10'])[1]")).click();
		WebElement email = driver.findElement(By.xpath("(//a[@class = 'dropdown-item'])[3]"));
		System.out.println(email.getText());

		
		
		
		
		
		
	}

}
