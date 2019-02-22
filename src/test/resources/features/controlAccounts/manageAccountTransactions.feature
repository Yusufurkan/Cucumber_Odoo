@BRIT-4166
Feature: Manage account balances

  Background: Steps to direct manager to the 'Control Accounts' page
    Given manager signs in
    When manager clicks Lunch Button
    And manager clicks on Control Accounts button

  Scenario: Verify total amount of all balances at the bottom of the page
    Then manager should see transactions for all employees
    And manager should see correct sum of all transactions

  Scenario: Verify manager can see accounts by employee
    Then manager should see the accounts are grouped by employee
    And manager should see that employee names alphabetically sorted
    When manager clicks on any employee name
    Then manager should only see selected employee's account balances
    And manager should see correct total transaction number next to the employee name

  Scenario Outline: Verify clicking header of a category, that category is sorted
    When manager clicks on any employee
    And manager clicks on "<category>" table header
    Then manager should see the "<category>" sorted ascending order
    Examples:
      | category    |
      | Date        |
      | Description |
      | Amount      |