package ru.geekbrains.main.site.at.courses;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.common.PageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CoursesPage extends PageObject {
    private Header header;

    public Header getHeader() {
        return header;
    }

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href=\"#cour-new\"]")
    private WebElement buttonNavCourses;

    @FindBy(css = "input[id=\"filter-0\"]")
    private WebElement checkBoxFilterFree;

    @FindBy(css = "input[id=\"filter-9\"]")
    private WebElement checkBoxFilterQA;

    @FindBy(css = "div[id=\"cour-new\"]")
    private WebElement divCourses;

    public CoursesPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    public CoursesPage clickNavCourses() {
        buttonClick(buttonNavCourses);
        return this;
    }

    public CoursesPage clickCheckbox(String name){
        WebElement checkBox = null;
        switch (name){
            case "Бесплатные": {
                checkBox = checkBoxFilterFree;
                break;
            }
            case "Тестирование": {
                checkBox = checkBoxFilterQA;
                break;
            }
            default: {
                throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
            }
        }
        checkBoxClick(checkBox);
        return this;
    }

    public CoursesPage checkCoursesForText(String text){
        String xpath = String.format("//span[@class=\"gb-course-card__title-text\"][contains(.,\"%s\")]", text);
        boolean actual;
        try {
            actual = elementDisplayed(divCourses.findElement(By.xpath(xpath)));
        } catch (NoSuchElementException e) {
            actual = false;
            e.printStackTrace();
        }
        assertThat(actual,is(true));
        return this;
    }
}