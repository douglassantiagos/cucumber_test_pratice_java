package dev.douglas.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			//features = "src/test/resources/features/aprender_cucumber.feature",
			features = "src/test/resources/features",
			glue = {"dev.douglas.steps", "dev.douglas.config"},
			//tags = "@esse",
			tags = {"@funcionais"},
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
public class RunnerFuncionalTest {
	
	@BeforeClass
	public static void resetDados() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("douglassanti@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"senha\"]")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div[2]/form/button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
