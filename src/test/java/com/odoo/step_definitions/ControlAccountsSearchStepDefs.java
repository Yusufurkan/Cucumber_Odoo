package com.odoo.step_definitions;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ControlAccountsSearchStepDefs {

    Pages pages = new Pages();

    @Then("manager should see default search term as {string}")
    public void manager_should_see_default_search_term_as(String defSearchTerm) {
        BrowserUtils.isElementsTextAMatch(pages.controlAccountsPage().defaultSearchTerm, "By Employee", 10);
    }

    @When("manager clicks on x next to By Employee")
    public void manager_clicks_on_x_next_to_By_Employee() {
        pages.controlAccountsPage().defaultSearchTermRemoveBtn.click();

        pages.controlAccountsPage().advancedSearchBtn.click();
    }

    @When("manager clicks on Group By")
    public void manager_clicks_on_Group_By() {
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().groupBy, 10).click();
    }

    @When("manager clicks on Add custom group")
    public void manager_clicks_on_Add_custom_group() {
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().addCustomGroup, 10).click();
    }

    @When("manager selects any category from the dropdown box and click Apply")
    public void manager_selects_any_category_from_the_dropdown_box_and_click_Apply() {
        pages.controlAccountsPage().getCustomGroup().selectByVisibleText("Date");
        pages.controlAccountsPage().applyBtn.click();
    }

    @When("manager should see default search term is changed to Date")
    public void manager_should_see_default_search_term_is_changed_to_Date() {
        BrowserUtils.isElementsTextAMatch(pages.controlAccountsPage().defaultSearchTerm, "Date", 10);
    }

    @When("manager clicks on Filters tab")
    public void manager_clicks_on_Filters_tab() {
        pages.controlAccountsPage().filters.click();
    }

    @When("manager clicks on Add Custom Filter")
    public void manager_clicks_on_Add_Custom_Filter() {
        pages.controlAccountsPage().addCustomFilter.click();
    }

    @When("manager selects category, condition and value from dropdown list and click Apply")
    public void manager_selects_category_condition_and_value_from_dropdown_list_and_click_Apply() {
        pages.controlAccountsPage().getcustomFilterCategory().selectByVisibleText("Order");

        pages.controlAccountsPage().getcustomFilterCondition().selectByVisibleText("contains");

        pages.controlAccountsPage().customFilterValue.sendKeys("Pizza");

        pages.controlAccountsPage().filterApplyBtn.click();
    }

    @When("manager should see default search term changed to the newly selected one")
    public void manager_should_see_default_search_term_changed_to_the_newly_selected_one() {
        assertTrue(pages.controlAccountsPage().defaultSearchTerm.getText().contains("Order contains \"Pizza\""));
    }

}
