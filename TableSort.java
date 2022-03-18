package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableSort {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement elementTable = driver.findElement(By.xpath("//table[@class='display dataTable no-footer']"));
		List<WebElement> row = elementTable.findElements(By.tagName("tr"));
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < row.size(); i++) {
			WebElement eachRow = row.get(i);
			WebElement column1 = eachRow.findElements(By.tagName("td")).get(1);
			String names = column1.getText();
			list.add(names);
		}
		Collections.sort(list);
		System.out.println(list);
		driver.findElement(By.className("sorting")).click();
		List<WebElement> row1 = elementTable.findElements(By.tagName("tr"));
		List<String> list1 = new ArrayList<String>();
		for (int j = 1; j < row1.size(); j++) {
			WebElement eachRow1 = row1.get(j);
			WebElement column = eachRow1.findElements(By.tagName("td")).get(1);
			String names1 = column.getText();
			list1.add(names1);
	}
		System.out.println(list1);
		boolean equals = list.equals(list1);
		System.out.println(equals);
}
}
