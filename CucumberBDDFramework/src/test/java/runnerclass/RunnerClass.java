package runnerclass;

import org.junit.runner.RunWith; 


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features ="FeatureFiles",
glue ="stepdefination", 
dryRun = false,
monochrome=false,
tags = "@regression",

plugin = {"html:reports/webreport.html", "json:report/jsonreport.json", "html:target/cucumber-reports.html"}

		)

public class RunnerClass {

}