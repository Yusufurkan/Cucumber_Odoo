package com.odoo.pages;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.ConfigurationReader;
import com.odoo.utilities.Driver;
import com.odoo.utilities.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.krb5.Config;

public class LoginPage {
    Pages pages = new Pages();

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Sign in")
    public WebElement signInBtn;

    @FindBy(linkText = "BriteErpDemo")
    public WebElement demo;

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "(//button)[2]")
    public WebElement loginBttn;


    public void signIn() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        demo.click();
        email.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginBttn.click();
    }

    public void goLunch() {
        pages.login().signIn();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 7);
        wait.until(ExpectedConditions.elementToBeClickable(pages.main().lucnhButton)).click();
        pages.lunchPage().closePopup();
    }
}
