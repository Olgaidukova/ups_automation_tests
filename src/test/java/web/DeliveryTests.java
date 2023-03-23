package web;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
                    .scrollPostCode()
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
            upsPage.scrollHeader()
                    .fromCountry(data.origCountry)
                    .fromCity(data.origCity)
                    .fromState(data.state)
                    .fromZip(data.origPostCode)
                    .toCountry(data.destCountry)
                    .toCity(data.destCity)
                    .toZip(data.destPostCode)
                    .loadingButton();

            step("Проверить результат", () -> {
                upsPage.verifyCargoCalculate();
            });
        });
    }
}
