package org.issi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    //By locators
    private final By requirementsbutton = By.xpath("//span[text()='Requirements']/parent::button");
////span[text()='Requirements']/parent::button
    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRequirements(){
        driver.findElement(requirementsbutton).click();
    }
}
