package callcenter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Pages;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/acceptanceTest", "json:target/cucumber.json"},
        features = "src/test/java/callcenter/features",
        glue = "callcenter/steps",
        tags = "@acceptanceTest",
//        dryRun = false,
//        strict = false,
        snippets = SnippetType.UNDERSCORE)

public class AbstractTest {
    public static WebDriver driver;
    public static Pages page;
    public static String curUrlCalldoctor = null;
    public static ChromeOptions chromeOptions;
    public static ChromeDriverService chromeDriverService;

    @BeforeClass
    static public void setupTimeout() {
        chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1900,1020");
        driver = new ChromeDriver(chromeDriverService, chromeOptions);
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 20000;
    }
}