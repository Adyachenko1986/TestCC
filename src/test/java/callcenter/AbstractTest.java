package callcenter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Pages;

import java.io.File;

import static com.codeborne.selenide.Selenide.close;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/acceptanceTest", "json:target/cucumber.json"},
        features = "src/test/java/callcenter/features",
        glue = "callcenter/steps",
        tags = "@acceptanceTest",
        snippets = SnippetType.UNDERSCORE)

public class AbstractTest {
    public static Pages page;
    public static WebDriver driver;
    public static ChromeOptions chromeOptions;
    public static ChromeDriverService chromeDriverService;

    @BeforeClass
    static public void setupTimeout() {
        chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1240,1020");
        driver = new ChromeDriver(chromeDriverService, chromeOptions);
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 8000;
        page = new Pages();
    }

    @AfterClass
    static public void afterTests( ) {
        close();
    }
//    @AfterClass
//    static public void afterTests(Scenario scenario) {
//        if (scenario.isFailed()) {
////        if (scenario.isFailed()) {
//            try {
//                scenario.write("Current Page URL is " + driver.getCurrentUrl());
////            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
//                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                scenario.embed(screenshot, "image/png");
//            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
//                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
//            }
//        }
//        close();
//    }
}