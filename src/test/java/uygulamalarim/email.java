package uygulamalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class email {
    WebDriver driver;
    @Before
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test(){
        driver.get("http://automationpractice.com/index.php");
    }




    @After
    public  void  tearDown() {

      //  driver.close();
    }
}
