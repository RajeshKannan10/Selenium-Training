package validateLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Logintap extends InizatingBrowser{
	
	@Test
	public String loginTap() {
		
		String bookpageurl = driver.getCurrentUrl();
		System.out.println(bookpageurl);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scroll(0,500)");
		
		WebElement Login = driver.findElement(By.xpath("//span[text()='Login']"));
		Login.click();
		
		return bookpageurl;
	}
	
}
