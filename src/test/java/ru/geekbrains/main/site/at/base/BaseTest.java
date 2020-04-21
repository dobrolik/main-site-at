package ru.geekbrains.main.site.at.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("disable-popup-blocking"));
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://geekbrains.ru/career");

    }

    @AfterEach

     void tearDown() {
        WebElement footerPageCourses = driver.findElement(By.cssSelector("a[class*=\"site-footer__phone\"]"));
        Assertions.assertEquals("8 800 700-68-41", footerPageCourses.getText());

        driver.quit();
    }
}