import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Pages;
import pages.utilities.JSWaiter;
import pages.utilities.Waiter;

import java.io.File;

abstract public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    Pages page;

    @BeforeSuite
    public void beforeSuite() {

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(service, options);

        JSWaiter.setDriver(driver);
        Waiter.setDriver(driver);
        wait = new WebDriverWait(driver, 20);
        page = new Pages(driver);
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
