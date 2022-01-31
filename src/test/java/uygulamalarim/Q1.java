package uygulamalarim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();

    }
}
