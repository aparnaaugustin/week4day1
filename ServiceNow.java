package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev113545.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"b55b4ab0c0a80009007a9c0f03fb4da9\"]/div/div"));
		element.click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		WebElement caller = driver.findElement(By.id("sys_display.incident.caller_id"));
		caller.sendKeys("abel.tuter@example.com");
		caller.click();
		driver.findElement(By.id("incident.short_description")).sendKeys("Email issue");;
		String incidentno = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The incident number is : "+incidentno);
		Thread.sleep(5000);
		driver.findElement(By.id("sysverb_insert")).click();
		WebElement element2 = driver.findElement(By.xpath("//input[@class='form-control']"));
		element2.sendKeys(incidentno);
		Thread.sleep(5000);
		element2.sendKeys(Keys.ENTER);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps2/page.png"); 
		FileUtils.copyFile(src, dest);
		driver.close();
		
		
		//.sendKeys("Abel Tuter");
	}

}
