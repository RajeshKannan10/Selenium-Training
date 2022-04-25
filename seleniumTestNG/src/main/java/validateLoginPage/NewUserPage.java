package validateLoginPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewUserPage extends LoginPage {
	
	@DataProvider(name="Credential")
	public String[][] ExcelReader() throws IOException {
		
		FileInputStream fis = new FileInputStream("./ExcelData/NewRegister.xlsx");
		XSSFWorkbook xlbook = new XSSFWorkbook(fis);
		XSSFSheet xlsheet = xlbook.getSheetAt(0);
		
		int rowcount = xlsheet.getPhysicalNumberOfRows();
		System.out.println(rowcount);
		
		short coulmncount = xlsheet.getRow(0).getLastCellNum();
		System.out.println(coulmncount);
		
		String [][] usercredential = new String [rowcount-1][coulmncount];
		
		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < coulmncount; j++) {
				DataFormatter formatter = new DataFormatter();
				usercredential[i-1][j] = formatter.formatCellValue(xlsheet.getRow(i).getCell(j));
			}
		}
		xlbook.close();
		return usercredential;
	}
	
	@Test(dataProvider="Credential")
	public void Registerpage(String Fname,String Lname,String Uname,String Pword) throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scroll(0,500)");
		
		try {
			WebElement Newuserbtn = driver.findElement(By.xpath("//button[@id='newUser']"));
			Newuserbtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstname']"));
		firstname.sendKeys(Fname);
		
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastname']"));
		lastname.sendKeys(Lname);
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
		userName.sendKeys(Uname);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(Pword);
		
		Thread.sleep(6000);
		
		WebElement registerbtn = driver.findElement(By.xpath("//button[text()='Register']"));
		
		WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement register = wdw.until(ExpectedConditions.elementToBeClickable(registerbtn));
		register.click();
		
		
		Alert control = driver.switchTo().alert();
		control.accept();
		
	}

}
