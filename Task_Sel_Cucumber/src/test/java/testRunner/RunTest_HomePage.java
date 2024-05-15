package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Feature/HomePage.feature"}, 
				glue = "step_Definition")
public class RunTest_HomePage {

}
