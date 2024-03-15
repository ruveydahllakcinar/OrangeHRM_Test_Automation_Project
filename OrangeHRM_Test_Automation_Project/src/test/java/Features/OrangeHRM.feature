@OrangeHRM
Feature: OrangeHRM Check Test Cases

  @AllEmpty
  Scenario Outline: Empty username & password
    Given User at login page
    When  Click login button
    Then Check "<error>" message about username
    Examples:
      | error    |
      | Required |

  @FalseUsername
  Scenario Outline: False username & correct password
    Given  User at login page
    When Enter False "<username>" for username field
    When Enter Correct "<password>" for password field
    When Click login button
    Then Check "<error>" message about invalid credentials
    Examples:
      | error               | username | password |
      | invalid credentials | Tester   | admin123 |


  @FalsePassword
  Scenario Outline: Correct username & false password
    Given  User at login page
    When Enter Correct "<username>" for username field
    When Enter False "<password>" for password field
    When Click login button
    Then Check "<error>" message about invalid credentials
    Examples:
      | error               | username | password  |
      | invalid credentials | Admin    | tester123 |

  @AllCorrect
  Scenario Outline: Username & password are correct
    Given User at login page
    When  write Correct "<username>" for username field
    When  write correct "<password>" for password field
    When Click login button
    Then Login is succesful

    Examples:
      | username | password  |
      | Admin    | admin123  |


  @ChangeName
  Scenario: Change First Name and Last Name
    Given User at login page
    When  write Correct "<username>" for username field
    When  write correct "<password>" for password field
    When Click login button
    Then Login is succesful
    When Click to My Info button
    When Change Name and Surname
    When Click to Save Button
    Then Check New Name and Surnam