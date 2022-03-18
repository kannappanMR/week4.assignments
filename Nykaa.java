package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement element = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		String pageTitle = driver.getTitle();
		if (pageTitle.contains("L'Oreal Paris")) {
			System.out.println("I confirm the title contains the L'Oreal Paris");
		} else {
			System.out.println("I confirm the title doesn't contains L'Oreal Paris");
		}
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[@class='filter-name '])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[6]")).click();
		WebElement allItem = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]"));
		if (allItem.getText().contains("Shampoo")) {
			System.out.println("The filter is applied with shampoo");
		}
		else {
			System.out.println("The filter is not applied with shampoo");
		}
		driver.findElement(By.xpath("(//img[@class='css-11gn9r6'])[1]")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		String newWindow = windowHandlesList.get(1);
		driver.switchTo().window(newWindow);
		WebElement elementDropDown = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
		Select dd = new Select(elementDropDown);
		dd.selectByIndex(1);
		WebElement mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
		System.out.println(mrp.getText());
		driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='css-1tny7j1 e1ewpqpu0']//div)[3]")).click();
		WebElement grandTotal = driver.findElement(By.xpath("(//div[@class='sticky-bottom proceed-cart-btn']//div)[3]"));
        System.out.println(grandTotal.getText());
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();	
	}
}
