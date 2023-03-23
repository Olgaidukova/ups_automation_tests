package web;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RecoveryTests extends TestBase {
    @Test
    @Tag("Jenkins")
    @Owner("O.Gaidukova")
    @DisplayName("Проверка возможности восстановления пароля")
    void upsRecoveryPasswordTest(){
        step("Открыть сайт UPS", () -> {
            upsPage.openHomePage();
        });

        step("Перейти на форму авторизации", () -> {
            upsPage.authLink();
        });

        step("Перейти на форму восстановления", () -> {
            upsPage.forgotPsw();
        });

        step("Проверить доступ", () -> {
            upsPage.verifyResultAuthAccess();
        });
    }
}
