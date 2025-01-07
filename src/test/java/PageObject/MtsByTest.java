package PageObject;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MtsByTest {
    WebDriver driver;
    MainPageReplenish mainPageLogin;

    // Переменные для заполнения формы на главной
    String phone = "297777777";
    String summ = "499";
    String email = "test@test.ru";

    // Инициализация драйвера, поткрытие сайта, принятие кук в каждом методе
    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        mainPageLogin = new MainPageReplenish(driver);
        driver.get("https://www.mts.by/");
        mainPageLogin.acceptCookies();
    }

    @Test
    @Order(1)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Главная: Заголовок модуля оплаты")
    public void testTitle() {
        assertEquals("Онлайн пополнение\nбез комиссии", mainPageLogin.getTitleText(), "Текст заголовка не совпадает");
    }

    @Test
    @Order(2)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Главная: Иконки оплаты")
    public void testLogos() {
        assertTrue(mainPageLogin.getElement(By.xpath("//img[contains(@src, 'visa') and @alt='Visa']")).isDisplayed(), "Логотип Visa не отображается");
        assertTrue(mainPageLogin.getElement(By.xpath("//img[contains(@src, 'visa-verified') and @alt='Verified By Visa']")).isDisplayed(), "Логотип VerifiedVisa не отображается");
        assertTrue(mainPageLogin.getElement(By.xpath("//img[contains(@src, 'mastercard') and @alt='MasterCard']")).isDisplayed(), "Логотип MasterCard не отображается");
        assertTrue(mainPageLogin.getElement(By.xpath("//img[contains(@src, 'mastercard-secure') and @alt='MasterCard Secure Code']")).isDisplayed(), "Логотип MasterCardSecure не отображается");
        assertTrue(mainPageLogin.getElement(By.xpath("//img[contains(@src, 'belkart') and @alt='Белкарт']")).isDisplayed(), "Логотип Belkart не отображается");
    }

    @Test
    @Order(3)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Главная: Подробнее о сервисе")
    public void testServiceLink() {
        assertEquals("Подробнее о сервисе", mainPageLogin.getServiceLink().getText(), "Текст ссылки не совпадает");
        mainPageLogin.getServiceLink().click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(), "Открывшаяся ссылка не совпадает с ожидаемой");
        ScreenshotMaker.makeScreenshot(driver, "Страница подробностей о сервисе.webp");
    }


    // 1. ПРОВЕРИТЬ НАДПИСИ В НЕЗАПОЛНЕННЫХ ПОЛЯХ КАЖДОГО ВАРИАНТА ОПЛАТЫ УСЛУГ: УСЛУГИ СВЯЗИ, ДОМАШНИЙ ИНТЕРНЕТ, РАССРОЧКА, ЗАДОЛЖЕННОСТЬ;

    @Test
    @Order(4)
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Главная: Текст незаполненных полей \"Услуги связи\"")
    public void testFormText1() {
        //Следующая строчка закоментирована, поскольку мы сразу находимся на вкладке дропдауна "Услуги связи". Это может измениться в будущем, поэтому сохранено
        //mainPageLogin.headerButton().click(); mainPageLogin.connectionButton().click();

        assertEquals("Номер телефона", mainPageLogin.getPhoneNumberFieldText(), "Текст не совпадает");
        assertEquals("Сумма", mainPageLogin.getSumFieldText(), "Текст не совпадает");
        assertEquals("E-mail для отправки чека", mainPageLogin.getEmailFieldText(), "Текст не совпадает");
    }

    @Test
    @Order(5)
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Главная: Текст незаполненных полей \"Домашний интернет\"")
    public void testFormText2() {
        mainPageLogin.headerButton().click();
        mainPageLogin.homeInternetButton().click();
        assertEquals("Номер абонента", mainPageLogin.getInternetPhoneFieldText(), "Текст не совпадает");
        assertEquals("Сумма", mainPageLogin.getSumFieldText(), "Текст не совпадает");
        assertEquals("E-mail для отправки чека", mainPageLogin.getEmailFieldText(), "Текст не совпадает");
    }

    @Test
    @Order(6)
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Главная: Текст незаполненных полей \"Задолженность\"")
    public void testFormText3() {
        mainPageLogin.headerButton().click();
        mainPageLogin.instalmentPlanButton().click();
        assertEquals("Номер счета на 44", mainPageLogin.setScoreInstalmentFieldText(), "Текст не совпадает");
        assertEquals("Сумма", mainPageLogin.getSumFieldText(), "Текст не совпадает");
        assertEquals("E-mail для отправки чека", mainPageLogin.getEmailFieldText(), "Текст не совпадает");
    }

    @Test
    @Order(7)
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Главная: Текст незаполненных полей \"Рассрочка\"")
    public void testFormText4() {
        mainPageLogin.headerButton().click();
        mainPageLogin.debtButton().click();
        assertEquals("Номер счета на 2073", mainPageLogin.getScoreArrearsFieldText(), "Текст не совпадает");
        assertEquals("Сумма", mainPageLogin.getSumFieldText(), "Текст не совпадает");
        assertEquals("E-mail для отправки чека", mainPageLogin.getEmailFieldText(), "Текст не совпадает");
    }

    @Test
    @Order(8)
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Главная: Заполнение полей и кнопка \"Продолжить\"")
    public void testFormFill() {
        mainPageLogin.fillForm(phone, summ, email);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(mainPageLogin.getContinueButton()));
        assertTrue(mainPageLogin.getContinueButton().isDisplayed(), "Кнопка 'Продолжить' не отображается");
        mainPageLogin.getContinueButton().click();
        By iFrame = By.cssSelector(".bepaid-iframe");
        ScreenshotMaker.makeScreenshot(driver, "Заполнение данных.webp");
        wait.until(ExpectedConditions.visibilityOfElementLocated(iFrame));
        driver.switchTo().frame(driver.findElement(iFrame));

    }

    /*
    2. В ОКНЕ ОПЛАТЫ ПРОВЕРИТЬ КОРРЕКТНОСТЬ ОТОБРАЖЕНИЯ СУММЫ (В ТОМ ЧИСЛЕ НА КНОПКЕ), НОМЕРА ТЕЛЕФОНА,
    А ТАКЖЕ НАДПИСЕЙ В НЕЗАПОЛНЕННЫХ ПОЛЯХ ДЛЯ ВВОДА РЕКВИЗИТОВ КАРТЫ, НАЛИЧИЕ ИКОНОК ПЛАТЁЖНЫХ СИСТЕМ.
    */

    @Test
    @Order(9)
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("iFrame оплаты. Тесты текста: незаполненных полей, суммы, номера")
    public void testFormText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Предыдущий метод идентичен до нашего теста, используем его
        testFormFill();

        // Методы проверяют только часть совпадений (цифру), чтобы в случае смены сопроводительного текста, тест не падал
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__cost span")));
        assertTrue(mainPageLogin.getFrameTitleSumText().contains(summ), "Сумма не соответствует заявленной:" + summ);
        assertTrue(mainPageLogin.getFrameButtonSumText().contains(summ), "Сумма не соответствует заявленной:" + summ);
        assertTrue(mainPageLogin.getFramePayDescriptionText().contains(phone), "Сумма не соответствует заявленной:" + phone);
        ScreenshotMaker.makeScreenshot(driver, "Суммы заявки.webp");

        // Следующий метод проверяет надписи на всех полях сразу. Выбрал этот способ, так как его еще не реализовывал
        assertEquals("Номер карты\n" + "Срок действия\n" + "CVC\n" + "Имя держателя (как на карте)", mainPageLogin.getFrameCredentialsText(), "Надписи на полях не соответствуют заявленным");
        driver.switchTo().defaultContent();
    }

    @Test
    @Epic("Какой-то эпик")
    @Order(10)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("iFrame оплаты. Тесты наличия и отображения иконок")
    public void testFormLogos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Предыдущий метод идентичен до нашего теста, используем его
        testFormFill();

        // Ждем загрузки элементов iFrame. Не знаю насколько правильно выбирать любой локатор на iFrame, но единого не нашел. Локатор самого iFrame не гарантирует немедленный доступ к его элементам и может уронить тест, проверил
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__cost span")));

        // Получаем логотип через метод и селектор
        assertTrue(mainPageLogin.getElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/visa-system.svg']")).isDisplayed(), "Логотип Visa не отображается");
        assertTrue(mainPageLogin.getElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/mastercard-system.svg']")).isDisplayed(), "Логотип MasterCard не отображается");
        assertTrue(mainPageLogin.getElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/belkart-system.svg']")).isDisplayed(), "Логотип Belkart не отображается");
        assertTrue(mainPageLogin.getElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/maestro-system.svg']")).isDisplayed(), "Логотип Мир не отображается");
        ScreenshotMaker.makeScreenshot(driver, "Логотипы оплаты в iFrame.webp");
        driver.switchTo().defaultContent();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}