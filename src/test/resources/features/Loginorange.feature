@TestingWebsite
Feature: Testing Login
  I want to Enter details and Login

 # @Login1
  #Scenario Outline: Verify that user is able to land on Login Page
   # Given The user is on the OrangeHRMLogin Page
    #When The user enters username and password and click the login button
    #Then The user should be redirected to dashboard page
    
  @Login2
  Scenario Outline: user able to land on Dashboard page after entering valid Username and Password fields from excel sheet
   Given The users is on the OrangeHRMLogin in Page
   When The users enters login button after entering valid "<Sheetname>" and <Rownumber>
   Then The user should be redirected to dashboard page of orange HRM

    Examples: 
      | Sheetname | Rownumber |
      | Loginsheet     |         0 |