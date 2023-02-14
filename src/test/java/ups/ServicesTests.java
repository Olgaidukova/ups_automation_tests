package ups;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ServicesTests extends TestBase {
    @Test
    @Tag("Jenkins")
    @DisplayName("Проверка доступных услуг")
    void upsAvailableServicesTest(){

        step("Открыть сайт UPS", () -> {
            open("https://www.ups.com/ru/ru/Home.page");
        });

        step("Перейти на Услуги", () -> {
            $("#ups-menuLinks3").click();
            $(byLinkText("Посмотреть все услуги")).click();
        });

        step("Проверить доступность услуги Отправка", () -> {
            $("#tab_1_panel .ups-list_detail:nth-child(1) p:nth-child(1)")
                    .shouldHave(text("Услуги и технологии управления процессом грузоперевозок: от физических лиц до корпораций, от внутренних перевозок до межконтинентальных."));
        });
    }
}
