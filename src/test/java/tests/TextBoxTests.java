package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
        @Test
    void fillFormWithVariablesTest() {
            String userName = "Dima",
                   email = "sunset@example.com",
                   currentAdress = "456-1120, Nishikyogoku Tsutsumisotocho, Ukyo-ku Kyoto-shi, Kyoto",
                   permanentAdress = "Via Raffaele Conforti 16";


            open("https://demoqa.com/text-box");

            $("#userName").val(userName);
            $("#userEmail").val(email);
            $("#currentAddress").val(currentAdress);
            $("#permanentAddress").val(permanentAdress);
            $("#submit").scrollTo().click();


            $("#output").shouldHave(text(
                    "Name:" + userName + "\n" +
                    "Email:" + email + "\n" +
                    "Current Address :" + currentAdress + "\n" +
                    "Permananet Address :" + permanentAdress + "\n"));

            open("https://demoqa.com/text-box");


    }

}
