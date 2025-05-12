package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormPOM extends TestBase {
    String firstName = "Maiya";
    String lastName = "M";
    String email = "maiya@mail.ru";
    String gender = "Female";
    String mobile = "8800900889";
    String birthDay = "25";
    String birthMonth = "June";
    String birthYear = "1996";
    String subjectOne = "Biology";
    String hobby = "Sports";
    String address = "Moscow, Red Square";
    String state = "Haryana";
    String city = "Panipat";

    RegistrationPage RegistrationPage = new RegistrationPage();

    @Test
//Отправка формы со всеми заполненными полями
    void PracticeFormTestAllFields() {
        RegistrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(mobile)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubjects(subjectOne)
                .setHobbies(hobby)
                .upLoadPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        //Проверка корректности заполнения формы
        RegistrationPage.checkResult("Student Name", "Maiya M")
                .checkResult("Student Email", "maiya@mail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800900889")
                .checkResult("Date of Birth", "25 June,1996")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "image.png")
                .checkResult("Address", "Moscow, Red Square")
                .checkResult("State and City", "Haryana Panipat")
                .clickCloseLargeModal();


    }

    @Test
        // Заполнение только обязательных параметров
    void PracticeFormTestRequiredFields() {
        RegistrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(mobile)
                .clickSubmitButton();


        //Проверка корректности заполнения формы
        RegistrationPage.checkResult("Student Name", "Maiya M")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800900889")
                .clickCloseLargeModal();
    }

    @Test
        // Отправка формы без заполнения параметров
    void ClickSubmitWithoutFillingFields() {
        RegistrationPage.openPage()
                .clickSubmitButton();

        RegistrationPage.checkUserForm();

    }
}
