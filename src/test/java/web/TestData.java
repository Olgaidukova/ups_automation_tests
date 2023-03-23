package web;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    String userEmail = faker.internet().emailAddress();
    String password = "12345678";
    String origCountry = "Австралия";
    String origCity = "NANGEENAN";
    String origPostCode= "6414";
    String destCountry = "Австрия";
    String destPostCode = "6500";
    String destCity = "WOLFSBERG";
    String scalar = "500";
}
