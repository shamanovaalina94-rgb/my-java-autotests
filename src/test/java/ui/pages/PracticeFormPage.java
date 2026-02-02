package ui.pages;

import ui.base.BasePage;
import org.openqa.selenium.By;
import utils.Selectors;

public class PracticeFormPage extends BasePage {
    // Локаторы элементов формы
    private final By FIRST_NAME_INPUT = Selectors.byId("firstName");
    private final By LAST_NAME_INPUT = Selectors.byId("lastName");
    private final By EMAIL_INPUT = Selectors.byId("userEmail");
    private final By GENDER_FEMALE =  Selectors.byForAttribute("gender-radio-2");
    private final By MOBILE_NUMBER_INPUT = Selectors.byId("userNumber");
    private final By DATE_OF_BIRTH_INPUT = Selectors.byId("dateOfBirthInput");
    private final By SUBJECTS_INPUT = Selectors.byId("subjectsInput");
    private final By HOBBIES_SPORTS = Selectors.byForAttribute("hobbies-checkbox-1");
    private final By HOBBIES_READING = Selectors.byForAttribute("hobbies-checkbox-2");
    private final By HOBBIES_MUSIC = Selectors.byForAttribute("hobbies-checkbox-3");
    private final By UPLOAD_PICTURE = Selectors.byId("uploadPicture");
    private final By CURRENT_ADDRESS_INPUT = Selectors.byId("currentAddress");
    private final By STATE_DROPDOWN = Selectors.byId("state");
    private final By CITY_DROPDOWN = Selectors.byId("city");
    private final By SUBMIT_BUTTON = Selectors.byId("submit");
    private final By MODAL_WINDOW = Selectors.byId("example-modal-sizes-title-lg");
    private final By CLOSE_BUTTON = Selectors.byId("closeLargeModal");

    // Методы для заполнения формы
    public void fillFirstName(String firstName){
        typeInto(FIRST_NAME_INPUT, firstName);
    }
    public void fillLastName(String lastName){
        typeInto(LAST_NAME_INPUT, lastName );
    }
    public void fillEmail(String email){
        typeInto(EMAIL_INPUT, email);
    }
    public void selectFemale(){
        clickOn(GENDER_FEMALE);
    }
    public void fillMobileNumber(String mobileNumber){
        typeInto(MOBILE_NUMBER_INPUT, mobileNumber);
    }
    public void fillDateOfBirth(String date){
        typeIntoAndCloseDropdown(DATE_OF_BIRTH_INPUT, date);
    }
    public void selectSubject(String subject){
        typeIntoAndCloseDropdown(SUBJECTS_INPUT, subject);
    }
    public void selectSportsHobby(){
        clickOn(HOBBIES_SPORTS);
    }
    public void selectReadingHobby(){
        clickOn(HOBBIES_READING);
    }
    public void selectMusicHobby(){
        clickOn(HOBBIES_MUSIC);
    }
    public void uploadPicture(String fileName){
        uploadFile(UPLOAD_PICTURE, fileName);
    }
    public void fillCurrentAddress(String currentAddress){
        typeInto(CURRENT_ADDRESS_INPUT, currentAddress);
    }
    public void selectState(String state){
        selectFromDropdown(STATE_DROPDOWN, state);
    }
    public void selectCity(String city){
        selectFromDropdown(CITY_DROPDOWN, city);
    }
    public void clickSubmitButton(){
        clickOn(SUBMIT_BUTTON);
    }
    public void resultsWindow(){
        verifyElementVisible(MODAL_WINDOW);
    }
    public void clickCloseButton(){
        clickOn(CLOSE_BUTTON);
    }
}
