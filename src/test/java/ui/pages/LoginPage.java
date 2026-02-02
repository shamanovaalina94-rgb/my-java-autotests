package ui.pages;

import ui.base.BasePage;
import org.openqa.selenium.By;
import utils.Selectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    // Локаторы элементов формы
    private final By USER_NAME_INPUT = Selectors.byId("userName");
    private final By PASSWORD_INPUT = Selectors.byId("password");
    private final By LOGIN_BUTTON = Selectors.byId("login");
    private final By ERROR_MESSAGE = Selectors.byId("name");
    private final By NEW_USER_BUTTON = Selectors.byId("newUser");

    // Методы для заполнения формы
    public void fillUserName(String userName){
        typeInto(USER_NAME_INPUT, userName);
    }
    public void fillPassword(String password){
        typeInto(PASSWORD_INPUT, password);
    }
    public void clickLoginButton(){
        clickOn(LOGIN_BUTTON);
    }
    public void checkErrorMessage(String errorMessage){
        $(ERROR_MESSAGE).shouldHave(text(errorMessage));

    }
    public void clickNewUserButton(){
        clickOn(NEW_USER_BUTTON);
    }
}
