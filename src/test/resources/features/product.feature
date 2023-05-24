Feature: Product Filtering and Cart Functionality

  Scenario: Filter Products
    Given I am on the Login page
    When  I login with standard user
    Then I should be logged in successfully
    When I filter products by "Price (low to high)"
    Then I should see the products sorted by price in ascending order

  Scenario: Filter Products
    Given I am on the Login page
    When  I login with standard user
    Then I should be logged in successfully
    When I filter products by "Price (high to low)"
    Then I should see the products sorted by price in descending order