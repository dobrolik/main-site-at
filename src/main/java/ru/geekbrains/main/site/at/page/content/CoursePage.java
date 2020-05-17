package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.block.ContentNavigationCourseBlock;
import ru.geekbrains.main.site.at.page.OpenUrl;

import java.util.List;

public class CoursePage extends ContentBasePage implements OpenUrl {

    private ContentNavigationCourseBlock contentNavigationCourseBlock;

    @FindBy(xpath = "//form/ul//label")
    private List<WebElement> filterList;

    @FindBy(xpath = "//a/div/div/span")
    private List<WebElement> courseList;

    public CoursePage(WebDriver driver) {
        super(driver);
        this.contentNavigationCourseBlock = new ContentNavigationCourseBlock(driver);
    }

    public CoursePage configFilter(String... args) {
        for (String test : args) {
            WebElement element = findElement(filterList, test);
            element.click();
        }
        return this;
    }

    public CoursePage checkingDisplayedCourses(String... args) {
        for (String test : args) {
            WebElement element = findElement(courseList, test);
            wait10second.until(ExpectedConditions.visibilityOf(element));
        }
        return this;
    }

    public ContentNavigationCourseBlock getContentNavigationCourseBlock() {
        return contentNavigationCourseBlock;
    }

    @Override
    public CoursePage openUrl() {
        driver.get("https://geekbrains.ru/courses");
        return this;
    }
}
