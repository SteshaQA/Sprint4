package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class RegisterPage {
    private WebDriver driver;

    private By scooterLogo = By.cssSelector("img[alt='Scooter']");
    private By upOrderButton = By.xpath("//*[@class='Button_Button__ra12g']");
    private By downOrderButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By cookieButton = By.xpath("//*[@class='App_CookieButton__3cvqF']");

    private By nameField = By.cssSelector("input[placeholder = '* Имя']");
    private By surnameField = By.cssSelector("input[placeholder = '* Фамилия']");
    private By addressField = By.cssSelector("input[placeholder = '* Адрес: куда привезти заказ']");
    private By metroStation = By.cssSelector("input[placeholder = '* Станция метро']");
    private By telephoneNumber = By.cssSelector("input[placeholder = '* Телефон: на него позвонит курьер']");
    private By NextButton = By.xpath("//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By orderTimeField = By.cssSelector("input[placeholder = '* Когда привезти самокат']");
    private By rentTimeField = By.xpath("//*[text() = '* Срок аренды']");
    private By orderButton = By.xpath("//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By verifyButton = By.xpath("//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    private By errorName = By.xpath("//*[text() = 'Введите корректное имя']");
    private By errorSurname = By.xpath("//*[text() = 'Введите корректную фамилию']");
    private By errorAddress = By.xpath("//*[text() = 'Введите корректный адрес']");
    private By errorTelephone = By.xpath("//*[text() = 'Введите корректный номер']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //переходим на страницу заказа, нажимает на лого "Самоката", должна отобразиться главная страница "Самоката"

    public void getClickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    //Переходим в форму заказа по вверхней кнопке
    public void getClickUpOrderButton() {
        driver.findElement(upOrderButton).click();
    }

    //Чтобы кликнуть на нижнюю кнопку заказа, кликаем сначала на кнопку принятия куков "Да все привыкли"

    public void getClickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    //Переходим в форму заказа по нижней кнопке
    public void getClickDownOrderButton() {
        driver.findElement(downOrderButton).click();
    }

    public void fillNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void fillAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void fillMetroStation(String metroStationListOption) {

        driver.findElement(metroStation).click();
        driver.findElement(By.xpath(String.format("//div[text() = '%s']", metroStationListOption))).click();
    }

    public void fillTelephoneNumber(String number) {
        driver.findElement(telephoneNumber).sendKeys(number);
    }

    public void clickNextButton() {
        driver.findElement(NextButton).click();
    }

    public void waitOfOrderTimeField() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(orderTimeField));
    }

    //вторая страница заказа
    public void getOrderDateTime(String dateTime) {
        driver.findElement(orderTimeField).sendKeys(dateTime + Keys.ENTER);
        //driver.findElement(orderDateTime).click();
    }

    public void getRentTime(String rentTime) {
        driver.findElement(rentTimeField).click();
        driver.findElement(By.xpath(String.format("//*[text() = '%s']", rentTime))).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickVerifyButton() {
        driver.findElement(verifyButton).click();
    }

    public String getVerifyOrder() {
        WebElement verifyButtonText = driver.findElement(By.xpath("//*[@class ='Order_ModalHeader__3FDaJ']"));
        return verifyButtonText.getText();
    }

    public WebElement getErrorName() {
       return driver.findElement(errorName);
    }

    public WebElement getErrorSurname() {
        return driver.findElement(errorSurname);
    }

    public WebElement getErrorAddress() {
        return driver.findElement(errorAddress);
    }

    public WebElement getErrorTelephone() {
        return driver.findElement(errorTelephone);
    }
}
