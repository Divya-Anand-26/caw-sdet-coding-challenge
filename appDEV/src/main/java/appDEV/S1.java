package appDEV;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AddHasAuthentication;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.sdk.metrics.data.SumData;

public class S1 {
	static
	{
		System.getProperty("webdriver.chrome.driver","C:\\Users\\Anand Raj\\eclipse-workspace\\Automation\\driver\\chromedriver.exe");
	}
	public static void main(String[] args) throws AWTException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		WebElement un = driver.findElement(By.id("user-name"));
		un.click();
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

		un.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		/*WebDriverWait wait1=new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.alertIsPresent());
		Alert a=driver.switchTo().alert();
		String text=a.getText();
		a.accept();
		System.out.println(text);*/
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
		
		
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();

		
		WebElement Fn = driver.findElement(By.xpath("//input[@id='first-name']"));
		Fn.click();
		WebElement Ln = driver.findElement(By.xpath("//input[@id='last-name']"));
		Ln.click();
		WebElement zip = driver.findElement(By.xpath("//input[@id='postal-code']"));
		zip.click();
		
		Fn.sendKeys("Divya");
		Ln.sendKeys("Anand");
		zip.sendKeys("500084");
			
		WebElement total = driver.findElement(By.xpath("//div[text()='140.34']"));
		
		
			
	}
}




