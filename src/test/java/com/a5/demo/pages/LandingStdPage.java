package com.a5.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class LandingStdPage {
    public WebDriver driver;

    @FindBy(id = "landing_title")
    public WebElement strTitle;

    public LandingStdPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
