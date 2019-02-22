@BRIT-4191
Feature: Kanban view functionality

  Background: Steps to direct manager to the 'Control Accounts' page
    Given manager signs in
    When manager clicks Lunch Button
    And manager clicks on Control Accounts button
    And manager clicks on Kanban grid view

  Scenario Outline: Verify manager can add a transaction in Kanban view
    And manager clicks on Create button
    And manager enters "<user>", "<amount>", "<description>" fields
    And manager clicks on Save button
    Then manager should see system displays newly created transaction's "<user>", "<amount>", "<description>" informations correctly
    Examples:
      | user                    | amount | description   |
      | Aziza                   | 15.00  | Chicken Wings |
      | Lunch_InvoicingManager3 | 7.00   | Spaghetti     |
      | Lunch_InvoicingManager4 | 10.00  | Baklava       |

  Scenario: Verify manager can delete a transaction in Kanban view
    And manager clicks on any transaction
    And manager clicks on Click on Action
    And manager clicks on Delete
    Then manager should see next transaction's id

  Scenario: Verify manager can edit a transaction in Kanban view
    And manager clicks on any transaction
    And manager clicks on Edit
    And manager edits user, date, amount, and description fields
    Then manager should see same transaction's id