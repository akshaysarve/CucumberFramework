@sanity
Feature: Saucedemo login functionality

  Scenario: Login using valid credentials
    Given user is on login page
    When user enters the "standard_user" and "secret_sauce"
    And clicks on login button
    Then display the product page
    And user will close the application

    
    