package pages.callCenter;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends AbstractPage implements SElements {

//    String url = "http://local.call/cc_dev/to_work/";



    public LoginPage() {
    }

    public void login() {
        open("http://call.emias.mosreg.ru/");
        log.val("ccg");
        pass.val("ccg123");
        loginButton.click();
        open(url);
    }


}
