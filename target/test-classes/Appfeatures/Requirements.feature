Feature: Requirements feature
  Background:
    Given user has already logged in to application
    |username|password|
    |admin   |issi123 |

  Scenario: Home page title
    When user gets the title of the page
    And page title should be "PSMS"

  Scenario: Adding new requirement
    Given user clicks on requirement button
