package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

abstract public class AbstractPage {
    public WebDriver driver;
    public static String perek = "тест";

    public static String url;
    static String snpol;
    static String fam;
    static String bd;
    static SelenideElement lpu;
    static SelenideElement mcod;
    static SelenideElement apoinmentsList;
    static SelenideElement apoLpu;
    public AbstractPage() {
        this.driver = getWebDriver();
    }

     public void setUp(String base) {
        switch (base) {
            case "тест":
                this.url = "http://local.call/cc_dev/to_work/";
                break;
            case "прод":
                this. url = "http://call.emias.mosreg.ru/cc_dev/to_work/";
                break;
        }
    }
}
