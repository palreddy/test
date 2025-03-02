Feature:
  As a car Owner
  I want to know my car valuation
  So that I know the value of my car

  Scenario: 1 Test to verify the car valuation results
    Given I retrieve car registration numbers from the input file
    When I search on the cazoo website with first "1" registration number
   Then I should verify the car details and confirm



