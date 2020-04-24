package ru.geekbrains.main.site.at;


import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.career.CareerPage;
import ru.geekbrains.main.site.at.common.Search;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest extends BaseTest {

    private Search searchPage;

    @BeforeAll
    protected void setUp() {
        super.setUpDriver();
        driver.get("https://geekbrains.ru/career");
        searchPage = PageFactory.initElements(driver, CareerPage.class)
                .getHeader().clickSearch()
                .enterTextToSearch("Java");
    }


    @DisplayName("Проверка элементов")
    @ParameterizedTest(name = "{index} ==> Блок \"{0}\" шаг \" {1}\"")
    @MethodSource("stringProviderWithMatch")

    void checkSearchResult(String elementName, Matcher matcher) {
        searchPage.checkElement(elementName, matcher);
    }

    Stream<Arguments> stringProviderWithMatch() {
        return Stream.of(
                Arguments.of("Профессии", greaterThanOrEqualTo(2)),
                Arguments.of("Курсы", greaterThan(15)),
                Arguments.of("Вебинары", allOf(
                        greaterThan(180),
                        lessThan(300)
                )),
                Arguments.of("Блоги", greaterThan(300)),
                Arguments.of("Форум", not(350)),
                Arguments.of("Тесты", not(0)),
                Arguments.of("Geekbrains", is(true))
        );
    }

    @AfterAll
    protected void tearDown() {
        super.tearDown();
    }

}