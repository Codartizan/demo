package com.a5.demo.steps;

import com.a5.demo.hook.CukeHook;
import com.a5.demo.pages.IndexPage;
import com.a5.demo.pages.LandingStdPage;
import com.a5.demo.pages.SSOLoginPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class ExampleTestStepDef implements En {

    private WebDriver driver;
    private IndexPage indexPage;
    private LandingStdPage landingStdPage;
    private SSOLoginPage ssoLoginPage;
    private WebDriverWait wait;
    @Autowired CukeHook cukeHook;
    @Value("${spring.app.url}")
    private String url;
    public ExampleTestStepDef() {

        Given("^open website$", () -> {
            driver = cukeHook.getWebDriver();
            wait = new WebDriverWait(driver, 30);
            indexPage = new IndexPage(driver);
            landingStdPage = new LandingStdPage(driver);
            ssoLoginPage = new SSOLoginPage(driver);
            driver.get(url);
        });
        When("^I click login button$", () -> {
            indexPage.btnLogin.click();
        });
        Then("^I should be redirected to sso page$", () -> {
            wait.until(ExpectedConditions.visibilityOf(ssoLoginPage.username));
            Assert.assertEquals("UoA-SSO", driver.getTitle());
        });
        When("^I enter credentials with (.*) and (.*)$", (String usr, String pwd) -> {
            ssoLoginPage.username.sendKeys(usr);
            ssoLoginPage.password.sendKeys(pwd);
            ssoLoginPage.btnLogin.click();
        });
        Then("^I should be login successful$", () -> {
            wait.until(ExpectedConditions.visibilityOf(landingStdPage.strTitle));
            Assert.assertEquals("Landing Page", driver.getTitle());
        });

    }
}
