package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='oe_menu_toggler'])[10]")
    public WebElement lucnhButton;

    @FindBy(css = ".oe_topbar_name")
    public WebElement accountOptionsDDown;

    @FindBy(css = "a[data-menu='logout']")
    public WebElement logOutButton;

    @FindBy(xpath = "//a/b")
    public WebElement signInButton;


}
