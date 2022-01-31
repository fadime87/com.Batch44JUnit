package uygulamalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class radioButton {

   WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test(){
        //https://www.facebook.com adresine
        driver.get("https://www.facebook.com");
        //“Create an Account” button’una basin
        driver.findElement(By.xpath( "(//a[@role='button'])[2]")).click();

        //“radio buttons” elementlerini locate edin
        driver.findElement(By.xpath( "//label[@class='_58mt']")).click();


        //Secili degilse cinsiyet butonundan size uygun olani secin
    }

    @After
    public void teardown(){

    }
}
