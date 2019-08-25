package com.training.realestate.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_001_Register_Test {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM RegisterPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RegisterPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		screenShot.captureScreenShot();
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void RegistrationTest() {
		RegisterPOM.clickLogIn_Register_Btn();
		RegisterPOM.clickRegister_Tab();
		RegisterPOM.sendEmail("krsaurabh1@gmail.com");
		RegisterPOM.sendFirstName("kumar");
		RegisterPOM.sendLastName("saurabh");
			screenShot.captureScreenShot();
		RegisterPOM.clickRegisterBtn();
		RegisterPOM.verifyRegistrationText();
			screenShot.captureScreenShot();
	
	
	}
}
