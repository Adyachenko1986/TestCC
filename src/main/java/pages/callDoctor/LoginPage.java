package pages.callDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class LoginPage extends BasePage {
    //protected WebDriver driver;
    //protected WebDriverWait wait;

    @FindBy(id = "USER_LOGIN")
    WebElement log;

    @FindBy(id = "USER_PASSWORD")
    WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) { super(driver); }

    public void login() {
        driver.get("http://call.emias.mosreg.ru/call2_dev/to_work/");
        //WebElement explicitWait = (new WebDriverWait(driver, 5))
        //       .until(ExpectedConditions.elementToBeClicable(By.id("USER_LOGIN")));
        enterLoginText("ccg");
        enterPasswordText("ccg123");
        clickloginButton();
        driver.get("http://call.emias.mosreg.ru/call2_dev/to_work/");
    }

    public void enterLoginText(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(log));
        log.clear();
        log.sendKeys(text);
    }

    public void enterPasswordText(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(pass));
        pass.clear();
        pass.sendKeys(text);
    }

    public void clickloginButton() {
        loginButton.click();
    }
}
