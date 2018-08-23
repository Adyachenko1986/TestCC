package pages.callCenter;

import pages.BasePage;
//import pages.callCenter.LoginPage;



public class CallCenterTests extends BasePage {

    public CallCenterTests( ) {

    }

    public void callCentrPage() throws InterruptedException {
//        WebDriverWait wait;
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();


        //авторизация в КЦ
    /*public LoginPage loginPage() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;*/
/*
        //driver.get("http://call.emias.mosreg.ru/call2_dev/to_work/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.findElement(By.id("USER_LOGIN")).click();
        //webDriver.findElement(By.id("USER_LOGIN")).clear();
        driver.findElement(By.name("USER_LOGIN")).sendKeys("ccg");
        driver.findElement(By.id("USER_PASSWORD")).click();
        //webDriver.findElement(By.id("USER_PASSWORD")).clear();
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("ccg123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        //driver.get("http://call.emias.mosreg.ru/call2_dev/to_work/");
*/

        // Поиск пациента
        /*driver.findElement(By.name("snPol")).sendKeys("38-09 560219");
        driver.findElement(By.xpath("//button[@id='search-patient']")).click();
        Thread.sleep(2000);*/

        // Запись на прием
        /*driver.findElement(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='spec-doc-list']/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Ближайшая запись')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'13:00')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Записать на прием')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();
        Thread.sleep(2000);*/

        // Запись в лист ожидания
        /*driver.findElement(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='spec-doc-list']/div[4]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Записать в лист ожидания')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='complain']")).sendKeys("тест ожидания");
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();*/


        //Запись по направлению
        /*driver.findElement(By.xpath("//*[@id='direction-list-tab']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='direction-list']/div/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb123326f407bc-01c7-4e64-ae16-80ae909b1574']/td[6]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")).click();
        driver.findElement(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();


        //Все записи пациента
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='all-patient-records-tab']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Перенести запись']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='week-doc-schedule-table-body']/tr[2]/td[7]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")).click();
        driver.findElement(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Удалить запись']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Удалить запись']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]")).click();
        // webDriver.findElement(By.xpath ("//button[@id='search-patient']")).click();*/


        //Вызов врача
     /*   Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='fast-buttons']//button[text()='Вызов врача']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("snPol")).sendKeys("38-09 560219");
        driver.findElement(By.name("birthday")).sendKeys("30111975");
        driver.findElement(By.xpath("//button[@id='search-patient']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("address")).sendKeys("адрес");
        driver.findElement(By.name("porch")).sendKeys("38");
        driver.findElement(By.name("floor")).sendKeys("9");
        driver.findElement(By.name("intercomCode")).sendKeys("98");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("complaint")).sendKeys("все болит, ничего не помогает");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id='select2-searchByCities-container']")).click();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Красногорский");
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='call-doctor-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();*/

    }
}