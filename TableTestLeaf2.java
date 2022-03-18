package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableTestLeaf2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<Integer> list = new ArrayList<Integer>();
for (int i = 1; i < rows.size(); i++) {
	WebElement eachRow = rows.get(i);
	List<WebElement> column = eachRow.findElements(By.tagName("td"));
	WebElement column1 = column.get(1);
	String progressData = column1.getText();
	String replace = progressData.replace("%", "");
	int parseInt = Integer.parseInt(replace);
	list.add(parseInt);
}
Collections.sort(list);
Integer integer = list.get(0);
driver.findElement(By.xpath("//td[contains(text(),'"+integer+"')]/following::input")).click();

	}
}
