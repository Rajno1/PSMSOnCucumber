Feature: Login page feature
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "PSMS"

  Scenario: Forgot password link
    Given user is on login page
    Then forget password link should be display

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "admin"
    And user enters password "issi123"
    And user clicks on login button
    When user gets the title of the page
    And page title should be "PSMS"