package ru.geekbrains.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.common.PageObject;

public class AuthPage extends PageObject {

    @FindBy(css = "[id=\"user_email\"]")
    private WebElement inputEmail;

    @FindBy(css = "[id=\"user_password\"]")
    private WebElement inputPassword;

    @FindBy(css = "[data-testid=\"login-submit\"]")
    private WebElement buttonLogin;

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public MainPage loginAsCustomer(String email, String passwd) {
        enterText(inputEmail, email);
        enterText(inputPassword, passwd);
        buttonClick(buttonLogin);
        return PageFactory.initElements(driver, MainPage.class);
    }
}
