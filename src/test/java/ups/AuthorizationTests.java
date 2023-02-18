package ups;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AuthorizationTests extends TestBase {
    @Test
    @Tag("Jenkins")
    @Owner("O.Gaidukova")
    @DisplayName("Проверка авторизации с некорректными логин/пароль")
    void upsAuthNegativeTest(){
        TestData data = new TestData();
        step("Открыть сайт UPS", () -> {
            upsPage.openHomePage();
        });

        step("Перейти на форму авторизации", () -> {
            upsPage.authLink();
        });

        step("Ввести некорректные данные", () -> {
            upsPage.setEmail(data.userEmail)
                    .setPassword(data.password)
                    .submit();
        });

        step("Проверить валидационную ошибку", () -> {
            upsPage.verifyResultAuthAccess();
        });
    }
}
