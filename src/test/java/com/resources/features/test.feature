Feature: autotrader

  Scenario: User opens the given URL and verifies, Make,Model, Zip code, Advance search


    Given User opens Autotrader Webside
    Then User verifies link "Browse by Make" is present
   Then User verifies link "Browse by Style" is present
   Then User verifies link "Advanced Search" is present

    And User Verifies dropdown "Any Make" is present
    And User Verifies dropdown "Any Model" is present
    And User Verifies  ZipCode window  is present
    And User verifies Search button is present


  Scenario: User checks Advanced Search link

    Given User clicks on Advanced Search Link on the Home Page
    Then User enters "30004" into ZipCode box
    Then User selects "Certified" Check box under Condition section
    Then User selects "20000" in Minimum dDown and "75000" Maximum dDown
    Then User selects "Convertible" Check box under Style section
    Then User updates "2017" in From dDown and "2020" in To dDown
    And User selects "BMW" in Any Make dDown under Make, Model&Trim section
    And User selects "Under 100,000" in the Mileage section
    And User clicks on "Exterior Color" link and checks "Silver" Check box under Specifications section
    Then User clicks Search button
    And User verifies he is in the result page
    Then User verifies he sees only "BMW" make cars
    And User verifies the number of listings

  Scenario Outline: testing multiple entry
    Given User chooses make as "<model>"
    Examples:
      | model    |
      | BMW      |
      | Auidi    |
      | Mercedes |
      | Toyota   |
      | Acura    |
      | BMW      |
      | Auidi    |
      | Mercedes |
      | Toyota   |
      | Acura    |
