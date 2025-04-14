import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
@BeforeAll
static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.timeout = 3000;
}

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("[id=searchbox_input]").setValue("selenide").pressEnter();
        $("[id=searchbox_input]").setValue("selenide").pressEnter();
        $("[id=searchbox_input]").setValue("selenide").pressEnter();
        $("[id=searchbox_input]").click();



        $("[id=react-layout]").shouldHave(text("https://selenide.org"));
    }
}


