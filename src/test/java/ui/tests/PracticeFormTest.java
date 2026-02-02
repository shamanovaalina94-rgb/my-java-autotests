package ui.tests;

import ui.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;

public class PracticeFormTest extends BaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeEach
    void openPracticeFormPage(){
        openPage("https://demoqa.com/automation-practice-form");
    }

    @Test
    void fillAllForms(){
        String firstName = "Анна";
        String lastName = "Иванова";
        String email = "Test@mail.ru";
        String mobileNumber = "1234567890";
        String dateOfBirth = "01 января 2000";
        String subject = "History";
        String subject2= "Physics";
        String subject3 = "Maths";
        String file = "test.jpg";
        String currentAddress = "Test Current Address";
        String state = "NCR";
        String city = "Noida";

        practiceFormPage.fillFirstName(firstName);
        practiceFormPage.fillLastName(lastName);
        practiceFormPage.fillEmail(email);
        practiceFormPage.selectFemale();
        practiceFormPage.fillMobileNumber(mobileNumber);
        practiceFormPage.fillDateOfBirth(dateOfBirth);
        practiceFormPage.selectSubject(subject);
        practiceFormPage.selectSubject(subject2);
        practiceFormPage.selectSubject(subject3);
        practiceFormPage.selectSportsHobby();
        practiceFormPage.selectReadingHobby();
        practiceFormPage.selectMusicHobby();
        practiceFormPage.uploadPicture(file);
        practiceFormPage.fillCurrentAddress(currentAddress);
        practiceFormPage.selectState(state);
        practiceFormPage.selectCity(city);
        practiceFormPage.clickSubmitButton();
        practiceFormPage.resultsWindow();
        practiceFormPage.clickCloseButton();
    }
}
