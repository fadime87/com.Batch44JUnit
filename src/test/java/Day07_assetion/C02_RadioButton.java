package Day07_assetion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButton {

   //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //https://www.facebook.com adresine gidin
    //Cookies’i kabul edin
    //“Create an Account” button’una basin
    //“radio buttons” elementlerini locate edin
    //Secili degilse cinsiyet butonundan size uygun olani secin
   WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //Cookies’i kabul edin
       // driver.findElement(By.xpath("//button[text()='Allow All Cookies']")).click();
        //“Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //“radio buttons” elementlerini locate edin
        //Secili degilse cinsiyet butonundan size uygun olani secin
        driver.findElement(By.xpath("//input[@value='2']")).click();
    }
    @After
    public void teardown(){

        driver.close();
    }
}
