
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class MtsByTest {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setup() {
        //Открываем главную перед каждым тестом
        driver.get("https://www.mts.by/");

        // Поскольку сайт предлагает принять куки, которые могут не сохраняться, перед каждым тестом не лишним будет принять их, чтобы избежать ошибок, не связанных с шагами действий теста
        try {
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement cookie = wait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cookie-agree")));
            cookie.click();
            System.out.println("Куки приняты");
        } catch (Exception e) {
            System.out.println("Куки не появились");
        }
    }

    //1. ПРОВЕРИТЬ НАЗВАНИЕ УКАЗАННОГО БЛОКА
    @Test
    @Order(1)
    @DisplayName("Заголовок модуля оплаты")
    public void h2 (){
        WebElement title = driver.findElement(By.xpath("//div[@class='col-12 col-xl-8']//h2[1]"));
        title.getText();
        assertEquals("Онлайн пополнение\n" +"без комиссии", title.getText(), "Текст не совпал с ожидаемым");
        System.out.println("Проверка текста успешна");
    }

    //2. ПРОВЕРИТЬ НАЛИЧИЕ ЛОГОТИПОВ ПЛАТЁЖНЫХ СИСТЕМ
    @Test
    @Order(2)
    @DisplayName("Иконки оплаты")
    public void logosAvailability() {
        WebElement logoVisa = driver.findElement(By.xpath ("//img[contains(@src, 'visa') and @alt='Visa']"));
        assertTrue(logoVisa.isDisplayed(), "Логотип Visa не отображается");
        System.out.println("Логотип Visa отображается");

        WebElement logoVerifiedVisa = driver.findElement(By.xpath ("//img[contains(@src, 'visa-verified') and @alt='Verified By Visa']"));
        assertTrue(logoVerifiedVisa.isDisplayed(), "Логотип VerifiedVisa не отображается");
        System.out.println("Логотип VerifiedVisa отображается");

        WebElement logoMasterCard = driver.findElement(By.xpath ("//img[contains(@src, 'mastercard') and @alt='MasterCard']"));
        assertTrue(logoMasterCard.isDisplayed(), "Логотип MasterCard не отображается");
        System.out.println("Логотип MasterCard отображается");

        WebElement logoMasterCardSecure = driver.findElement(By.xpath ("//img[contains(@src, 'mastercard-secure') and @alt='MasterCard Secure Code']"));
        assertTrue(logoMasterCardSecure.isDisplayed(), "Логотип MasterCardSecure не отображается");
        System.out.println("Логотип MasterCardSecure отображается");

        WebElement logoBelkart = driver.findElement(By.xpath ("//img[contains(@src, 'belkart') and @alt='Белкарт']"));
        assertTrue(logoBelkart.isDisplayed(), "Логотип Belkart не отображается");
        System.out.println("Логотип Belkart отображается");
    }


    //3. ПРОВЕРИТЬ РАБОТУ ССЫЛКИ «ПОДРОБНЕЕ О СЕРВИСЕ»
    @Test
    @Order(3)
    @DisplayName("Подробнее о сервисе")
    public void serviceLink (){
        WebElement serviceLink = driver.findElement(By.xpath("//a[contains(text(),'Подробнее о сервисе')]"));
        serviceLink.getText();
        assertEquals("Подробнее о сервисе", serviceLink.getText(), "Текст не совпадает с заявленным");
        System.out.println("Текст совпадает с заявленным");
        serviceLink.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(), "Открывшаяся ссылка не совпадает с заявленной");
        System.out.println("Открывается корректная ссылка");
    }


    /*
    4. ЗАПОЛНИТЬ ПОЛЯ И ПРОВЕРИТЬ РАБОТУ КНОПКИ
    «ПРОДОЛЖИТЬ» (ПРОВЕРЯЕМ ТОЛЬКО ВАРИАНТ «УСЛУГИ
    СВЯЗИ», НОМЕР ДЛЯ ТЕСТА 297777777
    */
    @Test
    @Order(4)
    @DisplayName("Заполнение полей и кнопка \"Продолжить\"")
    public void communicationServices (){
        WebElement phoneNumber = driver.findElement(By.id("connection-phone"));
        WebElement summ = driver.findElement(By.id("connection-sum"));
        WebElement email = driver.findElement(By.id("connection-email"));
        WebElement submit = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]"));
        System.out.println("Все элементы найдены\n");

        phoneNumber.sendKeys("297777777");
        System.out.println("Номер телефона заполнен");
        summ.sendKeys("499");
        System.out.println("Сумма заполнена");
        email.sendKeys("test@test.ru");
        System.out.println("Е-mail заполнен\n");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        assertTrue(submit.isDisplayed(), "Кнопка \"Продолжить\" не видна на странице");
        System.out.println("Кнопка Продолжить видна и кликабельна");
        submit.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-iframe")));
        System.out.println("iFrame найден");

        driver.switchTo().frame(driver.findElement(By.cssSelector(".bepaid-iframe")));
        // Какие-то тесты во фрейме
        driver.switchTo().defaultContent();
    }

    @AfterEach
    public void close() {
        driver.quit();
    }
}















