
Feature: Login page feature
  @smoke
  Scenario: Validating login functionality
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login Page"
    Then forget password button should be display
    When user enters username "Applicant"
    And user enters password "Issi123#"
    And user clicks on login button
    When user gets the title of the page
    And page title should be "ApplicationsList - Maryland Residential Portal"