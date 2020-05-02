package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;
import ru.geekbrains.main.site.at.page.AuthorizationPage;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка авторизации")
public class AuthTest extends BeforeAndAfterStep {

    @DisplayName("Вход с валидный логин/пароль")
    @Test
    void checkSingInValidLogin() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";

        new AuthorizationPage(driver)
                .openUrl()
                .authorization(login, password)
                .checkNamePage("Главная");
    }

}