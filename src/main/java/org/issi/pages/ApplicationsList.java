package org.issi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationsList {
    private final WebDriver driver;
    //By locators
    private final By addNewApplicatonLink = By.id("addnewRole");

    //constructor
    public ApplicationsList(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRequirements(){
        driver.findElement(addNewApplicatonLink).click();
    }
}
