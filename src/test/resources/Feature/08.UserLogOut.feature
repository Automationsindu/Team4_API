#Author: Vani
Feature: User Log out

  Background: Set bearer token in header

  @Logout1
  Scenario Outline: Check admin able to logout
    Given Admin User creates GET request to logout
    When The "<User>" send GET HTTP request with endpoint
    Then Admin User recieves 200 created with Logout successful message

    Examples: 
      | User      |
      | Admin     |
      | Dietician |
      | Patient   |

  @InvalidMethodLogout2
  Scenario Outline: Check admin able to logout  with invalid method
    Given Admin User creates POST request to logout
    When The "<User>" send POST HTTP request with endpoint to logout
    Then Admin User recieves 405 method not allowed when logging out

    Examples: 
      | User      |
      | Admin     |
      | Dietician |
      | Patient   |

  @LogoutNoAuth3
  Scenario Outline: Check admin able to logout  without auth
    Given Admin User creates GET request to logout
    When The "<User>" send GET HTTP request with no Auth and with endpoint
    Then Admin User recieves 401 unauthorized without auth

    Examples: 
      | User      |
      | Admin     |
      | Dietician |
      | Patient   |
