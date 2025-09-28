package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // === Элементы главной страницы ===

    // Кнопка "Заказать" в шапке
    // Локатор: .Button_Button__ra12g (первая на странице)
    private final By orderButtonHeader = By.xpath("(//button[contains(@class, 'Button_Button')])[1]");

    // Кнопка "Заказать" внизу (в блоке "Как это работает")
    // Локатор: последняя кнопка с таким классом
    private final By orderButtonBottom = By.xpath("(//button[contains(@class, 'Button_Button')])[last()]");

    // Вопросы в разделе "Вопросы о важном"
    // Общий шаблон: //div[@id='accordion__heading-{index}']
    // Ответы: //div[@id='accordion__panel-{index}']

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Закрыть куки, если есть
        try {
            driver.findElement(By.id("rcc-confirm-button")).click();
        } catch (Exception ignored) {}
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void clickQuestion(int index) {
        By question = By.id("accordion__heading-" + index);
        driver.findElement(question).click();
    }

    public String getAnswerText(int index) {
        By answer = By.id("accordion__panel-" + index);
        wait.until(ExpectedConditions.visibilityOfElementLocated(answer));
        return driver.findElement(answer).getText().trim();
    }
}
