Feature: Experian sign in functionality

  @gg
    Scenario: User sign in functionality
    Given User on the Experian home page
    When User clicks sign in button
    And Click on sign in to your account
    And User lands on Experian Login page
    Then User should see title is Experian - login
    And User enters "<Username>"
    And User enters "<password>"
    And User clicks on sign in button








