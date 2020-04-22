package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class Page {

    public Page(WebDriver driver) {
        this.navigation = PageFactory.initElements(driver, Navigation.class);
    }

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerPageTitle;
    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonClosePopUP;

    private Navigation navigation;

    public Page checkHeaderTitle(String expectedHeaderTitle) {
        String actualHeaderTitle = headerPageTitle.getText();
        assertThat(actualHeaderTitle, equalToCompressingWhiteSpace(expectedHeaderTitle));

        return this;
    }

    public Page ClosedPopUP() {
        buttonClosePopUP.click();
        return this;
    }

    public Navigation getNavigation() {
        return navigation;
    }
}
