package web;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @ValueSource(strings = {
            "1Z81RF250341587774",
            "CN0002332718RU9"
    })
    @ParameterizedTest(name = "Отслеживается трек-номер {0}")
    @Tag("Jenkins")
    @Owner("O.Gaidukova")
    void upsSearchTest(String trackNumber) {
        step("Открыть форму отслеживание UPS-отправлений", () -> {
            upsPage.openTrackPage();
        });

        step("Отследить отправления", () -> {
            upsPage.setTrack(trackNumber)
                    .searchTrack();
        });

        step("Проверить результаты поиска", () -> {
            upsPage.verifySearch();
        });
    }
}
