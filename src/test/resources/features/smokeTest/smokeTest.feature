@smokeTest
Feature: Check the title for each module in Lunch page

  Scenario Outline: Verify the titles <module>
    Given using valid credential sign in as a manager and click lunch
    And click on the "<module>" verify "<title>"

    Examples:
      | module             | title               |
     #| New Order          | New                 |
      | Previous Orders    | Your Orders         |
      | Your Lunch Account | Your Account        |
      | Today's Orders     | Orders by Vendor    |
      | Orders by Vendor   | Control Vendors     |
      | Control Accounts   | Control Accounts    |
      | Employee Payments  | Register Cash Moves |
      | Products           | Products            |
      | Product Categories | Product Categories  |
      | Alerts             | Alerts              |