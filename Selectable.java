package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement element1 = driver.findElement(By.xpath("//li[text() = 'Item 1']"));
		WebElement element2 = driver.findElement(By.xpath("//li[text() = 'Item 2']"));
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(element1).click(element2).keyUp(Keys.CONTROL).perform();
	}

}
