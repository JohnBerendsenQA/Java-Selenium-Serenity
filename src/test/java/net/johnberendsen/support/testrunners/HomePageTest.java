package net.johnberendsen.support.testrunners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/report", "json:target/cucumber/report.json" },
        features = {"src/test/resources/net/johnberendsen/feature/homepage.feature"},
        glue = {"net.johnberendsen.stepdefs", "net.johnberendsen.support"}
)
public class HomePageTest extends BaseTest {
}