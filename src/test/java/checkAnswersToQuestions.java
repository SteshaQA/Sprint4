import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class checkAnswersToQuestions extends BaseTest {

    private final String originalAnswer;
    private final int indexOfQuestion;

    public checkAnswersToQuestions(String originalAnswer, int indexOfQuestion) {
        this.originalAnswer = originalAnswer;
        this.indexOfQuestion = indexOfQuestion;
    }

    @Parameterized.Parameters
    public static Object[] getInputDataAddressField() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Test
    public void checkAnswersToQuestionsTest() {
        mainPage.openPage();
        registerPage.getClickCookieButton();
        mainPage.scrollToQuestion();
        driver.findElement(By.xpath(String.format("//*[@id = 'accordion__heading-%d']", indexOfQuestion))).click();
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[@id = 'accordion__panel-%d']/p", indexOfQuestion))));
        String actualAnswer = driver.findElement(By.xpath(String.format("//*[@id = 'accordion__panel-%d']/p", indexOfQuestion))).getText();
        assertEquals(originalAnswer, actualAnswer);
    }
}
