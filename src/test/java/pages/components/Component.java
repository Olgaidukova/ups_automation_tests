package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Component {
    public void verifyAuthAccess(){
        $("h1").shouldHave(text("Access Denied"));
    }
    public void verifyCalculate(){
        $(".sel:nth-child(3)").shouldHave(text("Из  NANGEENAN, 6414 Австралия"));
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
