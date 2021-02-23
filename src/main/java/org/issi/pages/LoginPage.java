package org.issi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    //By locators
    private final By textboxUsername = By.id("userName");
    private final By textboxPassword = By.id("password");
    private final By buttonLogin = By.id("submit");
    private final By forgotpwdlink = By.xpath("//a[contains(text(),' Forgot Password')]");

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

    public ApplicationsList doLogin(String un, String pwd){
        System.out.println("Login with : " + un + "and" + pwd);
        driver.findElement(textboxUsername).sendKeys(un);
        driver.findElement(textboxPassword).sendKeys(pwd);
        driver.findElement(buttonLogin).click();
        return new ApplicationsList(driver);
    }
}
