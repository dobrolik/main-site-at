package ru.geekbrains.main.site.at;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation {
    private WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    private WebElement buttonEvents;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    private WebElement buttonTopics;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    private WebElement buttonPosts;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    private WebElement buttonCareer;

    //    public WebElement getButtonCourses() {
//        return buttonCourses;
//    }
//    public WebElement getButtonEvents() {
//        return buttonEvents;
//    }
//    public WebElement getButtonTopics() {
//        return buttonTopics;
//    }
//    public WebElement getButtonPosts() {
//        return buttonPosts;
//    }
//    public WebElement getButtonTests() {
//        return buttonTests;
//    }
//    public WebElement getButtonCareer() {
//        return buttonCareer;
//    }
    public Page clickButton(String nameButton) {
        switch (nameButton) {
            case "Курсы": {
                buttonCourses.click();
                break;
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
                break;
            }
            case "Карьера": {
                buttonCareer.click();
                break;
            }

            default: {
                throw new NotFoundException("Элемент " + nameButton + " не используется в методе clickButton");
            }
        }

        return PageFactory.initElements(driver, Page.class);
    }
}
