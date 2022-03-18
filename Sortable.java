package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][1]"));
		WebElement element3 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][3]"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(element1, element3.getLocation().getX(), element3.getLocation().getY()).perform();
		}
}

