@BRIT-4184
Feature: Search functionality

  Background: Steps to direct manager to the 'Control Accounts' page
    Given manager signs in
    When manager clicks Lunch Button
    And manager clicks on Control Accounts button

  Scenario: Verify manager can filter results by categories
    Then manager should see default search term as "By Employee"
    When manager clicks on x next to By Employee
    And manager clicks on Group By
    And manager clicks on Add custom group
    And manager selects any category from the dropdown box and click Apply
    And manager should see default search term is changed to Date

  Scenario: Verify manager can filter results by categories
    When manager clicks on x next to By Employee
    And manager clicks on Filters tab
    And manager clicks on Add Custom Filter
    And manager selects category, condition and value from dropdown list and click Apply
    And manager should see default search term changed to the newly selected one