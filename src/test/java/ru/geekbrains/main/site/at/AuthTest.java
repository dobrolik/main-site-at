package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.pages.AuthPage;

@DisplayName("Проверка авторизации")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthTest extends BaseTest {

    @BeforeAll
    protected void SetUp(){
        super.setUpDriver();
        driver.get("https://geekbrains.ru/login");
    }

    @DisplayName("Проверка \"Главная\"")
    @Test
    void checkMain(){
        PageFactory.initElements(driver, AuthPage.class)
                .loginAsCustomer("hao17583@bcaoo.com", "hao17583")
                .getHeader().checkTitle("Главная");
    }

    @AfterAll
    protected void tearDown(){
        super.tearDown();
    }
}