package ups;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @ValueSource(strings = {
            "1Z81RF250341587774",
            "CN0002332718RU9"
    })
    @ParameterizedTest(name = "Отслеживается трек-номер {0}")
    @Tag("Jenkins")
    void upsSearchTest(String trackNumber) {
        step("Открыть форму отслеживание UPS-отправлений", () -> {
            open("https://www.ups.com/track");
        });

        step("Отследить отправления", () -> {
            $("#stApp_trackingNumber").setValue(trackNumber);
            $("#stApp_btnTrack").click();
        });

        step("Проверить результаты поиска", () -> {
            $(".col-md-8 .ups-card_content")
                    .shouldHave(text("We could not locate the shipment details for this tracking number."));
        });
    }
}
