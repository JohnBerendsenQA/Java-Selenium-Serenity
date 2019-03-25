# JAVA Serenity Cucumber

Dit project runs via Maven 3.3.1 of higher and JDK 1.8.

To be able to run against different environments and with different webdrivers we make use of the following system variables:
* environment
* webdriver

These can be passed as a maven profile or can be set as variables in the ide

The environment (profile) possibilities:
* dev
* test
* acc
* prd

The webdriver (profiles) possibilities:
* firefox
* configuarble browserstack drivers

Use the following command to run the test against the prd enviroment with a fiurefox browser
```
mvn clean verify -P test,firefox
```
