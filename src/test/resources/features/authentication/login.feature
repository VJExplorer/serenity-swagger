#Feature: Login
#  Rule: Customers need to provide valid credential to access the product catalog
#    Example : Colin log in with valid credentials
#      Given Colin is on the login page
#      When Colin logs in with valid credentials
#      Then he should be presented with the product catalog

Feature: Login
  Scenario: Customers need to provide valid credential to access the product catalog
    Given Colin is on the login page
    When Colin logs in with valid credentials
    Then he should be presented with the product catalog
