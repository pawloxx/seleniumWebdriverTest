Feature: buying new product from my store (ZADANIE NR 2)

  Scenario Outline: As registered user buy and order products
    Given open browser with login page
    When user sign in using: <email>, <password>
    Then user should be on "your account" page
    When user put name of item in the search box and clicks ENTER button
    Then user should be on search results page
    When user clicks on specific item
    Then user should be on item page
    And user should check discount
    When user chooses item <size>
    Then user checks if there is enough products in stock
    When user choose item <quantity>
    And user clicks 'Add to cart' button
    Then shop should show prompt and frame with buttons
    When user clicks on Proceed to checkout button
    Then user should be on Cart Page
    When user clicks again on Proceed to checkout button
    Then user should be on checkout page
    When user approves address and clicks continue button
    And user chooses shipping metod and clicks continue button
    And user chooses payment metod
    Then user should see order confirmation
    And user takes a screen shoot
    When user goes to order history page
    Then user checks if order is correct

    Examples:
      |email          |password |size|quantity|
      |tester@tester.ru|123qwe   |M   |555       |