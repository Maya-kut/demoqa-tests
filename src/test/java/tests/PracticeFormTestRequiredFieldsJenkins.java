package tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTestRequiredFieldsJenkins extends TestBase {

    @Tag("demoqa")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
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
            $("#genterWrapper").$(byText("Female")).click();
            $("#userNumber").setValue("8800900889");

            $("[id=submit]").click();
        });


        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Maiya M"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Female"));
        $$(".table-responsive").findBy(text("Mobile")).parent().shouldHave(text("8800900889"));


        $("#closeLargeModal").click();


    }
}
