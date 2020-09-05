Feature: adding new address before quest2
  Scenario Outline: as registered user add new address
    Given an open browser with login page
    When user successfully sign in using: <email>, <password>
    Then user should be on "your account" page
    When user goes to address page
    Then user should be on "create new address" page
    When user fills and save form with new address
    Then user see success prompt
    Then user checks if added address is correct
    And browser quits
    Examples:
      |email          |password |
      |tester@tester.ru|123qwe   |