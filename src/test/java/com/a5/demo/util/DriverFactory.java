package com.a5.demo.util;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;

import static java.lang.System.getProperty;

/**
 * Description: Driver configuration class Created by timshi Date: 2019/07/17 Time: 13:26
 */
@Component
public class DriverFactory {

    @Autowired
    public DriverFactory() {
    }

    /*
    Local WebDriver setup
    Only support chrome and firefox for now, can setup more base on needs.
     */
    public WebDriver getLocalWebDriver() {

        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "./lib/win/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "./lib/mac/chromedriver");
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        return new ChromeDriver(chromeOptions);

    }
}
