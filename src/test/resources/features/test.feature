Feature:shdhdd
  Scenario: gghff


   Given I retrieve car registration numbers from the input file
    #When I search on the cazoo website from given sheetname "input_file.xls" and rownumber "RowNumber"
    When I search on the cazoo website with first "1" registration number
    Then I should retrieve the results and compare with the output file



   # Given I open a page

