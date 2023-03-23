package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Component {
    public void verifyAuthAccess(){
        $("h1").shouldHave(text("Access Denied"));
    }
    public void verifyCalculate(){
        $("table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(3)")
                .shouldHave(text("NANGEENAN, 6414 Австралия"));
    }
    public void verifyCargoCalculate(){
        $("#step-2 h3")
                .shouldHave(text("Подробности единицы груза"));
    }
    public void verifySearch(){
        $(".col-md-8 .ups-card_content")
                .shouldHave(text("We could not locate the shipment details for this tracking number."));
    }

    public void verifyServices(){
        $("#tab_1_panel .ups-list_detail:nth-child(1) p:nth-child(1)")
                .shouldHave(text("Услуги и технологии управления процессом грузоперевозок: от физических лиц до корпораций, от внутренних перевозок до межконтинентальных."));
    }
}
