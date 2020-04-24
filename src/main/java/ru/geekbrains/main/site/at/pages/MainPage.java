package ru.geekbrains.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.common.PageObject;

public class MainPage extends PageObject {
    private Header header;
    private Sidebar sidebar;

    public MainPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        sidebar = new Sidebar(driver);
    }

    public Header getHeader() {
        return header;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }
}
