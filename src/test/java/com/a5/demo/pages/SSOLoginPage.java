package com.a5.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class SSOLoginPage {

    public WebDriver driver;

    @FindBy(id = "btnLoginSSO")
    public WebElement btnLogin;

    @FindBy(id = "user_name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    public SSOLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
