import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
//import pages.FindPatient;


public class CallCentreTests {

    public static void main(String[] args) throws Exception    {
      WebDriverWait wait;
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      WebDriver webDriver = new ChromeDriver();

    //авторизация в КЦ
      webDriver.get("http://call.emias.mosreg.ru/cc_dev/to_work/#/");
      System.out.println(webDriver.getCurrentUrl());
      Thread.sleep(2000);
      webDriver.findElement(By.id("USER_LOGIN")).click();
      //webDriver.findElement(By.id("USER_LOGIN")).clear();
      webDriver.findElement(By.name("USER_LOGIN")).sendKeys("ccg");
      webDriver.findElement(By.id("USER_PASSWORD")).click();
      //webDriver.findElement(By.id("USER_PASSWORD")).clear();
      webDriver.findElement(By.name("USER_PASSWORD")).sendKeys("ccg123");
      webDriver.findElement(By.xpath ("//button[@type='submit']")).click();
      Thread.sleep(1000);
      webDriver.get("http://call.emias.mosreg.ru/cc_dev/to_work/");

      // Поиск пациента
        webDriver.findElement(By.name("snPol")).sendKeys("38-09 560219");
        webDriver.findElement(By.xpath ("//button[@id='search-patient']")).click();
        Thread.sleep(2000);

      // Запись на прием
        webDriver.findElement(By.xpath ("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[contains(text(),'Терапия')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[contains(text(),'Ближайшая запись')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[contains(text(),'13:00')]")).click();
        webDriver.findElement(By.xpath ("//*[contains(text(),'Записать на прием')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();

       //Все записи пациента
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='all-patient-records-tab']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//button[@title='Перенести запись']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb12330b58bf2f-b6ff-423e-bff8-018953417c50']/td[7]/button")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")).click();
        webDriver.findElement(By.xpath ("//*[@id='record-to-doc-form']/div/div[2]/button")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//button[@title='Удалить запись']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='ccInfoModal']/div/div/div[3]/button[2]")).click();

        //Запись по направлению
        Thread.sleep(5000);
        webDriver.findElement(By.xpath ("//*[@id='direction-list-tab']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='direction-list']/div/div[2]/button")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb123326f407bc-01c7-4e64-ae16-80ae909b1574']/td[6]/button")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")).click();
        webDriver.findElement(By.xpath ("//*[@id='record-to-doc-form']/div/div[2]/button")).click();

        //Вызов врача
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//div[@class='fast-buttons']//button[text()='Вызов врача']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.name("snPol")).sendKeys("38-09 560219");
        webDriver.findElement(By.name("birthday")).sendKeys("30111975");
        webDriver.findElement(By.xpath ("//button[@id='search-patient']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.name("address")).sendKeys("адрес");
        webDriver.findElement(By.name("porch")).sendKeys("38");
        webDriver.findElement(By.name("floor")).sendKeys("9");
        webDriver.findElement(By.name("intercomCode")).sendKeys("98");
        webDriver.findElement(By.name("phone")).sendKeys("1234567890");
        webDriver.findElement(By.name("complaint")).sendKeys("все болит, ничего не помогает");
        webDriver.findElement(By.name("phone")).sendKeys("1234567890");
        webDriver.findElement(By.name("phone")).sendKeys("1234567890");
        webDriver.findElement(By.xpath ("//*[@id='select2-searchByCities-container']")).click();
        webDriver.findElement(By.xpath ("//input[@class='select2-search__field']")).sendKeys("Красногорский");
        webDriver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//button[@id='call-doctor-button']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();



        webDriver.quit();

  }
}