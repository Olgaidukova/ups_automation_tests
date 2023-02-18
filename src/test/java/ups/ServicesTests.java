package ups;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ServicesTests extends TestBase {
    @Test
    @Tag("Jenkins")
    @Owner("O.Gaidukova")
    @DisplayName("Проверка доступных услуг")
    void upsAvailableServicesTest(){

        step("Открыть сайт UPS", () -> {
            upsPage.openHomePage();
        });

        step("Перейти на Услуги", () -> {
            upsPage.menuLink()
                    .servicesLink();
        });

        step("Проверить доступность услуги Отправка", () -> {
            upsPage.verifyServices();
         });
    }
}
