package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.courses.CoursesPage;
import ru.geekbrains.main.site.at.pages.AuthPage;

import java.util.stream.Stream;

@DisplayName("Проверка фильтров")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FiltersTest extends BaseTest {
    private CoursesPage coursesPage;

    @BeforeAll
    protected void SetUp(){
        super.setUpDriver();
        driver.get("https://geekbrains.ru/login");
        coursesPage = PageFactory.initElements(driver, AuthPage.class)
                .loginAsCustomer("hao17583@bcaoo.com", "hao17583")
                .getSidebar().clickCourses()
                .getHeader().checkTitle("Курсы")
                .clickNavCourses()
                .clickCheckbox("Бесплатные")
                .clickCheckbox("Тестирование");
    }

    @DisplayName("Проверка результатов фильтрации")
    @ParameterizedTest(name = "{index} ==> Отобразилось: \"{0}\"")
    @MethodSource("stringProvider")
    void checkMain(String courseName){
        coursesPage.checkCoursesForText(courseName);
    }

    static Stream<String> stringProvider(){
        return Stream.of(
                "Тестирование ПО. Уровень 1",
                "Тестирование ПО. Уровень 2"
        );
    }

    @AfterAll
    protected void tearDown(){
        super.tearDown();
    }
}