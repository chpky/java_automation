import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples(){
        //<input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email"
        $("[data-testid=email]").setValue("");
        $(by("data-testid", "email")).setValue("");

        //<input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("");
        $("#email").setValue(""); // "#" for id
        $("input#email").setValue("");
        $x("//*[@id='email']").setValue("");
        $x("//input[@id='email']").setValue("");

        //<input type="email" class="inputtext login_form_input_box" name="email" >
        $("[name=email]").setValue("");
        $(byName("email")).setValue("");

        //<input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]").setValue("");
        $(".login_form_input_box").setValue(""); // "." for class
        $("input.inputtext.login_form_input_box").setValue("");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("");

        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box").setValue(""); // equals to the next line
        $(".inputtext").$("login_form_input_box").setValue("");

        // <div>Hello, Qa!</div>
        $x("//div[text()='Hello, Qa!']").click();
        $(byText("Hello, Qa!")).click();
        $(withText("ello, Q")).click();
    }
}
