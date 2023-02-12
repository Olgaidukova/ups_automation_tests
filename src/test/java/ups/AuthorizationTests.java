package ups;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AuthorizationTests {
    @Test
    @DisplayName("Проверка авторизации с некорректными логин/пароль")
    void pochtaAuthNegativeTest(){
        step("Открыть сайт UPS", () -> {
            open("https://www.ups.com/ru/ru/Home.page");
        });

        step("Перейти на форму авторизации", () -> {
            $(byLinkText("Войти в систему/зарегистрироваться")).click();
        });

        step("Ввести некорректные данные", () -> {
            $("#email").setValue("test@gmail.com");
            $("#pwd").setValue("12345678");
            $("#submitBtn").click();
        });

        step("Проверить валидационную ошибку", () -> {
            $(".ups-formError:nth-child(1)").shouldHave(text("Что-то пошло не так."));
        });
    }
}
