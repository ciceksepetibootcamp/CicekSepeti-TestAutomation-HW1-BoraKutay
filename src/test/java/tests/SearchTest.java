package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SearchTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    String searchItem = ConfigReader.get("searchItem");
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", ConfigReader.get("driverPathDIR")+":"+ConfigReader.get("driverPath"));
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.get("https://www.ciceksepeti.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.findElement(By.className("js-subheader-close")).click();
        driver.findElement(By.className("js-policy-close")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* Test senaryosu:
     * -> Kullanıcı "aranacakKelime" girer.    |
     * -> Ara butonuna tıklar.                 |    -> İlgili arama sonuçlarının geldiği görülür.
     *
     * !!!!! Türkçe girdilerde URL'de değişiklik eklendiğinde Türkçe girdiler için de uygun case olacaktır.
     * */
    @Test
    public void search() throws InterruptedException {

        driver.findElement(By.className("js-product-search-input")).sendKeys(searchItem);
        driver.findElement(By.className("js-product-search-button")).click();
        Assert.assertEquals("https://www.ciceksepeti.com/Arama?query="+searchItem.toLowerCase()+"&qt="+searchItem.toLowerCase(),driver.getCurrentUrl());

    }


    /* Test senaryosu:
     * -> Kullanıcı elektronik ürünlere girer.          |
     * -> Çok satanlar sayfasına tıklar.                |
     * -> İlk ürüne tıklar ve ürün detay sayfas açılır. |
     * -> Ürünü favoriye ekler.                         |     -> Giriş yapma sayfasına yönlendirildiği görülür.
     * */
    @Test
    public void addFavWithoutLogin() throws InterruptedException {

        driver.findElement(By.xpath("//li[7]/span")).click();
        driver.findElement(By.xpath("//img[contains(@alt,'Çok Satanlar')]")).click();
        driver.findElement(By.xpath("//a[(@data-sequence ='1')]")).click();
        driver.findElement(By.cssSelector(".favorite__icon")).click();
        Assert.assertTrue(String.valueOf(true),driver.findElement(By.cssSelector(".membership__full")).isDisplayed());

    }
}
