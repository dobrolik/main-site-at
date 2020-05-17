package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.page.BasePageObject;
import ru.geekbrains.main.site.at.page.content.SearchPage;

import static org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace;

public class HeaderBlock extends BasePageObject {
    //////////////////////общие поля
    @FindBy(css = "[class='gb-header__title']")
    protected WebElement headerTitlePage;

    @FindBy(css = "[id='top-menu'] [class='show-search-form'] svg")
    protected WebElement buttonSearch;

    @FindBy(css = "input[class='search-panel__search-field']")
    protected WebElement inputSearch;
    //////////////////////

    //////////////////////Поля только для НЕ авторизованного
    @FindBy(css = "[href='/login']")
    private WebElement singIn;

    @FindBy(css = "href='/register'")
    private WebElement registration;
    //////////////////////

    //////////////////////Поля только для авторизованного
    @FindBy(css = "header [class='schedule-opener js-schedule-opener']")
    private WebElement buttonCalendar;

    @FindBy(css = "[class='js-notices-link']")
    private WebElement buttonNotify;

    @FindBy(css = "header [href='/thanks']")
    private WebElement buttonLike;

    @FindBy(css = "[id='menu-messages']")
    private WebElement buttonMessages;

    @FindBy(css = "[class='gb-top-menu__item dropdown']")
    private WebElement buttonAvatar;
    //////////////////////

    public HeaderBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("проверка что имя страницы: {exampleNamePage}")
    public HeaderBlock checkNamePage(String exampleNamePage) {
        wait30second.until(ExpectedConditions.textToBePresentInElement(headerTitlePage, exampleNamePage));

        String headerPageText = headerTitlePage.getText();
        MatcherAssert.assertThat(headerPageText, equalToCompressingWhiteSpace(exampleNamePage));
        return this;
    }

    @Step("поиск на сайте по тексту: {exampleNamePage}")
    public SearchPage searchText(String text) {
        buttonSearch.click();
        inputSearch.sendKeys(text);
        return new SearchPage(driver);
    }

}