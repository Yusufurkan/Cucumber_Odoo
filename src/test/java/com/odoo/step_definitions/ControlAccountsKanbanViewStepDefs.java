package com.odoo.step_definitions;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ControlAccountsKanbanViewStepDefs {

    Pages pages = new Pages();
    int r = (int) (Math.random() * pages.controlAccountsKanbanViewPage().transactions.size());


    @When("manager clicks on Kanban grid view")
    public void manager_clicks_on_Kanban_grid_view() {
        pages.controlAccountsPage().kanbanView.click();
    }

    @When("manager clicks on Create button")
    public void manager_clicks_on_Create_button() {
        pages.controlAccountsKanbanViewPage().createBtn.click();
    }


    @When("manager enters {string}, {string}, {string} fields")
    public void manager_enters_fields(String user, String amount, String description) {
        pages.controlAccountsCreatePage().userField.clear();
        pages.controlAccountsCreatePage().userField.sendKeys(user);
        pages.controlAccountsCreatePage().userSelected.click();

        pages.controlAccountsCreatePage().amountField.clear();
        pages.controlAccountsCreatePage().amountField.sendKeys(amount);

        pages.controlAccountsCreatePage().descriptionField.sendKeys(description);
    }

    @When("manager clicks on Save button")
    public void manager_clicks_on_Save_button() {
        pages.controlAccountsCreatePage().saveBtn.click();
        BrowserUtils.wait(3);
    }

    @Then("manager should see system displays newly created transaction's {string}, {string}, {string} informations correctly")
    public void manager_should_see_system_displays_newly_created_transaction_s_informations_correctly(String user, String amount, String description) {
        assertEquals(user, pages.controlAccountsCreatePage().userAfterCreate.getText());
        assertEquals(amount, pages.controlAccountsCreatePage().amountAfterCreate.getText());
        assertEquals(description, pages.controlAccountsCreatePage().descriptionAfterCreate.getText());
    }

    @When("manager clicks on any transaction")
    public void manager_clicks_on_any_transaction() {
        BrowserUtils.waitForClickablility(pages.controlAccountsKanbanViewPage().transactions.get(r), 10);
        pages.controlAccountsKanbanViewPage().transactions.get(r).click();
    }

    @When("manager clicks on Click on Action")
    public void manager_clicks_on_Click_on_Action() {
        pages.controlAccountsKanbanViewPage().actionButton.click();
    }

    @When("manager clicks on Delete")
    public void manager_clicks_on_Delete() {
        pages.controlAccountsKanbanViewPage().deleteButton.click();
    }

    @Then("manager should see next transaction's id")
    public void manager_should_see_next_transaction_s_id() {
        String cashMoveId = pages.controlAccountsKanbanViewPage().cashMoveId.getText();

        int cashMoveIdBefore = Integer.valueOf(cashMoveId.substring(cashMoveId.indexOf("#")+1));

        pages.controlAccountsKanbanViewPage().okButton.click();
        BrowserUtils.wait(3);

        int cashMoveIdAfter = Integer.valueOf(pages.controlAccountsKanbanViewPage().cashMoveId.getText().substring(cashMoveId.indexOf("#")+1));

        assertTrue(cashMoveIdAfter != cashMoveIdBefore);
    }

    @When("manager clicks on Edit")
    public void manager_clicks_on_Edit() {
        BrowserUtils.waitForClickablility(pages.controlAccountsKanbanViewPage().transactions.get(r), 10);
        pages.controlAccountsKanbanViewPage().transactions.get(r).click();

        pages.controlAccountsKanbanViewPage().editButton.click();
    }

    @When("manager edits user, date, amount, and description fields")
    public void manager_edits_user_date_amount_and_description_fields() {
        pages.controlAccountsCreatePage().userField.click();
        pages.controlAccountsCreatePage().userSelected.click();
        pages.controlAccountsCreatePage().amountField.clear();
        pages.controlAccountsCreatePage().amountField.sendKeys("25.00");
        pages.controlAccountsCreatePage().descriptionField.clear();
        pages.controlAccountsCreatePage().descriptionField.sendKeys("Pide");
        pages.controlAccountsCreatePage().saveBtn.click();
    }

    @Then("manager should see same transaction's id")
    public void manager_should_see_same_transaction_s_id() {
        String cashMoveId = pages.controlAccountsKanbanViewPage().cashMoveId.getText();

        int cashMoveIdBefore = Integer.valueOf(cashMoveId.substring(cashMoveId.indexOf("#")+1));
        int cashMoveIdAfter = Integer.valueOf(pages.controlAccountsKanbanViewPage().cashMoveId.getText().substring(cashMoveId.indexOf("#")+1));

        assertTrue(cashMoveIdAfter == cashMoveIdBefore);
    }


}
