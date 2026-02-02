package ui.tests;

import ui.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    void openLoginPage(){
        openPage("https://demoqa.com/login");
    }

    @Test
    void fillAllForms(){
        String userName = "TestName";
        String password = "Qwerty12@!";
        String errorMessage = "Invalid username or password!";

        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
        loginPage.checkErrorMessage(errorMessage);
    }

    @Test
    void registerNewUser(){
        loginPage.clickNewUserButton();
    }
}
