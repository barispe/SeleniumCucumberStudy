Feature: videoConference

  @run
  Scenario: Start a video conference
    Given I navigate to main page with "User 1"
    And I open new tab
    And I navigate to main page with "User 2"
    Then I validate that the Main Page is properly presented for "User 1"
    Then I validate that the Main Page is properly presented for "User 2"
    When I join call for "User 1"
    And I join call for "User 2"
    Then I validate that I am in a call
    And I end the call