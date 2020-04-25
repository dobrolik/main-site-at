package ru.geekbrains.main.site.at.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;


    protected void setUpDriver() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("incognito");
        driver.manage().window().maximize();
        options.addArguments("--disable-popup-blocking");
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("disable-popup-blocking"));
//        options.addArguments("--disable-infobars");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-browser-side-navigation");
//        options.addArguments("--disable-gpu");
//
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    protected void tearDown() {
        driver.quit();
    }

}