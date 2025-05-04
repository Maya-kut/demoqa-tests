import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestAllFields {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Maiya");
        $("#lastName").setValue("M");
        $("#userEmail").setValue("maiya@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8800900889");

        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1996");
        $$("div.react-datepicker__day").findBy(text("25")).click();

        $("#subjectsInput").setValue("M").pressEnter();
        $("#subjectsInput").setValue("B").pressEnter();

//        $("label[for='hobbies-checkbox-1']").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("label[for=hobbies-checkbox-2]").click();
//        $("label[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFromClasspath("image.png");
//
        $("#currentAddress").setValue("Moscow, Red Square");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("[id=submit]").click();


        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Maiya M"));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("maiya@mail.ru"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Female"));
        $$(".table-responsive").findBy(text("Mobile")).parent().shouldHave(text("8800900889"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("25 June,1996"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Maths, Biology"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("image.png"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("Moscow, Red Square"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("Haryana Panipat"));

        $("#closeLargeModal").click();


    }
}


