Feature:shdhdd
  Scenario: 1
   Given I retrieve car registration numbers from the input file
    #When I search on the cazoo website from given sheetname "input_file.xls" and rownumber "RowNumber"
    When I search on the cazoo website with first "1" registration number
    Then I should retrieve the results and compare with the output file

  Scenario: 2
    Given I retrieve car registration numbers from the input file
    #When I search on the cazoo website from given sheetname "input_file.xls" and rownumber "RowNumber"
    When I search on the cazoo website with first "2" registration number
    Then I should retrieve the results and compare with the output file

  Scenario: 3
    Given I retrieve car registration numbers from the input file
    #When I search on the cazoo website from given sheetname "input_file.xls" and rownumber "RowNumber"
    When I search on the cazoo website with first "3" registration number
    Then I should retrieve the results and compare with the output file

  Scenario: 4
    Given I retrieve car registration numbers from the input file
    #When I search on the cazoo website from given sheetname "input_file.xls" and rownumber "RowNumber"
    When I search on the cazoo website with first "4" registration number
    Then I should retrieve the results and compare with the output file



   # Given I open a page

