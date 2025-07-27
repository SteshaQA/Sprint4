import org.junit.Test;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UiTest extends BaseTest {

    @Test
    //Ввод неправильного номера заказа, ведёт на страницу статуса заказа, где написано, что такого заказа нет
    public void errorStatusNumberTest() {
        mainPage.openPage();
        mainPage.waitOfVisibilityStatusButton();
        mainPage.clickStatusButton();
        mainPage.waitOfVisibilityInputFieldForStatusNumber();
        mainPage.setStatusOrder("000");
        mainPage.clickGoButton();
        mainPage.waitOfErrorImg();

        WebElement errorImg = orderPage.getWebElement();
        assertTrue("Сообщение об ошибке не отображается", errorImg.isDisplayed());
    }

    @Test
    //Если нажать на логотип Самоката, попадёшь на главную страницу Самоката
    public void clickLogoScooterOpenMainPage(){
        mainPage.openPage();
        registerPage.getClickUpOrderButton();
        registerPage.getClickScooterLogo();
        assertEquals(mainPage.URL, driver.getCurrentUrl());
    }

    @Test
    //Если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    public void clickLogoYandexOpenMainPage(){
        mainPage.openPage();
        newWindowPage.getAllWindowsBeforeClick();
        mainPage.getClickYandexLogo();
        newWindowPage.waitForNewWindow();
        newWindowPage.getAllWindowsAfterClick();
        newWindowPage.getNewWindow();
        assertEquals("https://ya.ru/", driver.getCurrentUrl());
    }

    @Test
    public void checkAnswersToQuestions(){
        mainPage.openPage();
        registerPage.getClickCookieButton();
        mainPage.scrollToQuestion();

        assertEquals("Отображаемый текст не соответствует первоначальному", mainPage.answers_original, mainPage.getAnswersToQuestionsList());
    }
}

