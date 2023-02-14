package ups;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RecoveryTests extends TestBase {
    @Test
    @Tag("Jenkins")
    @DisplayName("Проверка возможности восстановления пароля")
    void upsRecoveryPasswordTest(){
        step("Открыть сайт UPS", () -> {
            open("https://www.ups.com/ru/ru/Home.page");
        });

        step("Перейти на форму авторизации", () -> {
            $(byLinkText("Войти в систему/зарегистрироваться")).click();
        });

        step("Перейти на форму восстановления", () -> {
            $(byLinkText("Забыл(а) имя пользователя/пароль")).click();
        });

        step("Проверить доступ", () -> {
            $("h1").shouldHave(text("Access Denied"));
        });
    }
}
