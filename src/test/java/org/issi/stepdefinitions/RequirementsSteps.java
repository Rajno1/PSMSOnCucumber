package org.issi.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.issi.factory.DriverFactory;
import org.issi.pages.LoginPage;
import org.issi.pages.HomePage;

import java.util.List;
import java.util.Map;

public class RequirementsSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps(String.class, String.class);
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverFactory.getDriver().get("https://psmsclientdemo.issi-software.com/login");
        homePage = loginPage.doLogin(username,password);
    }

    @Given("user clicks on requirement button")
    public void user_clicks_on_requirement_button() {
        try {
            Thread.sleep(2000);
            homePage.clickOnRequirements();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
