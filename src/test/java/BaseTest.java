import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.MainPage;
import page.NewWindowPage;
import page.OrderPage;
import page.RegisterPage;

public class BaseTest {

    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;
    RegisterPage registerPage;
    NewWindowPage newWindowPage;
    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        registerPage = new RegisterPage(driver);
        newWindowPage = new NewWindowPage(driver);

    }

    @After
    public void tearDown(){
       driver.quit();
    }
}
