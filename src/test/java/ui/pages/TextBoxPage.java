package ui.pages;

import ui.base.BasePage;
import org.openqa.selenium.By;
import utils.Selectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage extends BasePage {
    // Локаторы элементов формы
    private final By FULL_NAME_INPUT = Selectors.byId("userName");
    private final By EMAIL_FIELD_INPUT = Selectors.byId("userEmail");
    private final By CURRENT_ADDRESS_INPUT = Selectors.byId("currentAddress");
    private final By PERMANENT_ADDRESS_INPUT = Selectors.byId("permanentAddress");
    private final By SUBMIT_BUTTON = Selectors.byId("submit");
    private final By COMPLETED_FORM = Selectors.byId("output");

    // Методы для заполнения формы
    public void fillFullName(String fullName){
        typeInto(FULL_NAME_INPUT, fullName);
    }

    public void fillEmailField(String emailValue){
        typeInto(EMAIL_FIELD_INPUT, emailValue);
    }

    public void fillCurrentAddress(String currentAddress){
        typeInto(CURRENT_ADDRESS_INPUT, currentAddress);
    }

    public void fillPermanentAddress(String permanentAddress){
        typeInto(PERMANENT_ADDRESS_INPUT, permanentAddress);
    }

    public void clickSubmitButton(){
        clickOn(SUBMIT_BUTTON);
    }

    public void completedFormShouldHaveInfo(
            String fullName,
            String emailValue,
            String currentAddress,
            String permanentAddress){
        $(COMPLETED_FORM).shouldHave(
                text(fullName),
                text(emailValue),
                text(currentAddress),
                text(permanentAddress)
        );
    }
}
