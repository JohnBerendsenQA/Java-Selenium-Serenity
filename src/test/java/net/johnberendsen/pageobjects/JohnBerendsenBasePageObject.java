package net.johnberendsen.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JohnBerendsenBasePageObject extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(JohnBerendsenBasePageObject.class);

    public JohnBerendsenBasePageObject(WebDriver driver) {
        super(driver);
    }

    public int getHttpResponseCodeOfWebElement(WebElement element) {
        String urlString = element.getAttribute("href");
        URL url;
        int responseCode = 0;
        try {
            url = new URL(urlString);
            HttpURLConnection huc;
            huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            responseCode = huc.getResponseCode();
        } catch (IOException e) {
            LOGGER.error("error gettinh http responsecode for url: {}", urlString);
        }
        return responseCode;
    }
}
