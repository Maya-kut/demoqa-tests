package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTestRequiredFields {
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

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
