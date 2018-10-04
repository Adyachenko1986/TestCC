package callcenter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/acceptanceTest", "json:target/cucumber.json"}, //,"rerun:target/rerun.txt"
//        monochrome = true,
        features = "src/test/resources/stationar/features",
        glue = "stationar/steps",
        tags = "@stat1"
//        tags = "@Test"


//        snippets = SnippetType.UNDERSCORE
)


public class Parallel1IT {

}