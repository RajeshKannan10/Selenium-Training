package validateLoginPage;

import org.testng.annotations.AfterSuite;

public class QuiteBrowser extends BackToLogin {
	
	@AfterSuite
	public void Browserquite() {
		driver.close();
	}

}
