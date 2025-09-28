package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // === Локаторы формы ===

    // Первый экран
    private final By firstNameField = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath("//input[@placeholder='* Станция метро']");
    private final By metroOption = By.xpath("//div[@class='select-search__select']//li[1]");
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    // Второй экран
    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentPeriod = By.className("Dropdown-control");
    private final By rentOption = By.xpath("//div[text()='двое суток']");
    private final By colorBlack = By.id("black");
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // Модалки
    private final By confirmButton = By.xpath("//button[text()='Да']");
    private final By successHeader = By.className("Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillForm(String firstName, String lastName, String address, String phone, String date, String comment) {
        // Первый экран
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(metroOption));
        driver.findElement(metroOption).click();
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();

        // Второй экран
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(rentPeriod).click();
        driver.findElement(rentOption).click();
        driver.findElement(colorBlack).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButton).click();

        // Подтверждение
        driver.findElement(confirmButton).click();
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successHeader));
        return driver.findElement(successHeader).getText().trim();
    }
}
