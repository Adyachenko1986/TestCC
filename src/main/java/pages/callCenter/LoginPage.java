package pages.callCenter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends AbstractPage implements SElements {

    String url = "http://local.call/cc_dev/to_work/";



    public LoginPage() {
    }

    public void login() {
        System.out.println("компилятр дошел до сюдого!");
        open(url);
        log.val("ccg");
        pass.val("ccg123");
        loginButton.click();
    }
}
