import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeInternetTest extends BaseTest {

    @Test
    public void homeInternetTest() {
        WebElement homeInternet = waitService.waitForElementClickable(By.xpath("//ul[@class='select__list']//li[2]"));
        homeInternet.click();

        WebElement subscriberNumberField = waitService.waitForVisibilityLocatedBy(By.id("internet-phone"));
        String actualSubscriberText = subscriberNumberField.getAttribute("placeholder");
        Assert.assertEquals(actualSubscriberText, "Номер абонента", "Текст поля \"Номер абонента\" не совпадает");

        WebElement sumField = waitService.waitForVisibilityLocatedBy(By.xpath("//input[@id='internet-sum']"));
        String actualSumText = sumField.getAttribute("placeholder");
        Assert.assertEquals(actualSumText, "Сумма", "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = waitService.waitForVisibilityLocatedBy(By.xpath("//input[@id='internet-email']"));
        String actualEmailText = emailField.getAttribute("placeholder");
        Assert.assertEquals(actualEmailText, "E-mail для отправки чека", "Текст поля \"Email\" не совпадает");
    }
}
