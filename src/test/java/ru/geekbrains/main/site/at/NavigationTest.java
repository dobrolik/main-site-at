package ru.geekbrains.main.site.at;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.geekbrains.main.site.at.base.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class NavigationTest extends BaseTest {
    //    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы
//    Вебинары
//    Форум
//    Блог
//    Тесты
//    Карьера

    @ParameterizedTest
    @ValueSource(strings = "Курсы")
    void checkCourses(String expected) throws InterruptedException{

        WebElement buttonCourses = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]"));
        buttonCourses.click();

        driver.findElement(By.cssSelector("div button svg[class=\"svg-icon icon-popup-close-button \"]")).click();

        WebElement headerPageCourses = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        assertThat(headerPageCourses.getText(), equalToCompressingWhiteSpace(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = "Вебинары")
    void checkEvents(String expected) throws InterruptedException {

        WebElement buttonEvents = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/events\"]"));
        buttonEvents.click();

        WebElement headerPageEvents = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        assertThat(headerPageEvents.getText(), equalToCompressingWhiteSpace(expected));

    }

    @ParameterizedTest
    @ValueSource(strings = "Форум")
    void checkTopics(String expected) throws InterruptedException {

        WebElement buttonTopics = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/topics\"]"));
        buttonTopics.click();

        WebElement headerPageTopics = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        assertThat(headerPageTopics.getText(), equalToCompressingWhiteSpace(expected));

    }

    @ParameterizedTest
    @ValueSource(strings = "Блог")
    void checkPosts(String expected) throws InterruptedException {

        WebElement buttonPosts = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/posts\"]"));
        buttonPosts.click();

        WebElement headerPagePosts = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        assertThat(headerPagePosts.getText(), equalToCompressingWhiteSpace(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = "Тесты")
    void checkTests(String expected) throws InterruptedException {

        WebElement buttonTests = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/tests\"]"));
        buttonTests.click();

        WebElement headerPageTests = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        assertThat(headerPageTests.getText(), equalToCompressingWhiteSpace(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = "Карьера")
    void checkCareer(String expected) throws InterruptedException {

        WebElement buttonCareer = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/career\"]"));
        buttonCareer.click();

        WebElement headerPageCareer = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        assertThat(headerPageCareer.getText(), equalToCompressingWhiteSpace(expected));
    }
}