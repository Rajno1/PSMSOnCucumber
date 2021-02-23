package org.issi.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.issi.enums.ConfigProperties;
import org.issi.factory.DriverFactory;
import org.issi.pages.LoginPage;
import org.issi.pages.ApplicationsList;
import org.issi.utilities.PropertyUtils;
import java.util.List;
import java.util.Map;

public class ApplicationsListSteps {
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private ApplicationsList applicationsList;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps(String.class, String.class);
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverFactory.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
        applicationsList = loginPage.doLogin(username,password);
    }

    @Given("user clicks on Add New Application link")
    public void user_clicks_on_add_new_application_link() {
        try {
            Thread.sleep(2000);
            applicationsList.clickOnRequirements();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
