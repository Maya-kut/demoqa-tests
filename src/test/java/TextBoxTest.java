import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
    private File Users;

    @BeforeAll
static void beforeAll() {
    Configuration.browserSize = "1920x1080";
//    Configuration.browser = "chrome";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.timeout = 3000;
    Configuration.holdBrowserOpen =true;
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

//        $("#uploadPicture").uploadFromClasspath(image.png);

        $("#uploadPicture").setValue("Moscow, Red Square");

        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("[id=submit]").click();



    }
}


