package assignment.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigurationReader;
import utils.Driver;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            TakesScreenshot takeScreenshots =(TakesScreenshot) Driver.getDriver();
            byte[] screenshot = takeScreenshots.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }
}
