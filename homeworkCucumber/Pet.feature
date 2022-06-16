Feature: User API

  //id name category status
  Scenario: Add new user
    Given a new user is created having id:1122 name:'Doggo' status:'available'
    When add new user API is called
    Then request status code is 200

  Scenario Outline: Add new user with examples
    Given a new user is created having id:<id> name:'<name>' status:'<status>'
    When add new user API is called
    Then request status code is 200
    Examples:
      | id | name    | status    |
      | 21 | rosie   | sold      |
      | 22 | cookie  | available |
      | 23 | black   | available |
      | 24 | snow    | sold      |

  @pet
  Scenario: Check user was inserted
    Given a new user is created having id:25 name:'lucky' status:'sold'
    When add new user API is called
    Then request status code is 200
    When get pet by id api is called
    Then correct user is retrieved

  Scenario: Use regex
    Given use regex here

  Scenario: Passing list
    Given the following animals:
      | cow   |
      | horse |
      | sheep |

  Scenario Outline: Using tags with examples
    Given print '<words>' from examples

    Examples:
      | words         |
      | first example |

    Examples:
      | words          |
      | second example |