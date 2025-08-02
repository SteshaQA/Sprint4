import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class PositiveGenericOrderTestOrderButton extends BaseTest {

    private final String nameInput;
    private final String surnameInput;
    private final String addressInput;
    private final String metroStationInput;
    private final String numberInput;
    private final String dateInput;
    private final String rentInput;
    private final boolean expected;

    public PositiveGenericOrderTestOrderButton(String nameInput, String surnameInput, String addressInput, String metroStationInput, String numberInput, String dateInput, String rentInput, boolean expected) {
        this.nameInput = nameInput;
        this.surnameInput = surnameInput;
        this.addressInput = addressInput;
        this.metroStationInput = metroStationInput;
        this.numberInput = numberInput;
        this.dateInput = dateInput;
        this.rentInput = rentInput;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getInputData() {
        return new Object[][]{
                {"Настя", "Степанова", "Проспект Вернадского, д.42, кв.50", "Проспект Вернадского", "89681111111", "01.08.2025", "четверо суток", true},
                {"Иван", "Иванов", "Ленинский проспект, д.77, кв.75", "Черкизовская", "89103333333", "21.08.2025", "сутки", true},
        };
    }

    //заказ по верхней кнопке
    @Test
    public void fillOrderPageUpOrderButton() {
        mainPage.openPage();
        registerPage.getClickCookieButton();
        registerPage.getClickUpOrderButton();
        registerPage.fillNameField(nameInput);
        registerPage.fillSurnameField(surnameInput);
        registerPage.fillAddressField(addressInput);
        registerPage.fillMetroStation(metroStationInput);
        registerPage.fillTelephoneNumber(numberInput);
        registerPage.clickNextButton();
        registerPage.waitOfOrderTimeField();
        registerPage.getOrderDateTime(dateInput);
        registerPage.getRentTime(rentInput);
        registerPage.clickOrderButton();
        registerPage.clickVerifyButton();

        String verifyText = registerPage.getVerifyOrder();
        assertEquals(expected, verifyText.startsWith("Заказ оформлен"));
    }

    @Test
    public void fillOrderPageDownOrderButton() {
        mainPage.openPage();
        registerPage.getClickCookieButton();
        registerPage.getClickDownOrderButton();
        registerPage.fillNameField(nameInput);
        registerPage.fillSurnameField(surnameInput);
        registerPage.fillAddressField(addressInput);
        registerPage.fillMetroStation(metroStationInput);
        registerPage.fillTelephoneNumber(numberInput);
        registerPage.clickNextButton();
        registerPage.waitOfOrderTimeField();
        registerPage.getOrderDateTime(dateInput);
        registerPage.getRentTime(rentInput);
        registerPage.clickOrderButton();
        registerPage.clickVerifyButton();

        String verifyText = registerPage.getVerifyOrder();
        assertEquals(expected, verifyText.startsWith("Заказ оформлен"));
    }
}
