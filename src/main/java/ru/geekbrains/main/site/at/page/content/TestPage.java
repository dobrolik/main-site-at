package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.page.OpenUrl;

public class TestPage extends ContentBasePage implements OpenUrl {

    public TestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TestPage openUrl() {
        driver.get("https://geekbrains.ru/tests");
        return this;
    }
}
