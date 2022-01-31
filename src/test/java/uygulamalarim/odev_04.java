package uygulamalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev_04 {

    //1. Bir class oluşturun: LocatorsIntro
    //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    // a. http://a.testaddressbook.com adresine gidiniz.
    // b. Sign in butonuna basin
    // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
    // i. Username : testtechproed@gmail.com
    // ii.Password : Test1234!
    // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    //3. Sayfada kac tane link oldugunu bulun.
    //4.Linklerin yazisini nasil yazdirabiliriz
    //5. driver i kapatin
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
 @Test
 public void locate() throws InterruptedException {
     driver.get("http://a.testaddressbook.com");
     //Thread.sleep(3000);

     // b. Sign in butonuna basin
       WebElement singIn= driver.findElement(By.xpath("//a [@id='sign-in']"));
       singIn.click();

     // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
     WebElement email= driver.findElement(By.xpath("//input[@type='email']"));
     WebElement password= driver.findElement(By.xpath("//input[@name='session[password]']"));
     WebElement singInbutonu= driver.findElement(By.xpath("//a [@id='sign-in']"));

     // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
     // i. Username : testtechproed@gmail.com
     // ii.Password : Test1234!
   email.sendKeys("testtechproed@gmail.com");
   password.sendKeys("Test1234!");
   Thread.sleep(3000);
   singInbutonu.click();

     // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).

     String Actualluserid=driver.getTitle();
     String Expecteduserid="testtechproed@gmail.com";
     Assert.assertTrue(Expecteduserid.contains(Actualluserid));

     // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
     //WebElement addresses=driver.findElement(By.xpath(""));

     //3. Sayfada kac tane link oldugunu bulun.
     //4.Linklerin yazisini nasil yazdirabiliriz




 }











    @AfterClass
    public static void teardown() {
       // driver.close();
    }
}