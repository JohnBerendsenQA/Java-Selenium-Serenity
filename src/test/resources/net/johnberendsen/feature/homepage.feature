Feature: Homepage
  To quickly find the most important info or routes to this
  as a user
  I want to be served a correct homepage with relevant working links

  Scenario: visit homepage
    Given User is on homepage
    Then it show a correct title
      And it has a working link to github


