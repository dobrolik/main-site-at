package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.page.BasePageObject;
import ru.geekbrains.main.site.at.page.content.ContentBasePage;
import ru.geekbrains.main.site.at.page.content.CoursePage;
import ru.geekbrains.main.site.at.page.content.HomePage;
import ru.geekbrains.main.site.at.page.content.TestPage;
import ru.geekbrains.main.site.at.util.PageNotCreateException;

public class LeftNavigation extends BasePageObject {

    @FindBy(css = "[class='svg-icon icon-logo']")
    private WebElement icon;

    @FindBy(css = "[class*='main-page-hidden'] [href='/courses']")
    private WebElement buttonCourses;

    @FindBy(css = "[class*='main-page-hidden'] [href='/events']")
    private WebElement buttonEvents;

    @FindBy(css = "[class*='main-page-hidden'] [href='/topics']")
    private WebElement buttonTopics;

    @FindBy(css = "[class*='main-page-hidden'] [href='/posts']")
    private WebElement buttonPosts;

    @FindBy(css = "[class*='main-page-hidden'] [href='/tests']")
    private WebElement buttonTests;

    @FindBy(css = "[class*='main-page-hidden'] [href='/career']")
    private WebElement buttonCareer;

    public LeftNavigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Нажатие кнопки {nameButton}")
    public ContentBasePage clickButton(String nameButton) {
        switch (nameButton) {
            case "Главная": {
                icon.click();
            }
            case "Курсы": {
                buttonCourses.click();
                return new CoursePage(driver);
            }
            case "Вебинары": {
                buttonEvents.click();
                break;
            }
            case "Форум": {
                buttonTopics.click();
                break;
            }
            case "Блог": {
                buttonPosts.click();
                break;
            }
            case "Тесты": {
                buttonTests.click();
                return new TestPage(driver);
            }
            case "Карьера": {
                buttonCareer.click();
                break;
            }
            default: {
                throw new PageNotCreateException("Не найдена кнопка с именем: " + nameButton);
            }
        }

        return new HomePage(driver);
    }
}
