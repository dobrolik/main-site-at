package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;
import ru.geekbrains.main.site.at.page.content.TestPage;

import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка навигации")
@Feature("Проверка навигации")
public class NavigationTest extends BeforeAndAfterStep {

    static Stream<String> stringProvider() {
        return Stream.of(
                "Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @DisplayName("Нажатие в навигации")
    @ParameterizedTest(name = "{index} => переход на страницу {0}")
    @MethodSource("stringProvider")
    void checkNavigation(String namePage) {
        new TestPage(driver)
                .openUrl()
                .getLeftNavigation().clickButton(namePage)
                .getHeader().checkNamePage(namePage);
    }

}