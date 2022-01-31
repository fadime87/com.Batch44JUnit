package uygulamalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev_06 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @Test
    public void test1() {
        //● Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        WebElement sayfadakiText = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        Assert.assertTrue(sayfadakiText.isDisplayed());

        //● Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle, expectedTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        String actualNewTitle = driver.getTitle();
        String expectedNewTitle = "New Window";
        Assert.assertEquals(actualNewTitle, expectedNewTitle);

        //● Sayfadaki textin "New Window" olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        String expectedText = "New Window";
        Assert.assertEquals(actualText, expectedText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
        driver.navigate().back();
        String actualSayfaBasligi = driver.getTitle();
        String expectedSayfaBasligi = "The Internet";
        Assert.assertEquals(actualSayfaBasligi, expectedSayfaBasligi);

    }
    @After
    public void tearDown(){

        //   driver.close();
    }

}
