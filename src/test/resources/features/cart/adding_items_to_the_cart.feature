#Feature: Adding items to the cart
#  Rule: Items added from the product catalog page should appear in the cart
#    Example: Colin add items to his cart
#      Given Colin logged onto the application
#      And he is browsing product catalog
#      When he adds following items to the cart:
#      |Sauce Labs Backpack      |
#      |Sauce Labs Fleece Jacket |
#      Then the shopping cart item count should be 2
#      And the item should appear in the cart

Feature: Adding items to the cart
  Scenario: Items added from the product catalog page should appear in the cart
      Given Colin logged onto the application
      And he is browsing product catalog
      When he adds following items to the cart:
      |Sauce Labs Backpack      |
      |Sauce Labs Fleece Jacket |
      Then the shopping cart item count should be 2
      And the item should appear in the cart