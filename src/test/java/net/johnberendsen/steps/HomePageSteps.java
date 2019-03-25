package net.johnberendsen.steps;

import net.johnberendsen.pageobjects.HomePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomePageSteps extends BaseSteps {

    private HomePage homePage;

    @Step
    public void checkTitle() {
        assertThat("Incorrect title", homePage.getTitle().equals("John Berendsen"));
    }

    @Step
    public void checkGithubLink() {
        assertThat("Incorrect Github link", homePage.getHttpResponseCodeOfWebElement(homePage.getGithubLink()), is(200));
    }
}
