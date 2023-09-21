@1
Feature: Library app login feature
  As a user, I should be able to login with correct credentials to different accounts.And dashboard should be displayed.
  Accounts are: librarian, student, admin

  Background: User is already in login page
    Given user is on the login page


  @librarian @employee
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see dashboard

    # option + enter
    # command + press on each line of scenario and it will take me to that exactly method

  @student
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see dashboard

    @admin @employee @db
    Scenario: Login as admin
      When user enters admin username
      And user enters admin password
      Then user should see dashboard