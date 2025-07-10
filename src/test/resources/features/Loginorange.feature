@TestingWebsite
Feature: Testing Login ,I want to Enter details and Login

  @Login1
  Scenario Outline: user able to land on Dashboard page after entering valid Username and Password fields from excel sheet
    Given The users is on the OrangeHRMLogin in Page
    When The users enters login button after entering valid "<Sheetname>" and <Rownumber>
    Then The user should be redirected to dashboard page of orange HRM

    Examples: 
      | Sheetname  | Rownumber |
      | Loginsheet |         0 |

  @Login2
  Scenario Outline: user able to land on Dashboard page after entering invalid Username and Password fields from excel sheet
    Given The users is on the OrangeHRMLogin in Page
    When The users clicks login button after entering invalid username "<Sheetname>" and <Rownumber>
    Then The user should get meesage invalid "credentials"

    Examples: 
      | Sheetname  | Rownumber |
      | Loginsheet |         1 |

  @Login3
  Scenario Outline: user able to land on Dashboard page after entering invalid Username and Password fields from excel sheet
    Given The users is on the OrangeHRMLogin in Page
    When The users clicks login button after entering invalid password "<Sheetname>" and <Rownumber>
    Then The user should get meesage invalid "credentials"

    Examples: 
      | Sheetname  | Rownumber |
      | Loginsheet |         2 |

 @Login4
  Scenario Outline: user able to land on Dashboard page after entering invalid Username and Password fields from excel sheet
    Given The users is on the OrangeHRMLogin in Page
    When The users clicks login button after entering empty username "<Sheetname>" and <Rownumber>
    Then The user should get meesage Required for username

    Examples: 
      | Sheetname  | Rownumber |
      | Loginsheet |         3 |
      
  @Login5
  Scenario Outline: user able to land on Dashboard page after entering invalid Username and Password fields from excel sheet
    Given The users is on the OrangeHRMLogin in Page
    When The users clicks login button after entering empty passowrd "<Sheetname>" and <Rownumber>
    Then The user should get meesage Required for password

    Examples: 
      | Sheetname  | Rownumber |
      | Loginsheet |         4 |
      
      