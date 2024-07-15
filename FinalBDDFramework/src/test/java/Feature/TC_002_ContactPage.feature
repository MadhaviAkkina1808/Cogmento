Feature: Test Cogmento Contact Page Application

  Scenario Outline: Validate contact page in cogmento application
    When user is on Home page and click on contacts tab
    When user is on Contacts Page,validate the url contains "contacts"
    And click on create button
    And user enter contact informaton from excel sheet "<SheetName>" and <RowNumber>
    And click on save button
    And user will delete the created contact

    Examples: 
      | SheetName    | RowNumber |
      | ContactsList |         0 |
      | ContactsList |         1 |
      | ContactsList |         2 |
      | ContactsList |         3 |

  Scenario: Validate Logout Functionality
    When user click on profile icon
    And user click on logout option
    And user close the session
