package Tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class TestBase {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup(); для др браузера
        //driver = new FirefoxDriver();             для др браузера
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Данные для параметризации заказа
    public static Stream<Arguments> getOrderData() {
        return Stream.of(
                Arguments.of("Артём", "Сидоров", "Бауманская, 15", "89001234567", "25", "Привезти после 18:00"),
                Arguments.of("Мария", "Кузнецова", "Ленинский проспект, 50", "89876543210", "30", "Оставить у двери")
        );
    }
}