import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByAttribute;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideGithubTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void Validation() {
        open("/");
        // поле поиска
        $("[placeholder='Search or jump to...']").click();
        // вставить текст в поле поиска
        $("#query-builder-test").setValue("Selenide").pressEnter();
        // найти результат поиска по атрибуту
        $(new ByAttribute("href","/selenide/selenide")).click();
        // убедиться что зашел в нужный репозиторий
        $("#repository-container-header a").shouldHave(text("selenide"));
    }
}
