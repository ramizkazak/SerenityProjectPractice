package assignment.step_definitions;

import assignment.pages.HomePAge;
import assignment.pages.SearchPage;
import assignment.pages.VerifyHeadersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationReader;
import utils.Driver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AssignmentTest {

    HomePAge homePAge = new HomePAge();
    SearchPage searchPage = new SearchPage();
    VerifyHeadersPage verifyHeadersPage = new VerifyHeadersPage();

    @Given("User on home page")
    public void user_on_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @When("User verify social media page from {string}")
    public void user_verify_social_media_page_from(String expectedTitle) {
        String actualTitle = homePAge.ncsc.getText();
        Assert.assertEquals(expectedTitle,actualTitle);


    }
    @When("perform search by keyword {string}")
    public void perform_search_by_keyword(String keyword) {
        homePAge.keywordBox.sendKeys(keyword);
        homePAge.searchButton.click();



    }
    @When("navigate to sites tab")
    public void navigate_to_sites_tab() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.searchResult1));
        searchPage.sitesTab.click();


    }
    @When("select third item from search result and click")
    public void select_third_item_from_search_result_and_click() {

       searchPage.searchResult3.click();



    }
    @When("navigate to the page")
    public void navigate_to_the_page() {

        String expectedTitle= "Health Workforce Connector - Site Profile Page";
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());

    }
    @Then("click on each tab and verify the headers")
    public void click_on_each_tab_and_verify_the_headers(List<String> expectedHeaders) {

        List<String> actualHeaders = new ArrayList<>();
        for(WebElement each: verifyHeadersPage.topHeader)
           actualHeaders.add(each.getAttribute("innerHTML"));

        for(int i=0; i<actualHeaders.size(); i++)
            Assert.assertTrue(actualHeaders.get(i).contains(expectedHeaders.get(i)));

        Driver.closeDriver();
        }
}
