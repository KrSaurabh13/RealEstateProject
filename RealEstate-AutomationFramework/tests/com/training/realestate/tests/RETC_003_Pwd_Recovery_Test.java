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
import com.training.pom.PwdRecoveryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_003_Pwd_Recovery_Test {

	private WebDriver driver;
	private String baseUrl;
	private PwdRecoveryPOM PwdRecoveryPOM;
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
		PwdRecoveryPOM = new PwdRecoveryPOM(driver); 
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
	public void Pwd_Recovery_Test() {
		PwdRecoveryPOM.clickLogIn_Register_Btn();
		PwdRecoveryPOM.clickLogin_Tab();
		PwdRecoveryPOM.sendUserName("krsaurabh1110@gmail.com");
		PwdRecoveryPOM.clickLostYourPwd();
			screenShot.captureScreenShot();
		PwdRecoveryPOM.VerifyPageTitle();
		PwdRecoveryPOM.sendUserName("krsaurabh1110@gmail.com");	
		PwdRecoveryPOM.clickResetPasswordBtn();
		

	
	
	}
}
