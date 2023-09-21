Feature: SmartBear order feature

  @scenarioOutline
  Scenario Outline: User ordering a product from Orders page
    Given User is logged into SmartBear Tester account and on Order page
    When User fills out form as followed from the table below:
    And User selects "<product>" from product dropdown
    And User enters "<quantity>" to quantity
    And User enters "<expectedName>" to costumer name
    And User enters "<street>" to street
    And User enters "<city>" to city
    And User enters "<state>" to state
    And User enters "<zip>" to zip
    And User selects "<cardType>" as card type
    And User enters "<card number>" to card number
    And User enters "<expiration date>" to expiration date
    And User clicks process button
    Then User verifies "<actualName>" is in the list

    Examples:
      | product | quantity | expectedName | street        | city   | state   | zip   | cardType | card number      | expiration date | actualName |
      | MyMoney | 2        | jamal        | 122 london st | london | chelsea | 55323 | visa     | 3333555533335555 | 12/21           | jamal      |
      | MyMoney | 2        | shirin       | 122 london st | london | chelsea | 55323 | visa     | 3333555533335555 | 12/21           | shirin     |
      | MyMoney | 2        | jair         | 122 london st | london | chelsea | 55323 | visa     | 3333555533335555 | 12/21           | jair       |
      | MyMoney | 2        | mel          | 122 london st | london | chelsea | 55323 | visa     | 3333555533335555 | 12/21           | mel        |

    #  | MyMoney     | 1        | Ken Adams       | Kinzie st     | Chicago     | IL      | 60004 | Visa     | 313313133315     | 12/22           | Ken Adams       |
    #  | FamilyAlbum | 4        | Joey Tribbiani  | State st      | Chicago     | IL      | 60656 | Visa     | 123433533336     | 11/22           | Joey Tribbiani  |
     # | ScreenSaver | 5        | Rachel Green    | Michigan st   | Chicago     | IL      | 60056 | Visa     | 335333333337     | 10/22           | Rachel Green    |
     # | MyMoney     | 5        | Chandler Bing   | Erie st       | Chicago     | IL      | 60666 | Visa     | 433353333338     | 10/22           | Chandler Bing   |
    #  | FamilyAlbum | 9        | Dr DrakeRamoray | Dale st       | Arl Hgths   | IL      | 60452 | Visa     | 532333335334     | 10/22           | Dr DrakeRamoray |
     # | ScreenSaver | 10       | Monica Geller   | Euclid ave    | Arl Hgths   | IL      | 60312 | Visa     | 733533333333     | 10/22           | Monica Geller   |
    #  | MyMoney     | 3        | Ross Geller     | River rd      | Des Plaines | IL      | 60666 | Visa     | 833435363732     | 10/22           | Ross Geller     |
    #  | MyMoney     | 1        | Ken Adams       | Kinzie st     | Chicago     | IL      | 60312 | Visa     | 933533333531     | 12/22           | Ken Adams       |
