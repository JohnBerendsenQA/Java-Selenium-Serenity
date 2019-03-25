package net.johnberendsen.pageobjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends JohnBerendsenBasePageObject {

    @FindBy(css = ".title-hl")
    private WebElement title;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public WebElement getGithubLink() {
        return getDriver().findElement(By.linkText("CHECK OUT MY GITHUB"));
    }
}
