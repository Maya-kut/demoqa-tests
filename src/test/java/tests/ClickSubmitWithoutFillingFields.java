package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ClickSubmitWithoutFillingFields {

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

        $("[id=submit]").click();

        $("#userForm").shouldHave(Condition.cssClass("was-validated"));

    }
}
