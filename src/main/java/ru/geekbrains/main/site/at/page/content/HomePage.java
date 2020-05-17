package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.page.OpenUrl;

public class HomePage extends ContentBasePage implements OpenUrl {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HomePage openUrl() {
        driver.get("https://geekbrains.ru/");
        return this;
    }
}