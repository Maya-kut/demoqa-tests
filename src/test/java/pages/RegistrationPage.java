package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderWrapper = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement calendarInput = $("#dateOfBirthInput");
    private SelenideElement subjectInput = $("#subjectsInput");
    private SelenideElement hobbyChoice = $("#hobbiesWrapper").$(byText("Sports"));
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement AddressTextArea = $("#currentAddress");
    private SelenideElement selectState = $("#state");
    private SelenideElement getSelectState = $("#react-select-3-input");
    private SelenideElement selectCity = $("#city");
    private SelenideElement getSelectCity = $("#react-select-4-input");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement closeButton = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value, String subjectTwo) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbyChoice.click();

        return this;
    }

    public RegistrationPage upLoadPicture() {
        uploadPicture.uploadFromClasspath("image.png");

        return this;
    }

    public RegistrationPage setAddress(String address) {
        AddressTextArea.setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        selectState.click();
        getSelectState.find(String.valueOf(text("Haryana"))).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        selectCity.click();
        getSelectCity.find(String.valueOf(text("Panipat"))).click();
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }


    public void clickCloseLargeModal(){
        closeButton.click();
    }

    public void checkUserForm() {
        $("#userForm").shouldHave(Condition.cssClass("was-validated"));
    }
}

