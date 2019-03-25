package net.johnberendsen.support;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class BrowserHooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserHooks.class);
    Properties envProperties;

    @ManagedPages
    private Pages pages;

    private static WebDriver browser;

    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    @Before
    public void openBrowser(Scenario scenario) {
        envProperties = PropertySupport.getInstance().getProperties();
        pages.getConfiguration().setDefaultBaseUrl(envProperties.getProperty("baseUrl"));
        LOGGER.info("Running test {}", scenario.getName());

        if (browser == null) {
            browser = pages.getDriver();
        }

        browser.manage().window().setSize(new Dimension(1500, 900));
        browser.manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) throws URISyntaxException, IOException {
        if(System.getProperty("browser") == "provided") {
            if (scenario.isFailed()) {
                String sessionID = ((RemoteWebDriver) pages.getDriver()).getSessionId().toString();
                String username = environmentVariables.getProperty("browserstack.user");
                String key =  environmentVariables.getProperty("browserstack.key");
                URI uri = new URI("https://" + username + ":" + key + "@www.browserstack.com/automate/sessions/" + sessionID + ".json");
                HttpPut putRequest = new HttpPut(uri);
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("status", "error"));
                putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpClientBuilder.create().build().execute(putRequest);
            }
        }
        pages.getDriver().quit();
    }
}

