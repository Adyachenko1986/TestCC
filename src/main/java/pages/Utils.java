package pages;

import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class Utils {
    public void randomCard() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append(String.valueOf(random.nextInt(10)));
        }
//        $(By.xpath("//*[@name='medCardNum']/")).val(result);
        $(By.name("medCardNum")).val(result.toString());
    }
    public void randomDirection() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append(String.valueOf(random.nextInt(10)));
        }
//        $(By.xpath("//*[@name='medCardNum']/")).val(result);
        $(By.name("numberDirection")).val(result.toString());
    }
}
