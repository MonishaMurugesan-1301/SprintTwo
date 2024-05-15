package Test_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
	@CucumberOptions(
	features="src\\test\\java\\Feature\\HomepageRegistry.feature",
	glue={"Step_definition"},
	//plugin={"usage"}
    plugin= {"pretty","html:target/HtmlReports/Report1.html"})
	//plugin="json:target/json_reports/report.json" 
	//plugin="junit:target/junit_reports/report.xml"} )
	
public class TestRunner_Registry {

}
