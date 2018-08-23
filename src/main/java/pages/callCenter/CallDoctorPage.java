package pages.callCenter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class CallDoctorPage extends AbstractPage {
    public CallDoctorPage() {
    }

    public void calldoctor() throws InterruptedException {

        Thread.sleep(2000);
        $(By.xpath("//div[@class='fast-buttons']//button[text()='Вызов врача']")).click();
        Thread.sleep(2000);
        $(By.id("search-patient")).click();
        Thread.sleep(2000);
        $(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        $(By.name("snPol")).sendKeys("38-09 560219");
        $(By.name("birthday")).sendKeys("30111975");
        $(By.xpath("//button[@id='search-patient']")).click();
        //Thread.sleep(2000);
        $(By.name("address")).sendKeys("адрес");
        Thread.sleep(2000);
        $(By.name("porch")).sendKeys("38");
        $(By.name("floor")).sendKeys("9");
        $(By.name("intercomCode")).sendKeys("98");
        $(By.name("phone")).sendKeys("1234567890");
        $(By.name("complaint")).sendKeys("все болит, ничего не помогает");
        $(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        $(By.xpath("//div[@id='patientLpuList']/button")).click();
        $(By.xpath("//*[@id='select2-searchByCities-container']")).click();
        $(By.xpath("//input[@class='select2-search__field']")).sendKeys("Красногорский");
        $(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.RETURN);
        //Thread.sleep(2000);
        $(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        $(By.xpath("//button[@id='call-doctor-button']")).click();
        Thread.sleep(2000);
        $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();
        Thread.sleep(2000);
        $(By.xpath("//tbody[@id='call-doc-list']//button[@class='btn btn-danger']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
