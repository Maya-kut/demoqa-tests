package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;

public class PracticeFormPoMrandomValues extends TestBase {

    Faker faker = new Faker(new Locale("en"));

    String firstName = getRandomFirstName(); // Emory
    String lastName = getRandomLastName();
    String email = getRandomEmail();
    String gender = getRandomGender();
    String mobile = getRandomPhone();
    String birthDay = getRandomBirthDay();
    String birthMonth = getRandomBirthMonth();
    String birthYear = getRandomBirthYear();
    String subject = getRandomSubject();
    String hobby = getRandomHobby();
    String image = getRandomImage();
    String address = getRandomAddress();
    String state = getRandomState();
    String city = getRandomCity(state);

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
                .setSubjects(subject)
                .setHobbiesTuned(hobby)
                .upLoadPicture(image)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        //Проверка корректности заполнения формы
        RegistrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", image)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city)
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
        RegistrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
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
