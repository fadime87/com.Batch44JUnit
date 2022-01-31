package uygulamalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckBoxTekrar {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

     @Test
public  void test() throws InterruptedException {

         //a. Verilen web sayfasına gidin.
         //https://theinternet.herokuapp.com/checkboxes
         driver.get("https://the-internet.herokuapp.com/checkboxes");
         //b. Checkbox1 ve checkbox2 elementlerini locate edin.
         WebElement Checkbox1= driver.findElement(By.xpath("(//input[@type='checkBox'])[1]"));
         WebElement Checkbox2= driver.findElement(By.xpath("(//input[@type='checkBox'])[2]"));

         //c. Checkbox1 seçili değilse onay kutusunu tıklayın
         Thread.sleep(5000);
         if(!Checkbox1.isSelected()){
             Checkbox1.click();
         }else{
             Checkbox2.click();
         }
         //d. Checkbox2 seçili değilse onay kutusunu tıklay

     }


     @After
    public void tearDown(){

        driver.close();
     }
}