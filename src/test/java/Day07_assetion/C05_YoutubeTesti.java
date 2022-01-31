package Day07_assetion;
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

public class C05_YoutubeTesti {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

  static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTesting() {

        // ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin

        String ActuallTitle=driver.getTitle();
        String ExpectedTitle="YouTube";
        Assert.assertTrue(ExpectedTitle.contains(ActuallTitle));



    }

    @Test
    public void imageTesting() {
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement LogoResmi = driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-logo'][1]"));
        Assert.assertTrue("resim goruntuleniyor", LogoResmi.isDisplayed());



    }

    @Test
    public void searchBoxTesting() {
        //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement SerchBox = driver.findElement(By.xpath("//input[@ id='search']"));
        Assert.assertTrue(SerchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String ActuallTitle=driver.getTitle();
        String ExpectedTitle="youtube";
        Assert.assertFalse(ExpectedTitle.contains(ActuallTitle));

    }

    @AfterClass
    public  static void tearDown() {
           driver.close();
    }
}