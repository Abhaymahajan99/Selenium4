package Selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium4feature {


	@Test(enabled=false)
	public void screenshotTest () throws IOException
	{
		WebDriverManager.chromedriver(). setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://devstaging.lawyerwangu.com/");
		driver.manage ().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//a[@title=\"Lawyer Wangu\"])[1]")));

		WebElement logo=driver.findElement (By.xpath("(//a[@title=\"Lawyer Wangu\"])[1]"));



		File file=logo.getScreenshotAs(OutputType.FILE);

		File destfile= new File("./logo.png");

		FileUtils.copyFile(file, destfile);

		driver.quit();


	}

	@Test(enabled=true)
	public void OpenNewTeb () throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver(). setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://devstaging.lawyerwangu.com/");
		driver.manage ().window().maximize();

		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("https://devstaging.lawyerwangu.com/lw/admin/login");

		Thread.sleep(1000);


		driver.quit();	    
	}

	@Test(enabled=false)
	public void OpenNewWindow () throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver(). setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tenders.ekbazaar.com/");

		Actions a = new Actions (driver);
		
		

		driver.switchTo().newWindow(WindowType.WINDOW);

		driver.navigate().to("https://devstaging.lawyerwangu.com/lw/admin/login");

		Thread.sleep(1000);

		
		
		

		driver.quit();





	}



}