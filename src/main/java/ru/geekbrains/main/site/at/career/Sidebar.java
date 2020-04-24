package ru.geekbrains.main.site.at.career;

import org.openqa.selenium.WebDriver;

public class Sidebar extends ru.geekbrains.main.site.at.common.Sidebar<CareerPage> {
    protected Sidebar(WebDriver driver) {
        super(driver, CareerPage.class);
    }
}
