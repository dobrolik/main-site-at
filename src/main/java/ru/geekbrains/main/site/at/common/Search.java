package ru.geekbrains.main.site.at.common;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;

public class Search extends PageObject {

    public Search(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"professions\"] span")
    private WebElement professionsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"courses\"] span")
    private WebElement coursesCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"webinars\"] span")
    private WebElement webinarsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"blogs\"] span")
    private WebElement blogsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"forums\"] span")
    private WebElement forumsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"tests\"] span")
    private WebElement testsCount;

    @FindBy(css = "[class*=\"search-page-block\"] [class=\"company-item__pic\"] [alt*=\"GeekBrains\"]")
    private WebElement companiesBlockGeekBrains;


    public Search enterTextToSearch(String text) {
        enterText(inputSearch, text);
        return this;
    }

    public Search checkElement(String name, Matcher matcher) {
        Object actual = null;
        switch (name) {
            case "Профессии":{
                actual = getElementTextToInt(professionsCount);
                break;
            }
            case "Курсы": {
                actual = getElementTextToInt(coursesCount);
                break;
            }
            case "Вебинары": {
                actual = getElementTextToInt(webinarsCount);
                break;
            }
            case "Блоги": {
                actual = getElementTextToInt(blogsCount);
                break;
            }
            case "Форум": {
                actual = getElementTextToInt(forumsCount);
                break;
            }
            case "Тесты": {
                actual = getElementTextToInt(testsCount);
                break;
            }
            case "Geekbrains": {
                actual = waitElementDisplayed(companiesBlockGeekBrains);
                break;
            }
            default: {
                throw new NotFoundException("Объекта "+name+" нет в "+getClass().getName());
            }
        }

        assertThat(actual, matcher);
        return this;
    }

}
