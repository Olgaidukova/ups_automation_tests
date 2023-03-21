package ups;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class DeliveryTests extends TestBase {
    @Test
    @Disabled
    @Tag("Jenkins")
    @DisplayName("Проверка формы заполнения расчета сроков и стоимости")
    void upsDeliveryTest(){

        step("Открыть форму расчета сроков и стоимости", () -> {
            open("https://wwwapps.ups.com/ctc/request?loc=ru_RU");
        });

        step("Заполнить данными для доставки", () -> {
            $("#orig_Country").click();
            $("#orig_Country").selectOption("Австралия");
            $("#orig_City").click();
            $("#orig_City").setValue("NANGEENAN");
            $("#orig_PostalCode").setValue("6414");
            $("#origpostalCode").scrollTo();

            $("#dest_Country").click();
            $("#dest_Country").selectOption("Австрия");
            $("#dest_PostalCode").click();
            $("#dest_PostalCode").setValue("6500");
            $("#dest_City").click();
            $("#dest_City").setValue("WOLFSBERG");

            $("#currencyScalar").setValue("500");

            $("#ctc_module1_submit").click();

            step("Проверить результат", () -> {
                $(".sel:nth-child(3)")
                        .shouldHave(text("Из  NANGEENAN, 6414 Австралия"));
            });
        });
    }
}
