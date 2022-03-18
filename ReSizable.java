package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReSizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.executeScript("javascript:window.scrollBy(250,350)");
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("(//div[contains(@class,'ui-resizable-handle ui')])[3]"));
//		Point location = element1.getLocation();
//		int x = location.getX();
//		int y = location.getY();
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(element1, 200,200).perform();
	}

}
