Feature: Login Screen

  @source
  Scenario: Login using valid credentials
    Given I am on Login page
    Then  I login with standard user
    Then I should be logged in successfully

  Scenario Outline: Login using different credentials
    Given I am on the Login page
    When  I login user with different "<username>" and "<password>"
    Then I should be logged in successfully
    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | performance_glitch_user | secret_sauce |