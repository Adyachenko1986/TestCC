package callcenter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Pages;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
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

    static String perek = "тест";

    static String url;
    static String snpol;
    static String fam;
    static String bd;
    static SelenideElement lpu;
    static SelenideElement mcod;
    static SelenideElement apoinmentsList;
    static SelenideElement apoLpu;

//    private void setUp(String base) {
//        switch (base) {
//            case "тест":
//                this.url = "http://local.call/cc_dev/to_work/";
////                this.snpol = "5056900835000459";
////                this.fam = "Карташев А Е";
////                this.bd = "14.03.1990";
////                this.lpu = $(By.xpath("//button[@title='ДЕМИХОВСКАЯ УЧАСТКОВАЯ БОЛЬНИЦА; Адрес: 142632, Московская область, Орехово-Зуевский район, д. Демихово, ул. Заводская']"));
////                this.mcod = $(By.xpath("//button[@data-lpucode='330501']"));
////                this.apoinmentsList = $(By.xpath("//*[@id='direction-list-tab']"));
////                this.apoLpu = $(By.xpath("//*[@id='c3c977af-c3b4-4517-9d57-50a6844ec660B70332CC-940B-4284-BB44-48AA981F3AB9']/td[6]/button"));
//                break;
//            case "прод":
//                this. url = "http://call.emias.mosreg.ru/cc_dev/to_work/";
////                this. snpol = "45 558320";
////                this.fam = "Карташев А Е";
////                this.bd = "14.03.1990";
////                this.lpu = $(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']"));
////                this.mcod = $(By.xpath("//button[@data-lpucode='330501']"));
////                this.apoinmentsList = $(By.xpath("//*[@id='direction-list']/div/div[2]/button"));
////                this.apoLpu = $(By.xpath("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb123326f407bc-01c7-4e64-ae16-80ae909b1574']/td[6]/button"));
//                break;
//        }
//    }

    @BeforeClass
     public static void setupTimeout() {
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

//        new AbstractTest().setUp(perek);
    }

//    @AfterClass
//    static public void afterTests() {
//        close();
//    }

    @After
    static public void afterTests() {
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