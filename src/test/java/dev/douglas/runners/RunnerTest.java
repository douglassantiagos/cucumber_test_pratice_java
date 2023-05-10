package dev.douglas.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			//features = "src/test/resources/features/aprender_cucumber.feature",
			features = "src/test/resources/features",
			glue = {"dev.douglas.steps", "dev.douglas.config"},
			//tags = "@esse",
			tags = {"@unitários", "not @ignore"},
			//tags = {"@tipo1", "@tipo2"},
			plugin = {
					"pretty",
					"html:target/report-html",
					"json:target/report.json",
					"junit:target/report.xml"
		    },
			monochrome = true,
			snippets = SnippetType.CAMELCASE,
			dryRun = false, // propriedade por deafault é false
			strict = false // propriedade por deafault é false
		)
public class RunnerTest {
	
}
