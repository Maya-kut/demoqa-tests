import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    private File Users;

    @BeforeAll
static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.browser = "chrome";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.timeout = 3000;
    Configuration.holdBrowserOpen =true;
}

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Maiya").pressEnter();
        $("[id=lastName]").setValue("M").pressEnter();
        $("[id=userEmail]").setValue("maiya@mail.ru").pressEnter();
        $("[id=genterWrapper]").$(byText("Female")).click();
        $("[id=userNumber]").setValue("88009008890").pressEnter();

        $("#dateOfBirthInput").click();

        $("[class=react-datepicker__month-select]").selectOption("June");
        $("[class=react-datepicker__year-select]").selectOption("1996");
        $("[class=react-datepicker__day]").$(byText("25")).click();

        $("[id=subjectsInput]").setValue("M").pressEnter();
        $("[id=subjectsInput]").setValue("G").pressEnter();

        $("[id=hobbiesWrapper]").find("Sports").click();
        $("[id=hobbiesWrapper]").find("Reading").click();
        $("[id=hobbiesWrapper]").find("Music").click();

        $("[id=uploadPicture]").uploadFromClasspath(image.png);

        $("[id=uploadPicture]").setValue("Moscow, Red Square");

        $("[id=react-select-3-input]").setValue("Haryana").pressEnter();
        $("[id=react-select-4-input]").setValue("Panipat").pressEnter();

        $("[id=submit]").click();



    }
}


