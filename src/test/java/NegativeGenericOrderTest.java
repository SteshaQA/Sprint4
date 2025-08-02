import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NegativeGenericOrderTest {
    //Ошибки для поля "Имя"
    @RunWith(Parameterized.class)
    public static class NegativeTestForNameField extends BaseTest {

        private final String incorrectNameInput;
        private final boolean expected;

        public NegativeTestForNameField(String incorrectNameInput, boolean expected) {
            this.incorrectNameInput = incorrectNameInput;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[] getInputDataNameField() {
            return new Object[][]{
                    {"Кира", false},
                    {"", true},       //ничего не вводим(обязательность заполнения) (невалидно)
                    {"О", true},      //ввод 1 символа (невалидно)
                    {"Ол", false},    //ввод 2 символов (валидно)
                    {"Оля", false},   //ввод 3 символов (валидно)
                    {"ОляОляО", false},    //ввод 7 символов (валидно)
                    {"ОляОляОляОляОл", false},    //ввод 14 символов (валидно)
                    {"ОляОляОляОляОля", false},    //ввод 15 символов (валидно)
                    {"ОляОляОляОляОляО", true},     //ввод 16 символов (невалидно)
                    {"ОляОляОляОляОляОл", true},     //ввод 17 символов (невалидно)
                    {"ОляОляОляОляОляОляОля", true},     //ввод 21 символов (невалидно)
                    {"Оля1", true},   //ввод числа (невалидно)
                    {"Оля@", true},   //ввод спец. символа (невалидно)
                    {" Оля", true},   //ввод пробела в начале строки (невалидно)
                    {"Анна Мария", false}, //ввод пробела в середине строки (валидно)
                    {"Оля ", true},   //ввод пробела в конце строки (невалидно)
                    {"Оля+", true},   //ввод математических символов (невалидно)
                    {"Оля!", true},   //ввод символов пунктуации - кроме тире/дефиса (невалидно)
                    {"Анна-Мария", false},   //ввод тире/дефиса (валидно)
                    {"Keanu", false},   //ввод английских букв (валидно)
            };
        }

        @Test
        public void fillOrderPage() {
            mainPage.openPage();
            registerPage.getClickCookieButton();
            registerPage.getClickUpOrderButton();
            registerPage.getClickDownOrderButton();
            registerPage.fillNameField(incorrectNameInput);
            registerPage.clickNextButton();

            WebElement errorNameMessage = registerPage.getErrorName();
            assertEquals(expected, errorNameMessage.isDisplayed());
        }
    }
    //ошибки для поля "Фамилия"
    @RunWith(Parameterized.class)
    public static class NegativeTestForSurnameField extends BaseTest {

        private final String incorrectSurnameInput;
        private final boolean expected;

        public NegativeTestForSurnameField(String incorrectSurnameInput, boolean expected) {
            this.incorrectSurnameInput = incorrectSurnameInput;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[] getInputDataSurnameField() {
            return new Object[][]{
                    {"Петров", false},
                    {"", true},       //ничего не вводим(обязательность заполнения) (невалидно)
                    {"П", true},      //ввод 1 символа (невалидно)
                    {"Пе", false},    //ввод 2 символов (валидно)
                    {"Пет", false},   //ввод 3 символов (валидно)
                    {"ПетровПетровПет", false},    //ввод 15 символов (валидно)
                    {"ПетровПетровПетровПетровПетро", false},    //ввод 29 символов (валидно) допустим что максимум символов для ввода фамилии - 30
                    {"ПетровПетровПетровПетровПетров", false},    //ввод 30 символов (валидно) допустим что максимум символов для ввода фамилии - 30
                    {"ПетровПетровПетровПетровПетровП", true},    //ввод 31 символов (невалидно) допустим что максимум символов для ввода фамилии - 30
                    {"ПетровПетровПетровПетровПетровПе", true},     //ввод 32 символов (невалидно) допустим что максимум символов для ввода фамилии - 30
                    {"ПетровПетровПетровПетровПетровПетро", true},     //ввод 35 символов (невалидно) допустим что максимум символов для ввода фамилии - 30
                    {"Петров1", true},   //ввод числа (невалидно)
                    {"Петров@", true},   //ввод спец. символа (невалидно)
                    {" Петров", true},   //ввод пробела в начале строки (невалидно)
                    {"Петров Сидоров", false}, //ввод пробела в середине строки (валидно)
                    {"Петров ", true},   //ввод пробела в конце строки (невалидно)
                    {"Петров+", true},   //ввод математических символов (невалидно)
                    {"Петров!", true},   //ввод символов пунктуации - кроме тире/дефиса (невалидно)
                    {"Петров-Сидоров", false},   //ввод тире/дефиса (валидно)
                    {"Reeves", false},   //ввод английских букв (валидно)
            };
        }

        @Test
        public void fillOrderPage() {
            mainPage.openPage();
            registerPage.getClickCookieButton();
            registerPage.getClickUpOrderButton();
            registerPage.getClickDownOrderButton();
            registerPage.fillSurnameField(incorrectSurnameInput);
            registerPage.clickNextButton();

            WebElement errorSurnameMessage = registerPage.getErrorSurname();
            assertEquals(expected, errorSurnameMessage.isDisplayed());
        }
    }

    //ошибки для поля адрес
    @RunWith(Parameterized.class)
    public static class NegativeTestForAddressField extends BaseTest {

        private final String incorrectAddressInput;
        private final boolean expected;

        public NegativeTestForAddressField(String incorrectAddressInput, boolean expected) {
            this.incorrectAddressInput = incorrectAddressInput;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[] getInputDataAddressField() {
            return new Object[][]{
                    {"проспект Вернадского, д.51, кв.3", false},
                    {"", true},       //ничего не вводим(обязательность заполнения) (невалидно)
                    {"пр", true},    //ввод 2 символов (невалидно)
                    {"про", true},      //ввод 3 символа (невалидно)
                    {"прос", true},    //ввод 4 символов (невалидно)
                    {"просп", false},   //ввод 5 символов (валидно)
                    {"проспе", false},    //ввод 6 символов (валидно)
                    {"проспектВерн", false},    //ввод 12 символов (валидно)
                    {"проспектВернадскогопроспектВернадскогопроспектВе", false},    //ввод 48 символов (валидно) допустим что максимум символов для ввода фамилии - 30
                    {"проспектВернадскогопроспектВернадскогопроспектВер", false},    //ввод 49 символов (валидно) допустим что максимум символов для ввода фамилии - 30
                    {"проспектВернадскогопроспектВернадскогопроспектВерн", true},    //ввод 50 символов (невалидно) допустим что максимум символов для ввода фамилии - 30
                    {"проспектВернадскогопроспектВернадскогопроспектВерна", true},     //ввод 51 символов (невалидно) допустим что максимум символов для ввода фамилии - 30
                    {"проспектВернадскогопроспектВернадскогопроспектВернадскогопро", true},     //ввод 60 символов (невалидно) допустим что максимум символов для ввода фамилии - 30
                    {"проспект Вернадского 52", false},   //ввод числа (валидно)
                    {"проспект Вернадского@", true},   //ввод спец. символа (невалидно)
                    {" проспект Вернадского 52", true},   //ввод пробела в начале строки (невалидно)
                    {"проспект Вернадского 52 ", true},   //ввод пробела в конце строки (невалидно)
                    {"проспект Вернадского 52+", true},   //ввод математических символов (невалидно)
                    {"проспект Вернадского 52!", true},   //ввод символов пунктуации - кроме тире/дефиса, точки, запятой (невалидно)
                    {"1-й Останкинский переулок", false},   //ввод тире/дефиса (валидно)
                    {"проспект Вернадского д.51", false},   //ввод точки (валидно)
                    {"проспект Вернадского, д.51", false},   //ввод запятой (валидно)
                    {"Tverskaya ulitsa", false},   //ввод английских букв (валидно)
            };
        }

        @Test
        public void fillOrderPage() {
            mainPage.openPage();
            registerPage.getClickCookieButton();
            registerPage.getClickUpOrderButton();
            registerPage.getClickDownOrderButton();
            registerPage.fillAddressField(incorrectAddressInput);
            registerPage.clickNextButton();

            WebElement errorAddressMessage = registerPage.getErrorAddress();
            assertEquals(expected, errorAddressMessage.isDisplayed());
        }
    }

    //ошибки для поля телефон
    @RunWith(Parameterized.class)
    public static class NegativeTestForTelephoneField extends BaseTest {

        private final String incorrectTelephoneInput;
        private final boolean expected;

        public NegativeTestForTelephoneField(String incorrectTelephoneInput, boolean expected) {
            this.incorrectTelephoneInput = incorrectTelephoneInput;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[] getInputDataTelephoneField() {
            return new Object[][]{
                    //лучше конечно дать подсказку пользователю в каком формате система ждет от него ввода номера телефона,но судя по реализации только цифры в количестве от 11 и до 13(вкл.) и знак плюса
                    {"89681111111", false},
                    {"", true},       //ничего не вводим(обязательность заполнения) (невалидно)
                    {"8", true},      //ввод 1 символа (невалидно)
                    {"89", true},    //ввод 2 символов (невалидно)
                    {"8968111", true},   //ввод 7 символов (невалидно)
                    {"896811111", true},    //ввод 9 символов (невалидно)
                    {"8968111111", true},    //ввод 10 символов (невалидно)
                    {"89681111111", false},    //ввод 11 символов (валидно)
                    {"896811111111", false},    //ввод 12 символов (валидно)
                    {"8968111111111", false},     //ввод 13 символов (валидно)
                    {"89681111111111", true},     //ввод 14 символов (невалидно)
                    {"896811111111111", true},     //ввод 15 символов (невалидно)
                    {"89681111111a", true},   //ввод букв (невалидно)
                    {"89681111111@", true},   //ввод спец. символа (невалидно)
                    {" 89681111111", true},   //ввод пробела в начале строки (невалидно)
                    {"8968 1111111", true}, //ввод пробела в середине строки (невалидно)
                    {"89681111111 ", true},   //ввод пробела в конце строки (невалидно)
                    {"89681111111-", true},   //ввод математических символов, кроме плюса в начале (невалидно)
                    {"89681111111!", true},   //ввод символов пунктуации (невалидно)
                    {"8-9681111111", true},   //ввод тире/дефиса (невалидно)
                    {"89681111111R", true},   //ввод английских букв (невалидно)
                    {"+79681111111", false},   //ввод + в начале строки  (валидно)
                    {"7968+1111111", true},   //ввод + в середине строки  (невалидно)
                    {"7968.1111111", true},   //ввод дробного числа с точкой (невалидно)
                    {"7968,1111111", true},   //ввод дробного числа с запятой (невалидно)
                    {"7(968)1111111", true},   //ввод скобок (невалидно)
            };
        }

        @Test
        public void fillOrderPage() {
            mainPage.openPage();
            registerPage.getClickCookieButton();
            registerPage.getClickUpOrderButton();
            registerPage.getClickDownOrderButton();
            registerPage.fillTelephoneNumber(incorrectTelephoneInput);
            registerPage.clickNextButton();

            WebElement errorTelephoneMessage = registerPage.getErrorTelephone();
            assertEquals(expected, errorTelephoneMessage.isDisplayed());
        }
    }
}