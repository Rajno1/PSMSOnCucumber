@application
Feature: ApplicationsList feature

  Background:
    Given user has already logged in to application
      | username  | password |
      | Applicant | Issi123# |
  @function
  Scenario: Adding new application
    When user gets the title of the page
    And page title should be "ApplicationsList - Maryland Residential Portal"
    Given user clicks on Add New Application link
