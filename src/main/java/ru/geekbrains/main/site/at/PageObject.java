package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    protected WebDriver driver;
    protected WebDriverWait waiter;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 15);
    }
}
