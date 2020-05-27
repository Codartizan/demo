@Example
Feature: Login Test
  Login Test

  Scenario: Login
    Given open website
    When I click login button
    Then I should be redirected to sso page
    When I enter credentials with tim.shi@uoa.com and 123
    Then I should be login successful