package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		driver.switchTo().frame(element);
		WebElement element2 = driver.findElement(By.id("Click"));
		element2.click();
		File src=element2.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/button.png"); 
		FileUtils.copyFile(src, dest);
	}

}
