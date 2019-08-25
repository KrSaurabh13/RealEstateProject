package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPOM {
	private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="LOG IN / REGISTER")
	private WebElement LogIn_Register_Btn; 
	
	@FindBy(linkText="Register")
	private WebElement Register_Tab;
	
	@FindBy(xpath="//*[@id='email']")
	private WebElement email; 
	
	@FindBy(xpath="//*[@id='first-name']")
	private WebElement firstname;
	
	@FindBy(xpath="//*[@id='last-name']")
	private WebElement lastname;
	
	@FindBy(xpath="//*[@name='submit']")
	private WebElement RegisterBtn; 
	
	@FindBy(xpath="//*[@id='signupform']/p[5]/input")
	private WebElement RegisterBtn2;
	
	public void clickLogIn_Register_Btn() {
		System.out.println("LogIn screen is displayed");
		this.LogIn_Register_Btn.click(); 
	}
	
	public void clickRegister_Tab() {
		this.Register_Tab.click(); 
		System.out.println("Registration screen is displayed");
	}
	
	public void sendEmail(String emailId) {
		this.email.clear();
		this.email.sendKeys(emailId);
		System.out.println("Entered credentials in Email --> " + this.email.getAttribute("value"));
	}
	
	public void sendFirstName(String FirstName) {
		this.firstname.clear(); 
		this.firstname.sendKeys(FirstName); 
		System.out.println("Entered credentials in First Name --> " + this.firstname.getAttribute("value"));
	}
	
	public void sendLastName(String LastName) {
		this.lastname.clear(); 
		this.lastname.sendKeys(LastName); 
		System.out.println("Entered credentials in Last Name --> " + this.lastname.getAttribute("value"));
	}
	
	public void clickRegisterBtn() {
		this.RegisterBtn.click(); 
	}
	
	public void clickRegisterBtn2() {
		this.RegisterBtn2.click(); 
	}
	
	public void verifyTextPresent()
	{
		boolean Registration_Message = driver.getPageSource().contains("You have successfully registered to" + "Real Estate" + ". We have emailed your password to the email address you entered.");
	    if (Registration_Message == true)
	    {
	     System.out.print("Registration successful");
	    }
	    else
	    {
	     System.out.print("Registration Unsuccessful");
	    }
	}
	
	
	public void verifyRegistrationText()
	{
		String Expected = driver.findElement(By.xpath("//*[@id='post-133']/div/div/div/div[1]/p")).getText();
	    String Actual = "You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";
		System.out.println(driver.findElement(By.xpath("//*[@id='post-133']/div/div/div/div[1]/p")).getText());
	    assertEquals(Actual, Expected);
	}
	
	
	
}
