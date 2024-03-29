package Tests;

import PaymentObject.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import static PaymentObject.ButtonType.FIRST;
import static PaymentObject.ButtonType.SECOND;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RegisterOrder extends BaseTest {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String phone;
    private final String metro;
    private final boolean isSuccessfulWindow;
    private final String comment;
    private final String date;
    private final ButtonType buttonType;



    public RegisterOrder(String firstName, String secondName, String address, String phone, String metro, String comment, String date, boolean isSuccessfulWindow, ButtonType buttonType) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
        this.metro = metro;
        this.isSuccessfulWindow = isSuccessfulWindow;
        this.comment = comment;
        this.date = date;
        this.buttonType = buttonType;

    }

    @Parameterized.Parameters
    public static Object[][] getPersonalData() {
        return new Object[][]{
                {"Роман", "Мазаев", "Москва", "89870665666", "Черкизовская", "16.02.2020", "Комментарий для курьера №1", true, FIRST},
                {"Иван", "Петров", "Москва", "89870665667", "Сокольники", "10.05.2023", "Комментарий для курьера №2", true, SECOND},
        };
    }


    @Test
    public void registerOrderTest() {
        MainPage mainPage = new MainPage(driver);
        switch (buttonType) {
            case FIRST:
                mainPage.clickOrderButtonFirst();
                break;
            case SECOND:
                mainPage.clickOrderButtonSecond();
                break;
        }

        String successText = new RegisterOrderPage(driver)
                .setInputPersonalData(firstName, secondName, address, phone)
                .selectMetroFromOptions(metro)
                .clickNextButton()
                .setInputPersonalData(date, comment)
                .clickOrderButton()
                .clickConfirmButton()
                .searchSuccessText();
        assertEquals("Текст не совпадает или отсутствует", successText.contains("Заказ оформлен"), isSuccessfulWindow);
    }

}
