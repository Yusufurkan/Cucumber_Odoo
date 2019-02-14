package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Constants {
    public Constants() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='btn-group o_dropdown'])[3]")
    public WebElement filter;

    @FindBy(xpath = "(//ul[@class='dropdown-menu o_filters_menu'])/li")
    public List<WebElement> filters;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[2]/li/a")
    public List<WebElement> userDrop;

    @FindBy(xpath = "//span[@title='Advanced Search...']")
    public WebElement magnet;

    @FindBy(className = "oe_topbar_name")
    public WebElement user;


    public void getToFilter(String functionality) {
        try {
            for (int i = 0; i < filters.size(); i++) {
                if (filters.get(i).getText().equalsIgnoreCase(functionality)) {
                    filters.get(i).click();
                    return;
                }
            }
            throw new Exception("Functionality does not exist.. Check spelling! ");
        } catch (Exception e) {
            System.err.println("Incorrect entry");
        }
    }


    public void goUserDropDown(String userOptions) {
        try {
            for (int i = 0; i < userDrop.size(); i++) {
                if (userDrop.get(i).getText().equalsIgnoreCase(userOptions)) {
                    userDrop.get(i).click();
                    return;
                }
            }
            throw new Exception("Functionality does not exist.. Check spelling! ");
        } catch (Exception e) {
            System.err.println("Incorrect entry");
        }
    }

    public void logOut() {
        user.click();
        userDrop.get(4).click();
    }
}
