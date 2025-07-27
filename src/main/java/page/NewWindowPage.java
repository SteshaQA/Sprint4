package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class NewWindowPage {
    private WebDriver driver;
    public  Set<String> allWindowsBeforeClick;
    public  Set<String> allWindowsAfterClick;

    public NewWindowPage(WebDriver driver) {
        this.driver = driver;
    }

    //Получаем  дескрипторы всех окон до клика на логотип Яндекса
    public Set<String> getAllWindowsBeforeClick(){
        allWindowsBeforeClick = driver.getWindowHandles();
        return allWindowsBeforeClick;
    }

    //Ожидаем загрузку нового окна
    public void waitForNewWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public Set<String> getAllWindowsAfterClick(){
        allWindowsAfterClick = driver.getWindowHandles();
        return allWindowsAfterClick;
    }

    //Получаем новое окно и переключаемся на него
    public void getNewWindow(){
        for(String window : allWindowsAfterClick) {
            if (!window.equals(allWindowsBeforeClick)) {
                driver.switchTo().window(window);
            }
        }
    }
}