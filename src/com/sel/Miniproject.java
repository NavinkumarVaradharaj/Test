package com.sel;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Miniproject {

	public static WebDriver driver;
	public static Actions a;
	
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("incognito");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	public static void searchBabyPowder() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Nykaa = driver.findElement(By.xpath("//a[text() = 'mom & baby']"));
		a = new Actions(driver);
		a.moveToElement(Nykaa).build().perform();
		driver.findElement(By.xpath("//a[text()='Baby Powder']")).click();
	}

	public static void main(String args[]) throws IOException, InterruptedException {

		browserLaunch();
		urlLaunch("https://www.nykaa.com/");
		
		
		String parent = driver.getWindowHandle();
		
		Set<String> child = driver.getWindowHandles();
		Iterator<String> itr = child.iterator();
		while (itr.hasNext()) {
			String all_tabs = itr.next();
			if (!parent.equals(all_tabs)) {
				driver.switchTo().window(all_tabs);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");
				Thread.sleep(4000);
				driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
				// Thread.sleep(4000);
				// driver.findElement(By.xpath("//span[text()='Add to Bag'][1]")).click();

			}
		}
		Set<String> child1 = driver.getWindowHandles();
		List<String> l = new LinkedList<>();
		l.addAll(child1);
		// System.out.println(l);

		if (l.get(1) != null)

		{
			String w2 = l.get(2);
			driver.switchTo().window(w2);

			Thread.sleep(2000);
			// driver.findElement(By.xpath("(//span[@class=' css-d3w64v'])[3]")).click();
			WebElement grams = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
			Select s = new Select(grams);
			s.selectByValue("2");

			WebElement add_to_bag = driver.findElement(By.xpath("(//span[@class='btn-text'])[1]"));
			add_to_bag.click();
			Thread.sleep(3000);
			WebElement bag_icon = driver.findElement(By.xpath("//button[@class='css-aesrxy']"));
			bag_icon.click();
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//div[text()='View Bag']")).click();
			WebElement frames = driver
					.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
			driver.switchTo().frame(frames);
			Thread.sleep(4000);
			WebElement quant = driver.findElement(By.xpath("//p[@data-test-id='select-quantity']"));
			quant.click();
			Thread.sleep(4000);

			WebElement opt = driver.findElement(By.xpath("//span[@value='3']"));
			opt.click();
			// WebDriverWait wait=new WebDriverWait(driver,30);
			// wait.until(ExpectedConditions.visibilityOf(opt));

			/*
			 * driver.findElement(By.xpath("//div[@class='css-1l5d7z5 e1whhlt1']")).click();
			 * Thread.sleep(4000);
			 * driver.findElement(By.xpath("(//button[@class='css-dj1hws e8tshxd1'])[2]")).
			 * click();
			 */
			Thread.sleep(4000);

			driver.findElement(By.xpath("(//button[@class='css-1j2bj5f e8tshxd0'])[2]")).click();
		}
		// System.out.println(l);
		Set<String> child2 = driver.getWindowHandles();
		List<String> l1 = new LinkedList<>();
		l1.addAll(child2);
		if (l1.get(1) != null)

		{
			String w3 = l1.get(2);
			driver.switchTo().window(w3);
			Thread.sleep(4000);
			WebElement login_button = driver.findElement(By.xpath("//button[text()='Log In']"));
			login_button.click();
			WebElement login_using_mobile = driver
					.findElement(By.xpath("//input[@class='input text-center login-input']"));
			login_using_mobile.click();
			WebElement input_for_mobileNumber = driver.findElement(By.xpath("//input[@class='input text-center']"));
			input_for_mobileNumber.sendKeys("9345845131");
			Thread.sleep(10000);
			WebElement proceed_for_mobile_input = driver.findElement(By.xpath("//button[@id='submitVerification']"));

			proceed_for_mobile_input.click();// Thread.sleep(15000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			WebElement deliver_here_button = driver.findElement(By.xpath("//button[@class='css-n7wnfc e8tshxd0']"));

//		 JavascriptExecutor js = (JavascriptExecutor) driver;
//		 js.executeScript(, args)
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(deliver_here_button));
			deliver_here_button.click();
			Thread.sleep(4000);

//		 driver.findElement(By.xpath("//input[@placeholder='Card Number']")).sendKeys("4263");
//		 Thread.sleep(3000);
//		 driver.findElement(By.xpath("//input[@placeholder='Card Number']")).sendKeys("4263");
//		 Thread.sleep(1000);
//		 driver.findElement(By.xpath("//input[@placeholder='Card Number']")).sendKeys("4263");
//		 Thread.sleep(1000);
//		 driver.findElement(By.xpath("//input[@placeholder='Card Number']")).sendKeys("4263");
//		 Thread.sleep(1000);

//		 driver.findElement(By.xpath("//input[@placeholder='Expiry (MM/YY)']")).sendKeys("02");
//		Thread.sleep(3000);
//		 driver.findElement(By.xpath("//input[@placeholder='Expiry (MM/YY)']")).sendKeys("26");
//	   driver.findElement(By.xpath("//p[@class='css-rxufl7 eoygcm00']")).click();
//	    driver.findElement(By.xpath("//p[@class='css-z7wmhp eka6zu20']")).click();
//		Thread.sleep(4000);
//	    driver.findElement(By.xpath("(//span[@class='css-175whwo ehes2bo0'])[2]")).click();
//	    Thread.sleep(4000);
//	    driver.findElement(By.xpath("(//button[@class='css-110s749 e8tshxd1'])[1]")).click();
//	    Thread.sleep(4000);
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(".\\screenshots\\SS3.png");
			FileHandler.copy(source, destination);

		}
	}
}