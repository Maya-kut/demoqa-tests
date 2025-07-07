package tests;

import com.codeborne.selenide.Condition;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ClickSubmitWithoutFillingFieldsJenkins extends TestBase {

    @Tag("demoqa")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("[id=submit]").click();

        $("#userForm").shouldHave(Condition.cssClass("was-validated"));

    }
}
