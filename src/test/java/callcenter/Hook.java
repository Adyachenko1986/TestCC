package callcenter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Pages;

import java.io.File;

import static com.codeborne.selenide.Selenide.close;


public class Hook {
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

    @Before
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
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        Configuration.browser = "chrome";
        page = new Pages();
    }

    @After
    public static void afterTests() {
//        close();
        driver.quit();
    }
}