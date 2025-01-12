package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// ПЕРЕВЕСТИ РАНЕЕ НАПИСАННЫЙ ТЕСТ НА ИСПОЛЬЗОВАНИЕ ПАТТЕРНА PageObject

public class MainPageReplenish {
    WebDriver driver;

    /// ЛОКАТОРЫ

    //Куки
    private By cookieButton = By.cssSelector("#cookie-agree");

    //Заголовок блока для пополнения, ссылка на подробности кнопка
    private By title = By.xpath("//div[@class='col-12 col-xl-8']//h2[1]");
    private By serviceLink = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");
    private By continueButton = By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]");

    // 4 кнопки в дропдауне для пополнения. +1 локатор используется для хедера/активной кнопки, неважно какой.
    private By headerButton = By.xpath("//button[@class='select__header']");
    private By connectionButton = By.cssSelector("div[id='pay-section'] li:nth-child(1) p:nth-child(1)"); // Данная кнопка не используется в тестах, так как является активной со старта
    private By homeInternetButton = By.cssSelector("div[id='pay-section'] li:nth-child(2) p:nth-child(1)");
    private By instalmentPlanButton = By.cssSelector("div[id='pay-section'] li:nth-child(3) p:nth-child(1)");
    private By debtButton = By.cssSelector("div[id='pay-section'] li:nth-child(4) p:nth-child(1)");

    //Все поля пополнения в iFrame оплаты
    private By phoneNumberField = By.id("connection-phone");
    private By sumField = By.id("connection-sum");
    private By emailField = By.id("connection-email");
    private By internetPhoneField = By.id("internet-phone");
    private By scoreInstalmentField = By.id("score-instalment");
    private By scoreArrearsField = By.id("score-arrears");

    //Кнопка, сумма, реквизиты в iFrame оплаты
    private By frameTitleSum = By.cssSelector(".pay-description__cost > span:nth-child(1)");
    private By frameButtonSum = By.xpath("//div[@class='card-page__card']//button");
    private By framePayDescription = By.xpath("//div[@class='pay-description__text']");
    private By frameCredentials = By.xpath("//div[@class='card ng-tns-c61-0']");


    /// МЕТОДЫ

    // Инициализируем драйвер
    public MainPageReplenish(WebDriver driver) {
        this.driver = driver;
    }


    // Универсальный метод для нахождения элемента, сделан для практики
    public WebElement getElement(By loc) {
        return driver.findElement(loc);
    }


    // Метод принятия кук
    public void acceptCookies() {
        try {
            getElement(cookieButton).click();
            System.out.println("Куки приняты\n");
        } catch (Exception e) {
            System.out.println("Куки не появились\n");
        }
    }


    // Методы получения заголовка и ссылки в блоке пополнения
    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public WebElement getServiceLink() {
        return driver.findElement(serviceLink);
    }

    // 6 методов получения текста незаполненных полей при помощи единого атрибута "placeholder"
    public String getPhoneNumberFieldText() {
        return driver.findElement(phoneNumberField).getDomAttribute("placeholder");
    }

    public String getInternetPhoneFieldText() {
        return driver.findElement(internetPhoneField).getDomAttribute("placeholder");
    }

    public String setScoreInstalmentFieldText() {
        return driver.findElement(scoreInstalmentField).getDomAttribute("placeholder");
    }

    public String getScoreArrearsFieldText() {
        return driver.findElement(scoreArrearsField).getDomAttribute("placeholder");
    }

    // Эти 2 поля являются универсальными для всех вкладок дропдауна, имеют одинаковый текст.
    public String getSumFieldText() {
        return driver.findElement(sumField).getDomAttribute("placeholder");
    }

    public String getEmailFieldText() {
        return driver.findElement(emailField).getDomAttribute("placeholder");
    }


    //Заполнение всех полей на главной
    public void fillForm(String phone, String sum, String email) {
        driver.findElement(phoneNumberField).sendKeys(phone);
        driver.findElement(sumField).sendKeys(sum);
        driver.findElement(emailField).sendKeys(email);
    }


    //Методы для нахождения элементов дропдауна
    public WebElement headerButton() {
        return driver.findElement(headerButton);
    }

    public WebElement connectionButton() {
        return driver.findElement(connectionButton);
    }

    public WebElement homeInternetButton() {
        return driver.findElement(homeInternetButton);
    }

    public WebElement instalmentPlanButton () {
        return driver.findElement(instalmentPlanButton);
    }

    public WebElement debtButton() {
        return driver.findElement(debtButton);
    }


    // Кнопка продолжения
    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }


    // Методы нахождения текста фрейма оплаты
    public String getFrameTitleSumText() {
        return driver.findElement(frameTitleSum).getText();
    }

    public String getFrameButtonSumText() {
        return driver.findElement(frameButtonSum).getText();
    }

    public String getFramePayDescriptionText() {
        return driver.findElement(framePayDescription).getText();
    }

    public String getFrameCredentialsText() {
        return driver.findElement(frameCredentials).getText();
    }
}