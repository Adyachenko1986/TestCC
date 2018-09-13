package callcenter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/acceptanceTest", "json:target/cucumber.json"}, //,"rerun:target/rerun.txt"
//        monochrome = true,
        features = "src/test/java/callcenter/features",
        glue = "callcenter/steps",
        tags = "@acceptanceTest11"
//        tags = "@Test"


//        snippets = SnippetType.UNDERSCORE
)


public class RunCallCenterTests {

}