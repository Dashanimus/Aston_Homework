import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class Tests extends Chromedriver {
    private final String mtsUrl = "https://www.mts.by/";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(mtsUrl);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Тест названия блока оплаты")
    void payTitleTest() {

        MTS mts = PageFactory.initElements(driver, MTS.class);
        mts.cookieAgreeClick();

        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", mts.titleText());
    }

    @ParameterizedTest
    @DisplayName("Тест логотипов платежных систем")
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    void payLogoTest(String payName) {

        MTS mts = PageFactory.initElements(driver, MTS.class);
        mts.cookieAgreeClick();

        String xpath = String.format("//div[@class=\"pay__partners\"]/descendant::img[@alt=\"%s\"]", payName);

        WebElement payLogo = driver.findElement(By.xpath(xpath));

        Assertions.assertTrue(payLogo.isDisplayed());
    }

    @Test
    @DisplayName("Тест ссылки 'Подробнее о сервисе'")
    void aboutPayHrefTest() {

        MTS mts = PageFactory.initElements(driver, MTS.class);

        mts.cookieAgreeClick();

        mts.aboutServiceClick();

        Assertions.assertEquals(
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Тест подтверждения формы оплаты")
    void paySubmitTest() {

        MTS mts = PageFactory.initElements(driver, MTS.class);

        mts.cookieAgreeClick();

        String phone = "297777777", paymentSum = "100", email = "dasha_tester@gmail.com";

        mts.setPhone(phone);
        mts.setSum(paymentSum);
        mts.setEmail(email);

        mts.paySubmitClick();

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class=\"bepaid-iframe\"]"));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));

        String xpathPaymentSum = String.format("//div[@class=\"header__container\"]//span[contains(text(),'%s')]", paymentSum);
        List<WebElement> paymentSumElements = driver.findElements(By.xpath(xpathPaymentSum));

        Assertions.assertTrue(paymentSumElements.isEmpty());

        String xpathPaymentInfo = String.format("//div[@class=\"header__container\"]//p[contains(text(), \"%s\")]", phone);
        List<WebElement> paymentInfoElements = driver.findElements(By.xpath(xpathPaymentInfo));

        Assertions.assertTrue(paymentInfoElements.isEmpty());
    }
}
