package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.Base;

public class FbLoginPage extends Base {

	@FindBy(xpath = "//*[@title = 'Go to Facebook home']")
	WebElement facebookloginlogo;

	@FindBy(xpath = "//*[@type = 'email']")
	WebElement emailfield;

	@FindBy(xpath = "//*[@id= 'pass']")
	WebElement loginpassword;
	
	@FindBy (xpath = "//*[@data-testid= 'royal_login_button']")
	WebElement loginbtn;

	public FbLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginPage() {
		return driver.getTitle();
	}

	public boolean verifyfblogo() {
		return facebookloginlogo.isDisplayed();
	}
	
	public FbHomepage login(String email, String password) {
		emailfield.clear();
		emailfield.sendKeys(email);
		loginpassword.clear();
		loginpassword.sendKeys(password);
		loginbtn.click();
		return new FbHomepage();
	}
}
