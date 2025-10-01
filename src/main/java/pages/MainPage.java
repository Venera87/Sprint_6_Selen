package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By orderButtonHeader = By.xpath("(//button[contains(@class, 'Button_Button')])[1]");
    private final By orderButtonBottom = By.xpath("(//button[contains(@class, 'Button_Button')])[last()]");
    private final By cookieButton = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Закрыть куки, если появляется
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
        } catch (Exception ignored) {
            // Если кнопка куки не появилась — игнорируем
        }
    }

    public void clickOrderButtonHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonHeader)).click();
    }

    public void clickOrderButtonBottom() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonBottom)).click();
    }

    public void clickQuestion(int index) {
        By question = By.id("accordion__heading-" + index);
        wait.until(ExpectedConditions.elementToBeClickable(question)).click();
    }

    public String getAnswerText(int index) {
        By answer = By.id("accordion__panel-" + index);
        wait.until(ExpectedConditions.visibilityOfElementLocated(answer));
        return driver.findElement(answer).getText().trim();
    }
}