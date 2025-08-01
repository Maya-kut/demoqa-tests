package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class PracticeFormTestAllFieldsJenkins {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    @Test
    void fillFormTest() {
        step("Open form", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });

        step("Fill form", () -> {
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
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("image.png");
            $("#currentAddress").setValue("Moscow, Red Square");
            $("#state").click();
            $("#react-select-3-input").setValue("Haryana").pressEnter();
            $("#city").click();
            $("#react-select-4-input").setValue("Panipat").pressEnter();
            $("[id=submit]").click();
        });
        step("Verify results", () -> {
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
        });


    }
}


