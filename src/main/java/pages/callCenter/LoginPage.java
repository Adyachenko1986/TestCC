package pages.callCenter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends AbstractPage {

    SelenideElement log = $(By.id("USER_LOGIN"));
    SelenideElement pass = $(By.id("USER_PASSWORD"));
    SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));

    public LoginPage() {
    }

    public void login() {
        System.out.println("компилятр дошел до сюдого!");
        open("http://call.emias.mosreg.ru/cc_dev/to_work/");
        log.val("ccg");
        pass.val("ccg123");
        loginButton.click();
    }
}
