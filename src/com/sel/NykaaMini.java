package com.sel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class NykaaMini {
	
	static WebDriver driver;
	static Actions a;
	static Select s;
	
	public void browserLaunch(String url) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Avadi\\workspace1\\Sel_mini\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	public void userLogin() throws InterruptedException {
		
		//click sign in
		WebElement uL = driver.findElement(By.xpath("//button[text()='Sign in']"));
		uL.click();
		
		//click sign in with mobile
		WebElement uL1 = driver.findElement(By.xpath("//button[text()='Sign in with Mobile / Email']"));
		uL1.click();
		
		Thread.sleep(10000);
		
		//Enter mobile number
		WebElement uL2 = driver.findElement(By.xpath("//input[@name='emailMobile']"));
		
		//wait for visibility
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(uL2));
		uL2.sendKeys("9345845131");
		
		//click proceed
		WebElement uL3 = driver.findElement(By.xpath("//button[text()='proceed']"));
		uL3.click();
		
		//Enter OTP
		Thread.sleep(30000);
		
		//Click verify
		WebElement uL4 = driver.findElement(By.xpath("//button[text()='verify']"));
		uL4.click();		
		
	}
	
	public void productSearch() throws InterruptedException {
		
		a=new Actions(driver);
		Thread.sleep(10000);
		
		//mouse over mom and baby
		WebElement pS = driver.findElement(By.xpath("//a[text()='mom & baby']"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(pS));
		a.moveToElement(pS).build().perform();
		
		//click on baby powder
		WebElement pS1 = driver.findElement(By.xpath("//a[text()='Baby Powder']"));
		pS1.click();
		
	}
	
	public void addToBag() throws InterruptedException {
		
		//scroll into view the product
		Thread.sleep(1000);
		
		//Java Script Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//get windowhandles to go to next tab
		String first = driver.getWindowHandle();
		Set<String> WH = driver.getWindowHandles();
		
		Iterator<String> it = WH.iterator();
		while(it.hasNext()) {
			String next = it.next();
			if(!first.equals(next)) {
				Thread.sleep(5000);
				driver.switchTo().window(next);
				
				//scrollinto the product
				WebElement aB = driver.findElement(By.xpath("//img[@alt='Himalaya Baby Powder']"));
				js.executeScript("arguments[0].scrollIntoView();", aB);
				js.executeScript("window.scrollBy(0,-100)");
				aB.click();
			}
		}
		//get windowhandles to go to next tab
		ArrayList<String> WH1 = new ArrayList<String>(driver.getWindowHandles());
		int size = WH1.size();
		String last_tab = WH1.get(size-1);
		
		Thread.sleep(5000);
		driver.switchTo().window(last_tab);
		
		Thread.sleep(5000);
		
		//scrollinto the product
		WebElement aB1 = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
		js.executeScript("arguments[0].scrollIntoView();", aB1);
		js.executeScript("window.scrollBy(0,-100)");
		s= new Select(aB1);
		s.selectByValue("0");

		//click add to bag
		WebElement aB2 = driver.findElement(By.xpath("//span[text()='Add to Bag'][1]"));
		aB2.click();
		
	}
	
	public void goToBag() throws InterruptedException {
		
		//click to bag
		Thread.sleep(10000);
		
		WebElement gB = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div/div[2]/div[2]/button"));
		gB.click();
		
		Thread.sleep(5000);
		
		//switch to frame
		WebElement gB1 = driver.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
		driver.switchTo().frame(gB1);
		
		Thread.sleep(5000);
		
		//click quantity drop down
		WebElement gB2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[3]/div/div/div[1]/div/div/div[3]/div/div[1]"));
		gB2.click();
		
		//select quantity
		WebElement gB3 = driver.findElement(By.xpath("//li[@class='css-18fuhjc edkwwn3'][3]"));
		WebDriverWait wait= (new WebDriverWait(driver, 10));
		wait.until(ExpectedConditions.elementToBeClickable(gB3)); 
		gB3.click();
		
		//click proceed
		WebElement gB4 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/button/div/div"));
		gB4.click();
		
	}
	
	public void addressForm() throws InterruptedException {
		
		Thread.sleep(5000);
		
		//click enter
		WebElement aF = driver.findElement(By.xpath("//button[text()='Deliver here']"));
		aF.click();
		
	}
	
	public void paymentPage() throws InterruptedException {
		
		Thread.sleep(10000);
		
		//enter card number
		WebElement pP = driver.findElement(By.xpath("//input[@placeholder='Card Number']"));
		pP.click();
		pP.sendKeys("3566000020000410");
		
		Thread.sleep(3000);
		
		//enter expiry date
		WebElement pP1 = driver.findElement(By.xpath("//input[@placeholder='Expiry (MM/YY)']"));
		pP1.click();
		pP1.sendKeys("02/26");
		
		Thread.sleep(3000);
		
		//enter cvv
		WebElement pP2 = driver.findElement(By.xpath("//input[@placeholder='CVV']"));
		pP2.sendKeys("123");
		
		//click proceed
		WebElement pP3 = driver.findElement(By.xpath("//button[@class='css-v61n2j e8tshxd0']"));
		pP3.click();
		
		//click the pop up window
		WebElement pP4 = driver.findElement(By.xpath("//button[text()='Pay without securing card']"));
		pP4.click();
		
		Thread.sleep(10000);
		
	}
	
	public void screenShot() throws IOException {
		
		//take screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\Avadi\\workspace1\\Sel_mini\\screenshots\\Payment.png");
		FileHandler.copy(src, des);
		
		//close the tab
		WebElement sS = driver.findElement(By.xpath("//button[text()='Close']"));
		sS.click();
		
	}
	
	public void clearBag() throws InterruptedException {
		
		//click bag
		WebElement cB = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/p"));
		cB.click();
		
		//click edit bag
		WebElement cB1 = driver.findElement(By.xpath("//p[text()='Edit']"));
		cB1.click();
		
		Thread.sleep(3000);
		
		//click delete icon
		WebElement cB2 = driver.findElement(By.xpath("//div[@data-test-id='product-remove']"));
		WebDriverWait wait= (new WebDriverWait(driver, 10));
		wait.until(ExpectedConditions.elementToBeClickable(cB2)).click(); 
	   
		//click on remove button	
		WebElement cB3 = driver.findElement(By.xpath("//button[text()='Remove']"));
		WebDriverWait wait1= new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(cB3)).click(); 
		driver.close();
		
	}
	
	public void logOut() throws InterruptedException {
		
		Thread.sleep(5000);
		
		//click on user
		WebElement lo = driver.findElement(By.xpath("//span[@class='css-17ukzrr euw1lbv4']"));
		a.moveToElement(lo).build().perform();
		
		//click on logout
		WebElement lo1 = driver.findElement(By.xpath("//button[text()='Logout']"));
		lo1.click();
		
		//click logout from all devices
		WebElement lo2 = driver.findElement(By.xpath("//span[text()='Logout from all devices']"));
		lo2.click();
		
	}
	
	public static void main(String args[]) throws InterruptedException, IOException {
		
		NykaaMini ny = new NykaaMini();
		ny.browserLaunch("https://www.nykaa.com/");
		ny.userLogin();
		ny.productSearch();
		ny.addToBag();
		ny.goToBag();
		ny.addressForm();
		ny.paymentPage();
		ny.screenShot();
		ny.clearBag();
		ny.logOut();
		driver.quit();
	}
}
