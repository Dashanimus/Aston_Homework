import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MTS {

    @FindBy(xpath = "//div[@class=\"pay__partners\"]/following-sibling::a")
    private WebElement aboutServiceLink;

    @FindBy(xpath = "//button[@id=\"cookie-agree\"]")
    private WebElement cookieAgreeBtn;

    @FindBy(xpath = "//section[@class=\"pay\"]//h2[contains(text(), 'Онлайн пополнение')]")
    private WebElement payTitle;

    @FindBy(xpath = "//div[@class=\"pay__forms\"]//input[@id=\"connection-phone\"]")
    private WebElement phoneInput;

    @FindBy(xpath = "//div[@class=\"pay__forms\"]//input[@id=\"connection-sum\"]")
    private WebElement sumInput;

    @FindBy(xpath = "//div[@class=\"pay__forms\"]//input[@id=\"connection-email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//iframe[@class=\"bepaid-iframe\"]")
    private WebElement payIframe;

    @FindBy(xpath = "//div[@class=\"pay__forms\"]//form[@id=\"pay-connection\"]//button")
    private WebElement paySubmitBtn;

    public void cookieAgreeClick() {
        if (cookieAgreeBtn.isDisplayed()) {
            cookieAgreeBtn.click();
        }
    }

    public void aboutServiceClick() {
        if (aboutServiceLink.isDisplayed()) {
            aboutServiceLink.click();
        }
    }

    public String titleText() {
        return payTitle.getText();
    }

    public void setPhone(String phone) {
        phoneInput.click();
        phoneInput.sendKeys(phone);
    }

    public void setSum(String sum) {
        sumInput.click();
        sumInput.sendKeys(sum);
    }

    public void setEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void changeFrame(WebDriver driver) {

        if (payIframe.isDisplayed()) {

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(payIframe));
        }
    }

    public void paySubmitClick() {
        if (paySubmitBtn.isDisplayed()) {
            paySubmitBtn.click();
        }
    }

}
