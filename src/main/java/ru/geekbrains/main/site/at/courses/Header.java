package ru.geekbrains.main.site.at.courses;

import org.openqa.selenium.WebDriver;

public class Header extends ru.geekbrains.main.site.at.common.Header<CoursesPage> {
    public Header(WebDriver driver) {
        super(driver, CoursesPage.class);
    }
}