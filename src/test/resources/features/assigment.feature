Feature: HWC search verification

  Scenario: Verify headers
    Given User on home page
    When User verify social media page from "National Health Service Corps"
    And perform search by keyword "National Health Service Corps"
    And navigate to sites tab
    And select third item from search result and click
    And navigate to the page
    Then click on each tab and verify the headers
      | Site Details     |
      | Opportunities    |
      | Affiliated Sites |