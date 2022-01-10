@smoke
Feature: Saucedemo login functionality

  Scenario: Login using valid credentials
    Given user is navigating to saucedemo url
    When username and password are valid
    And click on login button
    Then display the products page
    And close the application

  
  Scenario: Login using invalid credentials
    Given user is navigating to saucedemo url
    When Invalid username and password are entered
    And click on login button
    Then unable to login
    And close the application
