package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

public class MainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    private By goButton = By.xpath("//*[text() = 'Go!']");
    private By statusField = By.cssSelector("input[placeholder='Введите номер заказа']");
    private By statusButton = By.className("Header_Link__1TAG7");
    private By yandexLogo = By.cssSelector("img[alt='Yandex']");

    public static final List<String> answers_original = new ArrayList<>(Arrays.asList(
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    ));

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    public void setStatusOrder(String number) {
        driver.findElement(statusField).sendKeys(number);
    }

    public void clickStatusButton() {
        driver.findElement(statusButton).click();
    }

    public void openPage() {
        driver.get(URL);
    }

    public void waitOfErrorImg() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Not found']")));
    }

    public void waitOfVisibilityInputFieldForStatusNumber() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Введите номер заказа']")));
    }

    public void waitOfVisibilityStatusButton() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Link__1TAG7")));
    }

    public void getClickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    //Отображение соответствующих ответов на вопросы
    public void scrollToQuestion() {
        WebElement question = driver.findElement(By.xpath("//*[@id = 'accordion__heading-0']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
    }

    public ArrayList<String> getAnswersToQuestionsList() {
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            driver.findElement(By.xpath(String.format("//*[@id = 'accordion__heading-%d']", i))).click();
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[@id = 'accordion__panel-%d']/p", i))));
            String answer = driver.findElement(By.xpath(String.format("//*[@id = 'accordion__panel-%d']/p", i))).getText();
            System.out.println(i + answer);
            answers.add(answer);
        }
        return answers;
    }
}
