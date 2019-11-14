package com.fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fb.qa.util.Utilfb;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	
	public Base(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\RAJU\\eclipse-workspace\\FacebookProjectTestNG\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
			
			prop.load(ip);		
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void intialization() {
		String browsername = prop.getProperty("browser");
		
		if (browsername.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utilfb.Pageload_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilfb.Implicit_Wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
}
