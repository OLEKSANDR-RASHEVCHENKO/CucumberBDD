package CucumberFramework.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/CucumberFramework/features/login.feature",glue = {"StepDefinations"})
public class TestRun {

}
