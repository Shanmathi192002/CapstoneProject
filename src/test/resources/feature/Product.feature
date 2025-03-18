Feature: Product Page
  As a user
  I want to verify the product page functionality
  So that I can purchase products successfully

 @product
Scenario: Add product to cart and wishlist
  Given User is logged into Bookswagon
  When User navigates to a product page
  And User clicks on availability
  And User clicks on product name
  And User adds the product to cart
  And User goes to cart
  And User adds product to wishlist
  #Then Product should be added to wishlist successfully
