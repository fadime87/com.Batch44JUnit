package uygulamalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class odev_07 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void liste(){
        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");
        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        WebElement yeniHesap= driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        yeniHesap.click();
        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement birthDay= driver.findElement(By.xpath("//select[@id='day']"));
        Select birthdaySelect = new Select(birthDay);
        List<WebElement> birthdayList = birthdaySelect.getOptions();

        for (WebElement each:birthdayList) {
            System.out.print(each.getText()+" ");
        }
        System.out.println();


        // 4) DOGUM aylari BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement birthmonth= driver.findElement(By.xpath("//select[@id='month']"));
        Select  monthSelect= new Select(birthmonth);
        List<WebElement> monthList=monthSelect.getOptions();
        for (WebElement each:monthList) {
            System.out.println((each.getText() + " "));
        }
        System.out.println();


        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

        WebElement birtDate= driver.findElement(By.xpath(("//select[@id='year']")));
        Select dateSelect=new Select(birtDate);
        List<WebElement> dateList=dateSelect.getOptions();
        for (WebElement each:dateList) {
            System.out.println(each.getText()+" ");
        }
        System.out.println();

    }

}
