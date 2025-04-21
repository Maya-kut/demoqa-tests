import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//    Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maiya").pressEnter();
        $("#lastName").setValue("M").pressEnter();
        $("#userEmail").setValue("maiya@mail.ru").pressEnter();
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("88009008890").pressEnter();

        $("#dateOfBirthInput").pressEnter();

        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1996");
        $$("div.react-datepicker__day").findBy(text("25")).pressEnter();

        $("#subjectsInput").setValue("M").pressEnter();
        $("#subjectsInput").setValue("B").pressEnter();

        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-2]").click();
        $("label[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFromClasspath("image.png");

        $("#uploadPicture").setValue("Moscow, Red Square");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("[id=submit]").click();


        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Maiya M"));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("maiya@mail.ru"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Female"));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("88009008890"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("25 June,1996"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Maths, Biology"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports, Reading, Music"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("image.png"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("Moscow, Red Square"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("Haryana Panipat"));

        $("#closeLargeModal").click();


    }
}


