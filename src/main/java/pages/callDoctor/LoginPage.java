package pages.callDoctor;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    @FindBy(id = "USER_LOGIN")
    SelenideElement log;

    @FindBy(id = "USER_PASSWORD")
    SelenideElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    SelenideElement loginButton;

    public LoginPage() {
    }

    public void login() {
        open("http://call.emias.mosreg.ru/cc_dev/to_work/");
        log.setValue("ccg");
        pass.setValue("ccg123");
        loginButton.click();
    }
}
