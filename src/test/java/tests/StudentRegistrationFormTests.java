package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
    }

    @Test
    void successfulRegistrationTest(){
    String firstName = "Adelia",
           lastName = "Farrell",
           email = "avis24@herzog.com",
           gender = "Female",
           mobile = "1742826282",
           dayOfBirth = "06",
           monthOfBirth = "March",
           dateOfBirth = "1996",
           subjects1Prefix = "a",
           subjects1 = "Arts",
           subjects2Prefix = "y",
           subject2 = "Physics",
           hobby = "Reading",
           picture = "21.png",
           currentAddress = "Lubowitz, Braun and Conn",
           state = "Haryana",
           city = "Karnal";


    open("https://demoqa.com/automation-practice-form");

    $("#firstName").val(firstName);
    $("#lastName").val(lastName);
    $("#userEmail").val(email);
    $("#genterWrapper").$(byText(gender)).click();
    $("#userNumber").val(mobile);

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(monthOfBirth);
    $(".react-datepicker__year-select").selectOption(dateOfBirth);
    $(".react-datepicker__day--0" + dayOfBirth).click();
    $("#subjectsInput").val(subjects1Prefix);
    $(".subjects-auto-complete__menu-list").$(byText(subjects1)).click();
    $("#subjectsInput").val(subjects2Prefix);
    $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();

    $("#hobbiesWrapper").$(byText(hobby)).click();

    $("#uploadPicture").uploadFile(new File("src/test/resources/21.png"));

    $("#currentAddress").scrollTo().val(currentAddress);

    $("#state").scrollTo().click();
    $("#stateCity-wrapper").$(byText(state)).click();
    $("#city").scrollTo().click();
    $("#stateCity-wrapper").$(byText(city)).click();

    $("#submit").click();

    $("#example-modal-sizes-title-lg").shouldHave((text("Thanks for submitting the form")));
    $(".table-responsive").shouldHave((text(firstName + " " + lastName)),
            text(email), text(gender));
    $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
    $x("//td[text()='Student Email']").parent().shouldHave(text(email));
    $x("//td[text()='Gender']").parent().shouldHave(text(gender));
    $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
    $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + dateOfBirth));
    $x("//td[text()='Subjects']").parent().shouldHave(text(subjects1 + ", " + subject2));
    $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
    $x("//td[text()='Picture']").parent().shouldHave(text(picture));
    $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
    $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));




    }
}
