package assignment.runners;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
                plugin ={"pretty",
                "html:target/serenity-report.html",
                "rerun:target/rerun.txt"},
                features = "src/test/resources/features",
                glue = "assignment/step_definitions"
)


public class TestRunner {
}
