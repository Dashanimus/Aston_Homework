import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CommunicationServicesTest extends BaseTest {

    @Test
    public void communicationServicesTest(){
        WebElement communicationService = waitService.waitForElementClickable(By.xpath("//ul[@class='select__list']//li[1]"));
        communicationService.click();

        WebElement phoneNumberField = waitService.waitForVisibilityLocatedBy(By.id("connection-phone"));
        String actualPhoneText = phoneNumberField.getAttribute("placeholder");
        Assert.assertEquals(actualPhoneText, "Номер телефона", "Текст поля \"Номер телефона\" не совпадает");

        WebElement sumField = waitService.waitForVisibilityLocatedBy(By.id("connection-sum"));
        String actualSumText = sumField.getAttribute("placeholder");
        Assert.assertEquals(actualSumText, "Сумма", "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = waitService.waitForVisibilityLocatedBy(By.id("connection-email"));
        String actualEmailText = emailField.getAttribute("placeholder");
        Assert.assertEquals(actualEmailText, "E-mail для отправки чека", "Текст поля \"Email\" не совпадает");
    }
}
