package net.johnberendsen.steps;

import net.johnberendsen.support.PropertySupport;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class BaseSteps {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseSteps.class);

    @ManagedPages
    Pages pages;

    Properties envProperties = PropertySupport.getInstance().getProperties();

    @Step
    public void openSite() {
        pages.getDriver().get(pages.getDefaultBaseUrl());
    }
}
