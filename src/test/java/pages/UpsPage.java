package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Component;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class UpsPage {
    Component component = new Component();

    private SelenideElement
            authLinkClick = $(byLinkText("Войти в систему/зарегистрироваться")),
            emailInput = $("#email"),
            passwordInput = $("#pwd"),
            submitButton = $("#submitBtn"),
            choiceOrigCountry= $("#orig_Country"),
            origCity=$("#orig_City"),
            origPostCode= $("#orig_PostalCode"),
            scrollPostCode= $("#origpostalCode"),
            choiceDestCountry=$("#dest_Country"),
            destPostCode= $("#dest_PostalCode"),
            destCity= $("#dest_City"),
            scalar=$("#currencyScalar"),
            updateButton= $("#ctc_module1_submit"),
            forgotPassword=$(byLinkText("Забыл(а) имя пользователя/пароль")),
            setTrack=$("#stApp_trackingNumber"),
            searchTrack= $("#stApp_btnTrack"),
            menuLink= $("#ups-menuLinks3"),
            servicesLink=$(byLinkText("Посмотреть все услуги")),
            scrollHeader=$("#step-2 h3"),
            fromCountry=$("#from_country"),
            fromCity=$("#from_city"),
            fromState=$("#from_state"),
            fromZip=$("#from_zip"),
            toCountry=$("#to_country"),
            toCity=$("#to_city"),
            toZip=$("#to_zip"),
            loadingButton= $(".ups-cta_primary");
    ;


    public UpsPage openHomePage() {
        open("https://www.ups.com/ru/ru/Home.page");
        return this;
    }

    public UpsPage openTrackPage() {
        open("https://www.ups.com/track");
        return this;
    }

    public UpsPage openCalculatePage() {
        open("https://wwwapps.ups.com/ctc/request?loc=ru_RU");
        return this;
    }
    public UpsPage openCalculateCargoPage() {
        open("https://wwwapps.ups.com/fctc/timeandcost?loc=ru_RU");
        return this;
    }

    public UpsPage authLink() {
        authLinkClick.click();
        return this;
    }

    public UpsPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public UpsPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    public UpsPage submit() {
        submitButton.click();
        return this;
    }

    public UpsPage verifyResultAuthAccess() {
        component.verifyAuthAccess();
        return this;
    }

    public UpsPage choiceCountry(String value) {
        choiceOrigCountry.selectOption(value);
        return this;
    }

    public UpsPage origCity(String value) {
        origCity.setValue(value);
        return this;
    }
    public UpsPage origPostCode(String value) {
        origPostCode.setValue(value);
        return this;
    }

    public UpsPage scrollPostCode() {
        scrollPostCode.scrollTo();
        return this;
    }
    public UpsPage scrollHeader() {
        scrollHeader.scrollTo();
        return this;
    }
    public UpsPage choiceDestCountry(String value) {
        choiceDestCountry.selectOption(value);
        return this;
    }

    public UpsPage destPostCode(String value) {
        destPostCode.setValue(value);
        return this;
    }
    public UpsPage destCity(String value) {
        destCity.setValue(value);
        return this;
    }

    public UpsPage scalar(String value) {
        scalar.setValue(value);
        return this;
    }

    public UpsPage update() {
        updateButton.click();
        return this;
    }
    public UpsPage verifyCalculate() {
        component.verifyCalculate();
        return this;
    }
    public UpsPage verifyCargoCalculate() {
        component.verifyCargoCalculate();
        return this;
    }
    public UpsPage forgotPsw() {
        forgotPassword.click();
        return this;
    }
    public UpsPage setTrack(String value) {
        setTrack.setValue(value);
        return this;
    }
    public UpsPage searchTrack() {
        searchTrack.click();
        return this;
    }
    public UpsPage verifySearch() {
        component.verifySearch();
        return this;
    }
    public UpsPage menuLink() {
        menuLink.click();
        return this;
    }
    public UpsPage servicesLink() {
        servicesLink.click();
        return this;
    }
    public UpsPage verifyServices() {
        component.verifyServices();
        return this;
    }

    public UpsPage fromCountry(String value) {
        fromCountry.selectOption(value);
        return this;
    }
    public UpsPage fromCity(String value) {
        fromCity.setValue(value);
        return this;
    }
    public UpsPage fromState(String value) {
        fromState.selectOption(value);
        return this;
    }
    public UpsPage fromZip(String value) {
        fromZip.setValue(value);
        return this;
    }
    public UpsPage toCountry(String value) {
        toCountry.selectOption(value);
        return this;
    }
    public UpsPage toCity(String value) {
        toCity.setValue(value);
        return this;
    }
    public UpsPage toZip(String value) {
        toZip.setValue(value);
        return this;
    }
    public UpsPage loadingButton() {
        loadingButton.click();
        return this;
    }
}
