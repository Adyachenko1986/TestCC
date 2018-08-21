package pages.callDoctor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class CallDoctorPage extends BasePage {
    public CallDoctorPage(WebDriver driver) { super(driver); }
    public void calldoctor() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='fast-buttons']//button[text()='Вызов врача']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("search-patient")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        //driver.findElement(By.name("snPol")).sendKeys("38-09 560219");
        //driver.findElement(By.name("birthday")).sendKeys("30111975");
        //driver.findElement(By.xpath("//button[@id='search-patient']")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.name("address")).sendKeys("адрес");
        Thread.sleep(2000);
        driver.findElement(By.name("porch")).sendKeys("38");
        driver.findElement(By.name("floor")).sendKeys("9");
        driver.findElement(By.name("intercomCode")).sendKeys("98");
        //driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("complaint")).sendKeys("все болит, ничего не помогает");
        driver.findElement(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        //driver.findElement(By.xpath("//div[@id='patientLpuList']/button")).click();
        //driver.findElement(By.xpath("//*[@id='select2-searchByCities-container']")).click();
        //driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Красногорский");
        //driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.RETURN);
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='call-doctor-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@id='call-doc-list']//button[@class='btn btn-danger']"))).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
