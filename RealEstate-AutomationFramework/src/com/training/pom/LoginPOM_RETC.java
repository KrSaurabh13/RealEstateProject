package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPOM_RETC {
	private WebDriver driver; 
	
	public LoginPOM_RETC(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="LOG IN / REGISTER")
	private WebElement LogIn_Register_Btn; 
	
	@FindBy(linkText="Log In")
	private WebElement LogIn_Tab;
	
	@FindBy(xpath="//*[@id='user_login']")
	private WebElement UserName; 
	
	@FindBy(xpath="//*[@id='user_pass']")
	private WebElement Password; 
	
	@FindBy(xpath="//*[@name='login']")
	private WebElement SignInBtn;
	
	
	
	public void clickLogIn_Register_Btn() {
		this.LogIn_Register_Btn.click(); 
	}
			
	public void clickLogin_Tab() {
		this.LogIn_Tab.click(); 
		System.out.println("LogIn screen is displayed");
	}
	
	
	public void sendUserName(String username) {
		this.UserName.clear();
		this.UserName.sendKeys(username);
		System.out.println("Entered credentials in Email --> " + this.UserName.getAttribute("value"));
	}
	
	public void sendPassword(String password) {
		this.Password.clear();
		this.Password.sendKeys(password);
		System.out.println("Entered credentials in Password --> " + this.Password.getAttribute("value"));
	}
	
	public void clickSignInBtn() {
		this.SignInBtn.click(); 
	}
	
	
	public void VerifyPageTitle() {
	    String Expected = "My Profile – Real Estate";
	    String Actual = driver.getTitle();
	    System.out.println("Page Tittle is --> " + driver.getTitle());
	    assertEquals(Actual, Expected);
	}
	
	
	public void verifyRegistrationText()
	{
		String Expected = driver.findElement(By.xpath("//*[@id='post-133']/div/div/div/div[1]/p")).getText();
	    String Actual = "You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";
		System.out.println(driver.findElement(By.xpath("//*[@id='post-133']/div/div/div/div[1]/p")).getText());
	    assertEquals(Actual, Expected);
	}
	
	
	
}
