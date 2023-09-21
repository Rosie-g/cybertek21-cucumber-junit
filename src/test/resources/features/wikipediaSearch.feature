Feature: Wikipedia search feature
  As a user, i should be able to search terms and see related results

@wiki
  Scenario: Wikipedia search title verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title

@kiki
  Scenario: Wikipedia search title verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  Scenario: Wikipedia search title verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header


  Scenario Outline: Wikipedia search title verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedMainHeader>" is in the main header
    Then User sees "<expectedTitle>" is in the wiki title


    Examples: search terms we are going to search in wikipedia
      | searchValue   | expectedMainHeader | expectedTitle |
      | Julia Roberts | Julia Roberts      | Julia Roberts |
      | Steve Jobs    | Steve Jobs         | Steve Jobs    |
      | Kobe Bryant   | Kobe Bryant        | Kobe Bryant   |
      | Elon Musk     | Elon Musk          | Elon Musk     |
      | Bill Gates    | Bill Gates         | Bill Gates    |
      | Chuck Norris  | Chuck Norris       | Chuck Norris  |
      | Marie Curie   | Marie Curie        | Marie Curie   |

