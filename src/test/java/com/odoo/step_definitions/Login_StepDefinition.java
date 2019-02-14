package com.odoo.step_definitions;

import com.odoo.pages.LoginPage;
import com.odoo.utilities.ConfigurationReader;
import com.odoo.utilities.Driver;
import com.odoo.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class Login_StepDefinition {
    Pages pages =new Pages();

    @Given("using valid credential sign in as a manager and click lunch")
    public void using_valid_credential_sign_in_as_a_manager_and_click_lunch() {
        pages.login().goLunch();
    }
}