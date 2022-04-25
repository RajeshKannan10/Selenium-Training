package validateLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPage extends Logintap {
	
	@Test
	public void validateLoginPage() {
		
		String url = loginTap();
		
		String loginpageurl = driver.getCurrentUrl();
		System.out.println(loginpageurl);
		
		SoftAssert soft = new SoftAssert();
		soft.assertNotEquals(loginpageurl, url,"Navigate bookpage to loginpage sucessfully");
		soft.assertAll();
		
		
		WebElement Welcomenote = driver.findElement(By.xpath("//h2[text()='Welcome,']"));
		System.out.println(Welcomenote.isDisplayed());
		
		WebElement usernamelabel = driver.findElement(By.xpath("//label[text()='UserName : ']"));
		System.out.println(usernamelabel.isDisplayed());
		
		WebElement passwordlabel = driver.findElement(By.xpath("//label[text()='Password : ']"));
		System.out.println(passwordlabel.isDisplayed());
		
		WebElement loginbtn = driver.findElement(By.xpath("//button[@class='btn btn-primary'][@id='login']"));
		System.out.println(loginbtn.isDisplayed());
		
		WebElement newuserbtn = driver.findElement(By.xpath("//button[@class='btn btn-primary'][@id='newUser']"));
		System.out.println(newuserbtn.isDisplayed());
		
	}
	

}
