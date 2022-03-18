package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement element = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		WebElement countOfItems = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		System.out.println(countOfItems.getText());
		driver.findElement(By.xpath("//div[text() = 'Training Shoes']")).click();
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class = 'input-filter'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class = 'input-filter'])[1]")).sendKeys("900");
		driver.findElement(By.xpath("(//input[@class = 'input-filter'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class = 'input-filter'])[2]")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn btn-line')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='filter-color-tile Yellow ']")).click();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		builder.moveToElement(element1).perform();
		driver.findElement(By.xpath("//div[@class = 'center quick-view-bar  btn btn-theme-secondary  ']")).click();
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File img = new File("./snaps/img001.jpg");
		FileUtils.copyFile(screenshot, img);
		WebElement price = driver.findElement(By.xpath("(//div[@class=' pdp-e-i-PAY clearfix']//span)[2]"));
		System.out.println(price.getText());
		WebElement discountPercentage = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		System.out.println(discountPercentage.getText());
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		driver.close();

	}
}
