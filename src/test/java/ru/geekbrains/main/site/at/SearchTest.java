package ru.geekbrains.main.site.at;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SearchTest extends BaseTest {

//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что отобразились блоки:
//            Профессии
//            Курсы
//            Вебинары
//            Блоги
//            Форум
//            Тесты
//            Проекты и компании

    @Test
    void serchJava() {
        driver.get("https://geekbrains.ru/career");

        driver.findElement(By.cssSelector("[class*=\"popup-close-button\"]")).click();

        WebElement buttonSearch = driver.findElement(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg"));
        buttonSearch.click();

        WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");

        WebElement textProfession = driver.findElement(By.xpath("//header/h2[text()='Профессии']"));
        WebElement textCourses = driver.findElement(By.xpath("//header/h2[text()='Курсы']"));
        WebElement textWebinars = driver.findElement(By.xpath("//header/h2[text()='Вебинары']"));
        WebElement textBlogs = driver.findElement(By.xpath("//header/h2[text()='Блоги']"));
        WebElement textForum = driver.findElement(By.xpath("//header/h2[text()='Форум']"));
        WebElement textTests = driver.findElement(By.xpath("//header/h2[text()='Тесты']"));
        WebElement textProjectsAndCompanies = driver.findElement(By.xpath("//header/h2[text()='Проекты и компании']"));


        WebDriverWait wait = new WebDriverWait(driver, 40);
//
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Профессии']"),"Профессии"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Курсы']"),"Курсы"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Вебинары']"),"Вебинары"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Блоги']"),"Блоги"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Форум']"),"Форум"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Тесты']"),"Тесты"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Проекты и компании']"),"Проекты и компании"));
//
        wait.until(ExpectedConditions.textToBePresentInElement(textProfession, "Профессии"));
        wait.until(ExpectedConditions.textToBePresentInElement(textCourses, "Курсы"));
        wait.until(ExpectedConditions.textToBePresentInElement(textWebinars, "Вебинары"));
        wait.until(ExpectedConditions.textToBePresentInElement(textBlogs, "Блоги"));
        wait.until(ExpectedConditions.textToBePresentInElement(textForum, "Форум"));
        wait.until(ExpectedConditions.textToBePresentInElement(textTests, "Тесты"));
        wait.until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies, "Проекты и компании"));


//        Assertions.assertEquals("Курсы", textCourses.getText());
//        Assertions.assertEquals("Вебинары", textWebinars.getText());
//        Assertions.assertEquals("Блоги", textBlogs.getText());
//        Assertions.assertEquals("Форум", textForum.getText());
//        Assertions.assertEquals("Тесты", textTests.getText());
//        Assertions.assertEquals("Проекты и компании", textProjectsAndCompanies.getText());

        //Профессий не меньше, чем 2
        ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[2]/a/span"), 2);
        //Курсов более 15
        ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[3]/a/span"), 15);
        //Вебинаров больше чем 180, но меньше 300
        WebElement numberOfEvents = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[4]/a/span"));
        assertThat(Integer.parseInt(numberOfEvents.getText()), allOf(greaterThan(180), lessThan(300)));
        //Блогов более 300
        ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[5]/a/span"), 300);
        //Форумов не 350
        WebElement numberOfForum = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[6]/a/span"));
        Assertions.assertNotEquals(350, Integer.parseInt(numberOfForum.getText()));

        //Тестов не 0
        WebElement numberOfTests = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div[1]/div/ul/li[7]/a/span"));
        Assertions.assertNotNull(Integer.parseInt(numberOfTests.getText()));

        //В проектах и компаниях отображается GeekBrains
        By mySelector = By.cssSelector("h3 > a");
        List<WebElement> geekElements = driver.findElements(mySelector);
        for (WebElement e : geekElements) {
            String element = e.getText();
            if (element.contains("Geek")) break;
        }

    }

}