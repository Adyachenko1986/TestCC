package pages.callCenter;

import com.codeborne.selenide.Condition;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends AbstractPage implements SElements {

//    String url = "http://local.call/cc_dev/to_work/";



    public LoginPage() {
    }

    public void login() {
        System.out.println("компилятр дошел до сюдова!");
        open("http://call.emias.mosreg.ru/");

//        if ($("h2").getText() == "Пожалуйста, авторизуйтесь:")
//        {
        log.val("ccg");
        pass.val("ccg1234");
        loginButton.click();
        open(url);
//        }
//        else {
//            System.out.println("Уже залогинен");
//        }
//        log.val("ccg");
//        pass.val("ccg123");
//        loginButton.click();
    }
}
