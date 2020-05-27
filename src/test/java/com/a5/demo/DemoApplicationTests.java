package com.a5.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		features = {"src/test/resources/features"},
		plugin = {
				"pretty",
				"html:target/cucumber-html-report",
				"json:target/cucumber/cucumber.json",
				"junit:target/cucumber/cucumber.xml",
				"rerun:target/rerun.txt"
		},
		glue = {"com.a5.demo.steps", "com.a5.demo.hook"},
		junit = {"--step-notifications"},
		monochrome = true
		,tags = {"not @deprecated"}
)
public class DemoApplicationTests {
}
