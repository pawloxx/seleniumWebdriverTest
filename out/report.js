$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/Cucumber/Features/quest2-test.feature");
formatter.feature({
  "line": 1,
  "name": "buying new product from my store (ZADANIE NR 2)",
  "description": "",
  "id": "buying-new-product-from-my-store-(zadanie-nr-2)",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "As registered user buy and order products",
  "description": "",
  "id": "buying-new-product-from-my-store-(zadanie-nr-2);as-registered-user-buy-and-order-products",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "open browser with login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user sign in using: \u003cemail\u003e, \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should be on \"your account\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user put name of item in the search box and clicks ENTER button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user should be on search results page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks on specific item",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user should be on item page",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user should check discount",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user chooses item \u003csize\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user checks if there is enough products in stock",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user choose item \u003cquantity\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user clicks \u0027Add to cart\u0027 button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "shop should show prompt and frame with buttons",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "user clicks on Proceed to checkout button",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "user should be on Cart Page",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "user clicks again on Proceed to checkout button",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "user should be on checkout page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "user approves address and clicks continue button",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "user chooses shipping metod and clicks continue button",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "user chooses payment metod",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "user should see order confirmation",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "user takes a screen shoot",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "user goes to order history page",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "user checks if order is correct",
  "keyword": "Then "
});
formatter.examples({
  "line": 29,
  "name": "",
  "description": "",
  "id": "buying-new-product-from-my-store-(zadanie-nr-2);as-registered-user-buy-and-order-products;",
  "rows": [
    {
      "cells": [
        "email",
        "password",
        "size",
        "quantity"
      ],
      "line": 30,
      "id": "buying-new-product-from-my-store-(zadanie-nr-2);as-registered-user-buy-and-order-products;;1"
    },
    {
      "cells": [
        "tester@tester.ru",
        "123qwe",
        "M",
        "555"
      ],
      "line": 31,
      "id": "buying-new-product-from-my-store-(zadanie-nr-2);as-registered-user-buy-and-order-products;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 31,
  "name": "As registered user buy and order products",
  "description": "",
  "id": "buying-new-product-from-my-store-(zadanie-nr-2);as-registered-user-buy-and-order-products;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "open browser with login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user sign in using: tester@tester.ru, 123qwe",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should be on \"your account\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user put name of item in the search box and clicks ENTER button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user should be on search results page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks on specific item",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user should be on item page",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user should check discount",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user chooses item M",
  "matchedColumns": [
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user checks if there is enough products in stock",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user choose item 555",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user clicks \u0027Add to cart\u0027 button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "shop should show prompt and frame with buttons",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "user clicks on Proceed to checkout button",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "user should be on Cart Page",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "user clicks again on Proceed to checkout button",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "user should be on checkout page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "user approves address and clicks continue button",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "user chooses shipping metod and clicks continue button",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "user chooses payment metod",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "user should see order confirmation",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "user takes a screen shoot",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "user goes to order history page",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "user checks if order is correct",
  "keyword": "Then "
});
formatter.match({
  "location": "Quest2Test.goToLoginPage()"
});
formatter.result({
  "duration": 2848283992,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "tester@tester.ru",
      "offset": 20
    },
    {
      "val": "123qwe",
      "offset": 38
    }
  ],
  "location": "Quest2Test.userSignIn(String,String)"
});
formatter.result({
  "duration": 980966841,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.checkIfUserIsOnMyAccountPage()"
});
formatter.result({
  "duration": 48496334,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userPutNameOfItemInTheSearchBox()"
});
formatter.result({
  "duration": 822237739,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userShouldSeeResultsOfSearching()"
});
formatter.result({
  "duration": 50562304,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userClicksOnSpecificItem()"
});
formatter.result({
  "duration": 520045662,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userShouldBeOnItemPage()"
});
formatter.result({
  "duration": 61257840,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userShouldCheckIfDiscount()"
});
formatter.result({
  "duration": 43195216,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "M",
      "offset": 18
    }
  ],
  "location": "Quest2Test.userChoosesSize(String)"
});
formatter.result({
  "duration": 1619791850,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userChecksIfThereIsEnoughProductsInStock()"
});
formatter.result({
  "duration": 31039834,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "555",
      "offset": 17
    }
  ],
  "location": "Quest2Test.userChooseItemQuantity(int)"
});
formatter.result({
  "duration": 142519283,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userClicksAddToCartButton()"
});
formatter.result({
  "duration": 94130044,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.shopShouldShowPromptAndFrameWithButtons()"
});
formatter.result({
  "duration": 1136549913,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userClicksOnProceedToCheckoutButton()"
});
formatter.result({
  "duration": 511640545,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userShouldBeOnCartPage()"
});
formatter.result({
  "duration": 69187642,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.proceedToCheckout()"
});
formatter.result({
  "duration": 586790728,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userShouldBeOnOrderPage()"
});
formatter.result({
  "duration": 106480431,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userApprovesAddressAndClicksContinueButton()"
});
formatter.result({
  "duration": 837785147,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userChoosesShippingMetod()"
});
formatter.result({
  "duration": 901446369,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userChoosesPaymentMetod()"
});
formatter.result({
  "duration": 1238942139,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userShouldSeeOrderConfirmation()"
});
formatter.result({
  "duration": 143101896,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userTakesASs()"
});
formatter.result({
  "duration": 458872441,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userGoesToMyAccountPage()"
});
formatter.result({
  "duration": 1025739085,
  "status": "passed"
});
formatter.match({
  "location": "Quest2Test.userChecksIfOrderIsCorrect()"
});
formatter.result({
  "duration": 61570843,
  "status": "passed"
});
});