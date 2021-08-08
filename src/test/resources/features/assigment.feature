Feature: HWC search verification
  Background: user already on homepage via Hooks class
   # Given User on home page

  Scenario: Verify headers
   # Given User on home page
    When User verify social media page from "National Health Service Corps"
    And perform search by keyword "National Health Service Corps"
    And navigate to sites tab
    And select third item from search result and click
    And navigate to the page
    Then verify the headers in Details tab:
      | Point(s) of Contact                |
      | Hours of Operation                 |
      | Site Type                          |
      | Rural Designation                  |
      | Site Status                        |
      | HPSA Scores                        |
      | Program Approved Services Provided |
      | Site Specific Services Provided    |
      | Languages Spoken by Patients       |
      | Number of Patients Served Annually |
      | Facility Size                      |
      | Relevant Links                     |

