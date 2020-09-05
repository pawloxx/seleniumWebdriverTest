Feature: Creating New Address at "my store"

  Scenario Outline: User can add new address after successful log in
    Given an open browser with login page
    When user successfully sign in using: <email>, <password>
    Then user should be on "your account" page
    When user goes to address page
    Then user should be on "create new address" page
    When user fills and save form with new address
    Then user see success prompt
    Then user checks if added address is correct
    When user delete added address
    Then user checks if address is deleted

    Examples:
    |email          |password |
    |tester@tester.ru|123qwe   |