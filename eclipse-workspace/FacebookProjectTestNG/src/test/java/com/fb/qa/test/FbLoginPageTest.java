package com.fb.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.Base;
import com.fb.qa.pages.FbHomepage;
import com.fb.qa.pages.FbLoginPage;

public class FbLoginPageTest extends Base {

	FbLoginPage loginpage;
	FbHomepage homepage;
	
	public FbLoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		intialization();
		loginpage = new FbLoginPage();
	}
	@Test(priority = 1)
	public void validateloginpagetest() {
		String title = loginpage.verifyLoginPage();
		Assert.assertEquals(title, "https://www.facebook.com/");
	}
	@Test(priority = 2)
	public void validatefblogotest() {
		boolean logo = loginpage.verifyfblogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), "password");
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
