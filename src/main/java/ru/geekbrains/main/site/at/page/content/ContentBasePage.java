package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.block.HeaderBlock;
import ru.geekbrains.main.site.at.block.LeftNavigation;
import ru.geekbrains.main.site.at.page.BasePageObject;

public abstract class ContentBasePage extends BasePageObject {

    protected LeftNavigation leftNavigation;
    protected HeaderBlock headerBlock;

    @FindBy(css = "div button svg[class='svg-icon icon-popup-close-button ']")
    private WebElement buttonPopUpClosed;

    public ContentBasePage(WebDriver driver) {
        super(driver);
        this.headerBlock = new HeaderBlock(driver);
        this.leftNavigation = new LeftNavigation(driver);
        PageFactory.initElements(driver, this);
    }

    public ContentBasePage closedPopUp() {
        wait10second.until(ExpectedConditions.visibilityOf(buttonPopUpClosed));
        if (buttonPopUpClosed.isDisplayed()) {
            this.buttonPopUpClosed.click();
        }
        return this;
    }

    public LeftNavigation getLeftNavigation() {
        return leftNavigation;
    }

    public HeaderBlock getHeader() {
        return headerBlock;
    }

    /**
     * Адаптер над объектом HeaderBlock
     * После работы с методом HeaderBlock#checkNamePage(String) сайт остается на тойже странице
     */
    public ContentBasePage checkNamePage(String exampleNamePage) {
        headerBlock.checkNamePage(exampleNamePage);
        return this;
    }

}