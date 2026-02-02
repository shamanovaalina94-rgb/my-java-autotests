package ui.tests;

import ui.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;

public class TextBoxTest extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeEach
    void openTextBoxPage(){
        openPage("https://demoqa.com/text-box");
    }

    @Test
    void fillAllForms(){
        String fullName = "Test Name";
        String fillEmailField = "Test@Name.ru";
        String fillCurrentAddress = "Test Current Address";
        String fillPermanentAddress = "Test Permanent Address";

        textBoxPage.fillFullName(fullName);
        textBoxPage.fillEmailField(fillEmailField);
        textBoxPage.fillCurrentAddress(fillCurrentAddress);
        textBoxPage.fillPermanentAddress(fillPermanentAddress);
        textBoxPage.clickSubmitButton();
        textBoxPage.completedFormShouldHaveInfo(
                fullName,
                fillEmailField,
                fillCurrentAddress,
                fillPermanentAddress
        );
    }
}
