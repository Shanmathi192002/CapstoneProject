Feature: Shopping Cart Functionality

  Scenario: User logs in, adds product to cart from wishlist, and proceeds to checkout
    Given User is logged in and on the homepage
    Then User clicks wishlist symbol
    Then User increases the quantity
    Then User decreases the quantity
    Then User adds the product to cart from wishlist
    Then User clicks cart symbol
    Then User clicks Buy button
