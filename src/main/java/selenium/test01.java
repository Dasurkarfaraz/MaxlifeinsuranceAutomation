package selenium;

import java.io.FileWriter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

public class test01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.maxlifeinsurance.com/term-insurance-plans");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		try {
			driver.findElement(By.xpath("//span[@class='jsx-2824934979 close-icon']")).click();
		} catch (Exception e) {}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,680)", "");
		
		driver.findElement(By.xpath("//label[normalize-space()='Your Name']")).click();
		driver.findElement(By.xpath("//input[@id=\"fullName\"]")).sendKeys("Faraz");
		driver.findElement(By.xpath("//input[@id=\"dob\"]")).sendKeys("22091998");
		driver.findElement(By.xpath("//span[normalize-space()='3 - 5']")).click();
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9878676756");
		String currentHandle= driver.getWindowHandle();
		driver.findElement(By.xpath("//button[normalize-space()='Check Premium']")).click();
		for(String actual: driver.getWindowHandles()) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
			driver.switchTo().window(actual);
			}
		}
		driver.findElement(By.xpath("//span[normalize-space()='Salaried']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Graduate & Above']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Monthly Premium']")).isDisplayed();
		String month=driver.findElement(By.xpath("//a[normalize-space()='Monthly Premium']")).getText();
		String path = "C:\\Users\\faraz\\eclipse-workspace\\selenium\\src\\main\\java\\file.txt";
		FileWriter fd = new FileWriter(path);
		fd.write(month);
		fd.write("\n");
		fd.write("qwertyu");
		fd.close();
		driver.quit();
	}

}
