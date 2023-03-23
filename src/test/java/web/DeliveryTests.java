package web;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class DeliveryTests extends TestBase {
    @Test
    @Tag("Jenkins")
    @Owner("O.Gaidukova")
    @DisplayName("Проверка формы заполнения Экспресс-отправление")
    void upsDeliveryTest(){
        TestData data = new TestData();
        step("Открыть форму расчета сроков и стоимости", () -> {
            upsPage.openCalculatePage();
        });

        step("Заполнить данными для доставки", () -> {
            upsPage.choiceCountry(data.origCountry)
                    .origCity(data.origCity)
                    .origPostCode(data.origPostCode)
                    .scroll()
                    .choiceDestCountry(data.destCountry)
                    .destPostCode(data.destPostCode)
                    .destCity(data.destCity)
                    .scalar(data.scalar)
                    .update();

            step("Проверить результат", () -> {
                upsPage.verifyCalculate();
            });
        });
    }

    @Test
    @Tag("Jenkins")
    @Owner("O.Gaidukova")
    @DisplayName("Проверка формы заполнения Грузовое-отправление")
    void upsDeliveryCargoTest(){
        TestData data = new TestData();
        step("Открыть форму расчета сроков и стоимости", () -> {
            upsPage.openCalculateCargoPage();
        });

        step("Заполнить данными для доставки", () -> {
/*            upsPage.choiceCountry(data.origCountry)
                    .origCity(data.origCity)
                    .origPostCode(data.origPostCode)
                    .scroll()
                    .choiceDestCountry(data.destCountry)
                    .destPostCode(data.destPostCode)
                    .destCity(data.destCity)
                    .scalar(data.scalar)
                    .update();*/
            $("#step-2 h3").scrollTo();
            $("#from_country").click();
            $("#from_country").selectOption(data.origCountry);
            $("#from_city").click();
            $("#from_city").setValue(data.origCity);
            $("#from_state").click();
            $("#from_state").selectOption("Территория столицы Австралии");
            $("#from_zip").click();
            $("#from_zip").setValue(data.origPostCode);
            $("#to_country").click();
            $("#to_country").selectOption(data.destCountry);
            $("#to_city").click();
            $("#to_city").setValue(data.destCity);
            $("#to_zip").click();
            $("#to_zip").setValue("500");
            $(".ups-cta_primary").click();


            step("Проверить результат", () -> {
                upsPage.verifyCargoCalculate();
            });
        });
    }
}
