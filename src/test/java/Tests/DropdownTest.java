package Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DropdownTest extends TestBase {

    @Test
    @DisplayName("При клике на вопрос в разделе 'Вопросы о важном' отображается соответствующий ответ")
    public void shouldShowAnswerAfterClickingQuestion() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        mainPage.clickQuestion(0); // первый вопрос
        String answer = mainPage.getAnswerText(0);

        assertFalse(answer.isEmpty(), "Ответ не отображается");
    }
}