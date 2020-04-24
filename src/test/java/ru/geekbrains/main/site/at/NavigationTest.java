package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.stream.Stream;

@DisplayName("Проверка блока навигации")
public class NavigationTest extends BaseTest {

    @BeforeEach
    protected void SetUp(){
        super.setUpDriver();
        driver.get("https://geekbrains.ru/career");
    }

    public static Stream<String> stringProvider() {
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @DisplayName("Проверка соответсвия header после нажатия в панели навигации")
    @ParameterizedTest(name = "проверка: {0}")
    @MethodSource("stringProvider")
    void checkNavigation(String namePage) throws InterruptedException {

        PageFactory.initElements(driver, Page.class)
                .getNavigation().clickButton(namePage)
                .checkHeaderTitle(namePage);


//                .getNavigation().clickButton("Вебинары")
//                .checkHeaderTitle("Вебинары")
//                .getNavigation().clickButton("Форум")
//                .checkHeaderTitle("Форум")
//                .getNavigation().clickButton("Блог")
//                .checkHeaderTitle("Блог")
//                .getNavigation().clickButton("Тесты")
//                .checkHeaderTitle("Тесты")
//                .getNavigation().clickButton("Карьера")
//                .checkHeaderTitle("Карьера");

//        Navigation navigation = PageFactory.initElements(driver, Navigation.class);
//        Page page = PageFactory.initElements(driver, Page.class);
//
//        page.getNavigation().clickButton("Курсы");
//        page.checkHeaderTitle("Курсы");
//
//        page.getButtonClosePopUP().click();
//
//        page.getNavigation().clickButton("Вебинары");
//        page.checkHeaderTitle("Вебинары");
//        page.getNavigation().clickButton("Форум");
//        page.checkHeaderTitle("Форум");
//        page.getNavigation().clickButton("Блог");
//        page.checkHeaderTitle("Блог");
//        page.getNavigation().clickButton("Тесты");
//        page.checkHeaderTitle("Тесты");
//        page.getNavigation().clickButton("Карьера");
//        page.checkHeaderTitle("Карьера");
    }

    @AfterEach
    protected void tearDown(){
        super.tearDown();
    }
}