package assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SearchPage extends HomePAge{

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//li[@role='button'])[2]")
    public WebElement sitesTab;

    @FindBy(xpath = "(//tbody)[2]//tr")
    public List<WebElement> urlList;

    @FindBy(xpath = "(//li[@class='ng-star-inserted'])[40]")
    public WebElement searchResult1;

    @FindBy(xpath = "(//a[@class='site-search-results-list__link site-name--pre-wrap'])[3]")
    public WebElement searchResult3;


}
