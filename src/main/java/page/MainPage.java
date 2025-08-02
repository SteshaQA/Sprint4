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
}
