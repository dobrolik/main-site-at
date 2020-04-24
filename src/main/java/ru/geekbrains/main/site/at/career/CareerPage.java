package ru.geekbrains.main.site.at.career;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.common.PageObject;
import ru.geekbrains.main.site.at.pages.Header;

public class CareerPage extends PageObject {
    private Header header;
    private Footer footer;
    private Sidebar sidebar;

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClose;

    public CareerPage(WebDriver driver) {
        super(driver);
        footer = new Footer(driver);
        header = new Header(driver);
    }

    public CareerPage popUpClose(){
        if (elementDisplayed(buttonPopUpClose)) buttonPopUpClose.click();
        return this;
    }

}
