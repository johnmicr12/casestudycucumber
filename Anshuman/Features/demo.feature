Feature: product purchase



  @Register
  Scenario: app_is_up
    Given app is up
    And enter "lalitha" and "password"
     

  @FunctionalTest
  Scenario Outline: microwave purchase
    Given John purchase microwave for <price> rs
    And he has receipt
    When John returns the faulty microwave
    Then he got refund of <price> doll

    Examples: 
      | price |
      |   100 |
      |   200 |
      |   300 |

  @Regression
  Scenario: microwave purchase
    Given John purchase microwave for 200 rs
    And he has receipt
    When John returns the faulty microwave
    Then he got refund of 200 doll

  @FunctionalTest @Smoke
  Scenario: microwave purchase
    Given John purchase microwave for 300 rs
    And he has receipt
    When John returns the faulty microwave
    Then he got refund of 300 doll

  @Regression @Smoke
  Scenario: microwave purchase
    Given John purchase microwave for 300 rs
    And he has receipt
    When John returns the faulty microwave
    Then he got refund of 300 doll
    @DataTable
    Scenario: Credentials
    Given credentials are
    |user1|
    |user2|
    |user3|
    |user4|
    |user5|
    |user6|
    
