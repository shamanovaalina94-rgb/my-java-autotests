package ui.pages;

import ui.base.BasePage;
import org.openqa.selenium.By;
import utils.Selectors;

public class RegisterPage extends BasePage {
    // Локаторы элементов формы
    private final By FIRST_NAME_INPUT = Selectors.byId("firstname");
    private final By LAST_NAME_INPUT = Selectors.byId("lastname");
    private final By USER_NAME_INPUT = Selectors.byId("userName");
    private final By PASSWORD_INPUT = Selectors.byId("password");
    private final By REGISTER_BUTTON = Selectors.byId("register");
    private final By BACK_TO_LOGIN_BUTTON = Selectors.byId("gotologin");

    // Методы для заполнения формы
    public void fillFirstName(String firstName){
        typeInto(FIRST_NAME_INPUT, firstName);
    }
    public void fillLastName(String lastName){
        typeInto(LAST_NAME_INPUT, lastName);
    }

    public void fillUserName(String userName){
        typeInto(USER_NAME_INPUT, userName);
    }

    public void fillPassword(String password){
        typeInto(PASSWORD_INPUT, password);
    }

    public void clickRegisterButton(){
        clickOn(REGISTER_BUTTON);
    }

    public void clickBackToLogin(){
        clickOn(BACK_TO_LOGIN_BUTTON);
    }
}
