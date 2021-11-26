package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utils.ConfigReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserOperationsTest {


    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    String mail = ConfigReader.get("email");
    String password = ConfigReader.get("password");

    String testName = ConfigReader.get("signUpName");
    String testMail = ConfigReader.get("signUpMail");
    String testPassword = ConfigReader.get("signUpPassword");

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", ConfigReader.get("driverPathDIR")+":"+ConfigReader.get("driverPath"));
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.get("https://www.ciceksepeti.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.manage().window().maximize();
        driver.findElement(By.className("js-subheader-close")).click();
        driver.findElement(By.className("js-policy-close")).click();
    }
    @After
    public void tearDown() {
        driver.quit();
    }


    /* Test senaryosu:
     * -> Kullanıcı üye girişi butonuna tıklar.    |
     * -> E-posta ve parolayı girer.               |
     * -> Giriş butonuna tıklar.                   |      -> Hesaba giriş yaptığı görülür.
     * */
    @Test
    public void loginTest() throws InterruptedException {

        driver.findElement(By.cssSelector(".user-menu__item:nth-child(2)")).click();
        driver.findElement(By.className("users-process-list__btn")).click();
        driver.findElement(By.id("EmailLogin")).sendKeys(mail);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.className("js-login-button")).click();
        Assert.assertTrue(String.valueOf(true),driver.findElement(By.xpath("(//a[@href='/hesabim/siparislerim'])[2]")).isDisplayed());

    }



    /* Test senaryosu:
     * -> Kullanıcı üye ol butonuna tıklar.                 |
     * -> Ad soyad,e-posta ve parolayı girer.               |
     * -> Üyelik sözleşmesi ve KVKK metni onaylanır.        |
     * -> Üye ol butonuna tıklar                            |      -> Başarılı bir şekilde kayıt olduğu görülür.
     * */
    @Test
    public void signUpTest() throws InterruptedException {

        driver.findElement(By.cssSelector(".user-menu__item:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".users-process-list__item:nth-child(2)")).click();
        driver.findElement(By.id("NameIndivual")).sendKeys(testName);
        driver.findElement(By.id("EmailIndivual")).sendKeys(testMail);
        driver.findElement(By.id("PasswordIndivual")).sendKeys(testPassword);
        driver.findElement(By.cssSelector(".customer-contracts-text")).click();
        driver.findElement(By.cssSelector(".js-customer-contract-accept-button")).click();
        driver.findElement(By.className("js-individual-register-button")).click();
        Assert.assertTrue(String.valueOf(true),driver.findElement(By.cssSelector(".membership-thanks__heading")).isDisplayed());

    }

}
