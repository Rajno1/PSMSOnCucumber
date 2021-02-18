package org.issi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    //By locators
    private final By textboxUsername = By.id("id_uname");
    private final By textboxPassword = By.id("id_password");
    private final By buttonLogin = By.xpath("//span[text()='SIGN-IN']/parent::button");
    private final By forgotpwdlink = By.linkText("Forgot Password?");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //page actions
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isForgotPwdlinkExist(){
        return driver.findElement(forgotpwdlink).isDisplayed();
    }

    public void enterUserName(String username){
        driver.findElement(textboxUsername).sendKeys(username);
    }
    public void enterPassword(String pwd){
        driver.findElement(textboxPassword).sendKeys(pwd);
    }
    public void clickOnLogin(){
        driver.findElement(buttonLogin).click();
    }

    public HomePage doLogin(String un, String pwd){
        System.out.println("Login with : " + un + "and" + pwd);
        driver.findElement(textboxUsername).sendKeys(un);
        driver.findElement(textboxPassword).sendKeys(pwd);
        driver.findElement(buttonLogin).click();
        return new HomePage(driver);
    }
}
