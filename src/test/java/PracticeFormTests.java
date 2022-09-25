import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    public static void congigUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1280";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void practiceFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Demin");
        $("#userEmail").setValue("test@test.ru");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("9066293356");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $x("//div[@class='react-datepicker__month']//div[contains(text(), '31')]").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("pic.jpg");
        $("#currentAddress").setValue("test, test, 333, test");
        $("#stateCity-wrapper").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive")
                .shouldHave(text("Nikita Demin"),
                text("test@test.ru"),
                text("Male"),
                text("9066293356"),
                text("31 May,1991"),
                text("Computer Science"),
                text("Sports, Reading, Music"),
                text("test, test, 333, test"),
                text("pic.jpg"),
                text("Haryana Karnal"));
    }
}
