package Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import pages.OrderPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest extends TestBase {

    @ParameterizedTest
    @MethodSource("getOrderData")
    @DisplayName("Успешное оформление заказа через кнопку в шапке")
    public void shouldCreateOrderViaHeaderButton(String firstName, String lastName, String address, String phone, String date, String comment) {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.open();
        mainPage.clickOrderButtonHeader();
        orderPage.fillForm(firstName, lastName, address, phone, date, comment);

        assertEquals("Заказ оформлен", orderPage.getSuccessMessage());
    }

    @ParameterizedTest
    @MethodSource("getOrderData")
    @DisplayName("Успешное оформление заказа через кнопку внизу страницы")
    public void shouldCreateOrderViaBottomButton(String firstName, String lastName, String address, String phone, String date, String comment) {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.open();
        mainPage.clickOrderButtonBottom();
        orderPage.fillForm(firstName, lastName, address, phone, date, comment);

        assertEquals("Заказ оформлен", orderPage.getSuccessMessage());
    }
}