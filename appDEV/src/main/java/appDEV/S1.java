package appDEV;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class S1 {
	static
	{
		System.getProperty("webdriver.chrome.driver","C:\\Users\\Anand Raj\\eclipse-workspace\\Automation\\driver\\chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, AWTException {
		
	 WebDriver driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
		WebElement un = driver.findElement(By.id("user-name"));
		un.click();
		Thread.sleep(3000);
		
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.click();
		
		String title = driver.getTitle();
		if(title.equals("Swag Labs"))
		{
			System.out.println("its a match");
			
		}
		else
		{
			System.out.println("not a match");
		}
		Thread.sleep(3000);
		un.sendKeys("standard_user");
		Thread.sleep(3000);
		pwd.sendKeys("secret_sauce");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(3000);
		String etitle = "https://www.saucedemo.com/inventory.html";
		if(etitle.equals("https://www.saucedemo.com/inventory.html"))
		{
		 driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		 System.out.println("is displayed");
		 
		}
		else
		{
			System.out.println("not displayed");
			
		}
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select s=new Select(dropdown);
		s.selectByValue("hilo");
		
		List<WebElement> allSugg = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		for (int i=0;i<allSugg.size();i++){
			for (int j=0;j<allPrice.size();j++)
			{
			String text = allSugg.get(i).getText();
			System.out.println(text);
			String price = allPrice.get(j).getText();
			System.out.println(price);
		}
		}
		List<WebElement> cart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
		for (WebElement webElement : cart) {
			webElement.click();
		}
		WebElement carticon = driver.findElement(By.className("shopping_cart_link"));
		if(carticon.equals(carticon))
		{
			driver.findElement(By.xpath("//span[text()='6']")).equals(8);
			System.out.println("yes 6 items");
		}
		else
			System.out.println("not a 6");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*WebElement UNtarget = driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']"));
		Actions a=new Actions(driver);
		a.moveToElement(UNtarget).perform();*/
	/*	WebElement unt = driver.findElement(By.xpath("//div[@id='login_credentials']"));
		
		Actions a=new Actions(driver);
		a.moveToElement(unt).perform();
		WebElement user = driver.findElement(By.partialLinkText("standard_user"));
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_C);
		r.re)*/
		
		
		
}
}