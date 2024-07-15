Feature: Test cogmento Application

  Scenario: Test Login Functionality
    Given user is on login page using "chrome" browser
    When user entered valid username and password
      | prafulp1010@gmail.com | Pr@ful0812  |
    And user should click on login button

  Scenario: Test HomePage Functionality
    Given user is on homepage and validate the title of homepage
    And Validate the url of the homepage
    And valdate the logo of the homepage
    
    