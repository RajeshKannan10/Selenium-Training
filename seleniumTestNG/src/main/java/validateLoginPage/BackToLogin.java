package validateLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class BackToLogin extends NewUserPage {
	
	@Test(dataProvider="Credential")
	public void gotologinpage(String Uname,String Pword) {
	
		WebElement backtologin = driver.findElement(By.xpath("//button[@id='gotologin']"));
		backtologin.click();
		
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder='UserName']"));
		userName.sendKeys(Uname);
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(Pword);
		
		WebElement backloginbtn = driver.findElement(By.xpath("//button[@id='login']"));
		backloginbtn.click();
	}
	

}
