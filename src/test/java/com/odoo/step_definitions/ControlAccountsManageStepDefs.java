package com.odoo.step_definitions;

import com.odoo.utilities.*;
import cucumber.api.java.en.*;

import static org.junit.Assert.*;

public class ControlAccountsManageStepDefs {

    Pages pages = new Pages();
    int r = (int) (Math.random() * pages.controlAccountsPage().accountNames.size());

    @Given("manager signs in")
    public void manager_signs_in() {
        pages.login().demo.click();
        pages.login().email.sendKeys(ConfigurationReader.getProperty("username"));
        pages.login().password.sendKeys(ConfigurationReader.getProperty("password"));
        pages.login().loginBttn.click();
    }

    @When("manager clicks Lunch Button")
    public void manager_clicks_Lunch_Button() {
//        BrowserUtils.waitForVisibility(pages.main().lucnhButton, 10);
//        BrowserUtils.waitForClickablility(pages.main().lucnhButton, 10);
        BrowserUtils.wait(5);
        pages.main().lucnhButton.click();
    }

    @When("manager clicks on Control Accounts button")
    public void manager_clicks_on_Control_Accounts_button() {
        pages.lunchPage().closePopup();
        pages.controlAccountsPage().controlAccountsButton.click();
    }

    @Then("manager should see transactions for all employees")
    public void manager_should_see_transactions_for_all_employees() {
        for (int i = 0; i < pages.controlAccountsPage().allAmounts.size(); i++) {
            assertTrue(BrowserUtils.waitForVisibility(pages.controlAccountsPage().allAmounts.get(i), 10).isDisplayed());
        }
    }

    @Then("manager should see correct sum of all transactions")
    public void manager_should_see_correct_sum_of_all_transactions() {
        double sum = 0;
        for (int i = 0; i < pages.controlAccountsPage().allAmounts.size(); i++) {
            sum += Double.valueOf(pages.controlAccountsPage().allAmounts.get(i).getText().replace(",", ""));
        }
        assertEquals(String.valueOf(sum).substring(0, String.valueOf(sum).indexOf(".") + 3), pages.controlAccountsPage().totalAmount.getText().replace(",", ""));
    }

    @Then("manager should see the accounts are grouped by employee")
    public void manager_should_see_the_accounts_are_grouped_by_employee() {
        for (int i = 0; i < pages.controlAccountsPage().accountNames.size(); i++) {
            assertTrue(BrowserUtils.waitForVisibility(pages.controlAccountsPage().accountNames.get(i), 10).isDisplayed());
        }
    }

    @Then("manager should see that employee names alphabetically sorted")
    public void manager_should_see_that_employee_names_alphabetically_sorted() {
        for (int i = 0; i < pages.controlAccountsPage().accountNames.size() - 1; i++) {
            String current = pages.controlAccountsPage().accountNames.get(i).getText();
            String next = pages.controlAccountsPage().accountNames.get(i + 1).getText();

            assertTrue(current.compareTo(next) < 0);
        }
    }

    @When("manager clicks on any employee name")
    public void manager_clicks_on_any_employee_name() {
        pages.controlAccountsPage().accountNames.get(r).click();
    }

    @Then("manager should only see selected employee's account balances")
    public void manager_should_only_see_selected_employee_s_account_balances() {
        for (int i = 0; i < pages.controlAccountsPage().employeeAccountAmounts.size(); i++) {
            assertTrue(BrowserUtils.waitForVisibility(pages.controlAccountsPage().employeeAccountAmounts.get(i), 10).isDisplayed());
        }
    }

    @Then("manager should see correct total transaction number next to the employee name")
    public void manager_should_see_correct_total_transaction_number_next_to_the_employee_name() {
        assertTrue(pages.controlAccountsPage().allAmounts.get(r).isDisplayed());
    }

    @When("manager clicks on any employee")
    public void manager_clicks_on_any_employee() {
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().accountNames.get(r), 10).click();
    }

    @When("manager clicks on {string} table header")
    public void manager_clicks_on_table_header(String category) {
        BrowserUtils.wait(3);
        switch (category) {
            case "Date":
                pages.controlAccountsPage().dateHeader.click();
                break;
            case "Description":
                pages.controlAccountsPage().descriptionHeader.click();
                break;
            case "Amount":
                pages.controlAccountsPage().amountHeader.click();
        }
    }

    @Then("manager should see the {string} sorted ascending order")
    public void manager_should_see_the_sorted_ascending_order(String category) {
        BrowserUtils.wait(3);
        switch (category) {
            case "Date":
                for (int i = 0; i < pages.controlAccountsPage().transactionDates.size() - 1; i++) {
                    int currentMonth = Integer.parseInt(pages.controlAccountsPage().transactionDates.get(i).getText().substring(0, 2));
                    int nextMonth = Integer.parseInt(pages.controlAccountsPage().transactionDates.get(i + 1).getText().substring(0, 2));
                    int currentDay = Integer.parseInt(pages.controlAccountsPage().transactionDates.get(i).getText().substring(3, 5));
                    int nextDay = Integer.parseInt(pages.controlAccountsPage().transactionDates.get(i + 1).getText().substring(3, 5));

                    if (currentMonth != nextMonth && currentDay == nextDay) {
                        assertTrue(currentMonth < nextMonth);
                    } else if (currentMonth == nextMonth && currentDay != nextDay) {
                        assertTrue(currentDay < nextDay);
                    } else {
                        continue;
                    }
                }
                break;
            case "Description":
                for (int i = 0; i < pages.controlAccountsPage().transactionDescription.size() - 1; i++) {
                    String current = pages.controlAccountsPage().transactionDescription.get(i).getText();
                    String next = pages.controlAccountsPage().transactionDescription.get(i + 1).getText();

                    if ((current.isEmpty() && next.isEmpty()) || current.isEmpty() || next.isEmpty()) {
                        continue;
                    } else if (current.equals(next)) {
                        continue;
                    } else {
                        assertTrue(current.compareTo(next) < 0);
                    }
                }
                break;
            case "Amount":
                for (int i = 0; i < pages.controlAccountsPage().transactionAmounts.size() - 1; i++) {

                    double current = Double.parseDouble(pages.controlAccountsPage().transactionAmounts.get(i).getText());
                    double next = Double.parseDouble(pages.controlAccountsPage().transactionAmounts.get(i + 1).getText());

                    if (current == next) {
                        continue;
                    } else {
                        assertTrue(current < next);
                    }
                }
        }
    }

}
