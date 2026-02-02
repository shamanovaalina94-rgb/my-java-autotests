package ui.tests;

import ui.pages.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @BeforeEach
    void openRegisterPage(){
        openPage("https://demoqa.com/register");
    }

    @Test
    void fillAllForms(){
        String firstName = "Тест";
        String lastName = "Тестов";
        String userName = "TestName";
        String password = "Qwerty12!@";

        registerPage.fillFirstName(firstName);
        registerPage.fillLastName(lastName);
        registerPage.fillUserName(userName);
        registerPage.fillPassword(password);
        registerPage.clickRegisterButton();
    }

    @Test
    void backToLogin(){
        registerPage.clickBackToLogin();
    }
}
