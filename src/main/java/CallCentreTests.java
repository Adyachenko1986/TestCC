import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
        webDriver.findElement(By.name("snPol")).sendKeys("38-09 560219");
        webDriver.findElement(By.xpath ("//button[@id='search-patient']")).click();
        Thread.sleep(2000);


        webDriver.findElement(By.xpath ("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[contains(text(),'Терапия')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[contains(text(),'Ближайшая запись')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath ("//*[contains(text(),'13:00')]")).click();
        webDriver.findElement(By.xpath ("//*[contains(text(),'Записать на прием')]")).click();
        webDriver.findElement(By.xpath ("//*[contains(text(),'')]")).click();


        webDriver.quit();

  }
}