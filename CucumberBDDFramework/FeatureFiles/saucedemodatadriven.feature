@regression
Feature: SauceDemo page login functionality

  Scenario Outline: SauceDemo user login scenario
    Given user launch saucedemo page
    When user enter credentials "<UserName>" and "<Password>"
    And click login button
    Then user should view products page
    And user should close application

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
