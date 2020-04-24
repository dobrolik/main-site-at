package ru.geekbrains.main.site.at.career;

import org.openqa.selenium.WebDriver;

public class Footer extends ru.geekbrains.main.site.at.common.Footer<CareerPage> {
    public Footer(WebDriver driver) {
        super(driver, CareerPage.class);
    }
}
