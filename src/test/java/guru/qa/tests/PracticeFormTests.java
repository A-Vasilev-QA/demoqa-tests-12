package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.headless=true;
    }

    @Test
    public void tableIsCorrectTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Aleksei");
        $("#lastName").setValue("Vasilev");
        $("#userEmail").setValue("kardahur@gmail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9054512345");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1989");
        $(".react-datepicker__day.react-datepicker__day--009").click();
        $("#subjectsInput").setValue("Computer").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFromClasspath("img/1.jpg");
        $("#currentAddress").setValue("Another str. 11");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").scrollTo().click();

        //Asserts

        $("#example-modal-sizes-title-lg").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Aleksei Vasilev"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("kardahur@gmail.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("9054512345"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("09 August,1989"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("1.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("Another str. 11"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));

    }
}
