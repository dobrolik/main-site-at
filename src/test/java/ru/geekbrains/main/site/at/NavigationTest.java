package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.geekbrains.main.site.at.base.BaseTest;

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


     //Курсы
    @Test
    void CheckCourses() throws InterruptedException {
        driver.get("https://geekbrains.ru/career");

        WebElement buttonCourses = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]"));
        buttonCourses.click();

        driver.findElement(By.cssSelector("div button svg[class=\"svg-icon icon-popup-close-button \"]")).click();

        WebElement headerPageCourses = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Курсы", headerPageCourses.getText());

        WebElement footerPageCourses = driver.findElement(By.cssSelector("a[class*=\"site-footer__phone\"]"));
        Assertions.assertEquals("8 800 700-68-41", footerPageCourses.getText());
    }

    //Вебинары
    //Здесь непонятно, как отследить появление всплывающего окна, закономерность уловить не удалось.
    //Два типа всплывающих окон:
    // 1) Окно с разрешением отправлять уведомления и что-то о подписке. Отследил, добавил в код под коментом.
    // 2) Приглашение к бесплатной регистрации

    @Test
    void CheckEvents() throws InterruptedException {
        driver.get("https://geekbrains.ru/career");

        WebElement buttonEvents = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/events\"]"));
        buttonEvents.click();

        WebElement headerPageEvents = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Вебинары", headerPageEvents.getText());

 //       driver.findElement(By.cssSelector("button[class=close]")).click();
 //       driver.findElement(By.cssSelector("button[class=_2c86]")).click();
 //       driver.findElement(By.cssSelector("[class*=\"popup-close-button\"]")).click();

        WebElement headerPageEventsActions = driver.findElement(By.cssSelector("a[href =\"/register\"]"));
        Assertions.assertEquals(" Регистрация", headerPageEventsActions.getText());

        WebElement footerPageCourses = driver.findElement(By.cssSelector("a[class*=\"site-footer__phone\"]"));
        Assertions.assertEquals("8 800 700-68-41", footerPageCourses.getText());
    }

    //Форум
    @Test
    void CheckTopics() {
        driver.get("https://geekbrains.ru/career");
        WebElement buttonTopics = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/topics\"]"));
        buttonTopics.click();
        WebElement headerPageTopics = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Форум", headerPageTopics.getText());
        WebElement footerPageCourses = driver.findElement(By.cssSelector("a[class*=\"site-footer__phone\"]"));
        Assertions.assertEquals("8 800 700-68-41", footerPageCourses.getText());
    }

    //Блог
    @Test
    void CheckPosts() {
        driver.get("https://geekbrains.ru/career");
        WebElement buttonPosts = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/posts\"]"));
        buttonPosts.click();
        WebElement headerPagePosts = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Блог", headerPagePosts.getText());
        WebElement footerPageCourses = driver.findElement(By.cssSelector("a[class*=\"site-footer__phone\"]"));
        Assertions.assertEquals("8 800 700-68-41", footerPageCourses.getText());
    }

    //Тесты
    @Test
    void CheckTests() {
        driver.get("https://geekbrains.ru/career");
        WebElement buttonTests = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/tests\"]"));
        buttonTests.click();
        WebElement headerPageTests = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Тесты", headerPageTests.getText());
        WebElement footerPageCourses = driver.findElement(By.cssSelector("a[class*=\"site-footer__phone\"]"));
        Assertions.assertEquals("8 800 700-68-41", footerPageCourses.getText());
    }
    //Карьера
    @Test
    void CheckCareer() {
        driver.get("https://geekbrains.ru/career");
        WebElement buttonCareer = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/career\"]"));
        buttonCareer.click();
        WebElement headerPageCareer = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Карьера", headerPageCareer.getText());
        WebElement footerPageCourses = driver.findElement(By.cssSelector("a[class*=\"site-footer__phone\"]"));
        Assertions.assertEquals("8 800 700-68-41", footerPageCourses.getText());
    }
}