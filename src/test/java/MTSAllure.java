import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MTSAllure {
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
        button.click();
    }

    @Test
    @DisplayName("Проверка плейсхолдеров полей 'Услуги связи' ")
    @Description("Тест проверяет правильность отображения плейсхолдеров в полях 'Услуги связи'")
    public void emptyFieldsTestConnection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='select__header']")));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Услуги связи']")));
        option.click();

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-phone']")));
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-email']")));

        assertEquals("Номер телефона", phoneField.getAttribute("placeholder"), "Сообщение об ошибке для поля телефона должно быть 'Номер телефона'");
        assertEquals("Сумма", sumField.getAttribute("placeholder"), "Сообщение об ошибке для поля суммы должно быть 'Сумма'");
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"), "Сообщение об ошибке для поля email должно быть 'E-mail для отправки чека'");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров полей 'Домашний интернет'")
    @Description("Тест проверяет правильность отображения плейсхолдеров в полях 'Домашний интернет'")
    public void emptyFieldsTestInternet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='select__header']")));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Домашний интернет']")));
        option.click();

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='internet-phone']")));
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='internet-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='internet-email']")));

        assertEquals("Номер абонента", phoneField.getAttribute("placeholder"), "Сообщение для поля телефона должно быть 'Номер абонента'");
        assertEquals("Сумма", sumField.getAttribute("placeholder"), "Сообщение для поля суммы должно быть 'Сумма'");
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"), "Сообщение для поля email должно быть 'E-mail для отправки чека'");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров полей 'Рассрочка'")
    @Description("Тест проверяет правильность отображения плейсхолдеров в полях 'Рассрочка'")
    public void emptyFieldsTestInstallment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='select__header']")));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Рассрочка']")));
        option.click();

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='score-instalment']")));
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='instalment-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='instalment-email']")));

        assertEquals("Номер счета на 44", phoneField.getAttribute("placeholder"), "Сообщение для поля телефона должно быть 'Номер счета на 44'");
        assertEquals("Сумма", sumField.getAttribute("placeholder"), "Сообщение для поля суммы должно быть 'Сумма'");
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"), "Сообщение для поля email должно быть 'E-mail для отправки чека'");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров полей 'Задолженность' ")
    @Description("Тест проверяет правильность отображения плейсхолдеров в полях 'Задолженность'")
    public void emptyFieldsTestDebt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='select__header']")));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Задолженность']")));
        option.click();

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='score-arrears']")));
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='arrears-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='arrears-email']")));

        assertEquals("Номер счета на 2073", phoneField.getAttribute("placeholder"), "Сообщение для поля телефона должно быть 'Номер счета на 2073'");
        assertEquals("Сумма", sumField.getAttribute("placeholder"), "Сообщение для поля суммы должно быть 'Сумма'");
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"), "Сообщение для поля email должно быть 'E-mail для отправки чека'");
    }

    @Test
    @DisplayName(" Корректность отображения суммы, номера телефона, плейсхолдеров для ввода реквизитов карты, наличие иконок платёжных систем.")
    @Description("Тест проверяет корректность отображения суммы (в том числе на кнопке), номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем.")
    public void FieldsTetionSumMobile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='select__header']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Услуги связи']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone"))).sendKeys("297777777");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum"))).sendKeys("200");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button"))).click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));

        assertEquals("200.00 BYN", wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__cost > span:nth-child(1)"))).getText(), "Сумма платежа должна быть 200.00 BYN");
        assertEquals("Оплатить 200.00 BYN", wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".colored.disabled[type='submit']"))).getText(), "Текст кнопки оплаты должен быть 'Оплатить 200.00 BYN'");
        assertEquals("Оплата: Услуги связи Номер:375297777777", driver.findElement(By.cssSelector(".pay-description__text span")).getText());

        String[] labels = {
                "Номер карты", "Срок действия", "CVC"
        };
        for (String label : labels) {
            assertEquals(label, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + label + "')]"))).getText());
        }

        String[] icons = {
                "visa-system.svg", "mastercard-system.svg", "belkart-system.svg",
                "mir-system-ru.svg", "maestro-system.svg"
        };
        for (String icon : icons) {
            assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/" + icon + "']"))).isDisplayed());
        }

        driver.switchTo().defaultContent();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
