package com.odoo.step_definitions;

import com.odoo.utilities.Driver;
import com.odoo.utilities.Pages;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmokeTest_stepDefinition {
    Pages pages = new Pages();


    //TODO add sign out method and leave ,, also remove drover.quit after method

    @Given("click on the {string} verify {string}")
    public void click_on_the_verify(String module, String title) {
        pages.lunchPage().goToFunctionality(module);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        String url = Driver.getDriver().getCurrentUrl();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));

        Assert.assertEquals(pages.lunchPage().title.getText(), title);
       // pages.constants().logOut();


    }
}
