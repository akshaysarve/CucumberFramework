@sanity
Feature: Saucedemo login functionality

  Scenario: Login using valid credentials
    Given user is at login page
    When user enters the credentials
      | userName      | Password     |
      | standard_user | secret_sauce |
    And clicks at login button
    Then display views product page
    And close application
