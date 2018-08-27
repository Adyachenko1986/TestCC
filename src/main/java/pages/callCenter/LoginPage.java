package pages.callCenter;

import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends AbstractPage implements SElements {

//    String url = "http://local.call/cc_dev/to_work/";


    public LoginPage() {
    }

    public void login() {
        System.out.println("компилятр дошел до сюдова!");
        setUp(perek);
        open(url);
        log.val("ccg");
        pass.val("ccg123");
        loginButton.click();
    }
}
