package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="src/main/java/cucumber/createLead.feature",glue= {"hooks","pages"}, tags= {"@Smoke"}, monochrome=true)
@CucumberOptions(features="src/main/java/cucumber",glue= {"hooks","pages"}, tags= {"@delete"}, monochrome=true)
public class Runner {

}
