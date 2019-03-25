package net.johnberendsen.stepdefs;

import cucumber.api.java.en.*;
import net.johnberendsen.steps.HomePageSteps;

import net.thucydides.core.annotations.Steps;

public class HomePageStepDefs {

    @Steps
    private HomePageSteps homePageSteps;

    @Given("^User is on homepage$")
    public void userIsOnHomePage() {
        homePageSteps.openSite();
    }

    @Then("^it show a correct title$")
    public void itShowsACorrectTitle() {
        homePageSteps.checkTitle();
    }

    @And("^it has a working link to github$")
    public void itHasAWorkingGithubLink() {
        homePageSteps.checkGithubLink();
    }
}
