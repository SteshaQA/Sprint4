package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getWebElement() {
        return driver.findElement(By.cssSelector("img[alt='Not found']"));
    }
}
