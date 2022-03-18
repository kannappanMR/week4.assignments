package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		WebElement element = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println(element.getText());
		WebElement element1 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		System.out.println(element1.getText());
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]"))
				.click();
		WebElement element2 = driver
				.findElement(By.xpath("(//table[@id='histogramTable']//a[@class = 'a-link-normal'])[2]"));
		System.out.println(element2.getText());
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		String newWindow = windowHandlesList.get(1);
		driver.switchTo().window(newWindow);
		driver.findElement(By.id("add-to-cart-button")).click();
		WebElement subTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		System.out.println(subTotal.getText());
		
	}
}



