package week4.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableTestLeaf1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement elementTable = driver.findElement(By.id("table_id"));
		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		WebElement row1 = rows.get(1);
		List<WebElement> columns = row1.findElements(By.tagName("td"));
		System.out.println(columns.size());
		for (int i = 1; i < rows.size(); i++) {
			WebElement eachRow = rows.get(i);
			WebElement column1 = eachRow.findElements(By.tagName("td")).get(0);
			if (column1.getText().contains("Learn to interact with Elements")) {
			WebElement progress = eachRow.findElements(By.tagName("td")).get(1);
			System.out.println(progress.getText());
			}
		}

	}

}
