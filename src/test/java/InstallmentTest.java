import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InstallmentTest extends BaseTest{

    @Test
    public void installmentTest(){
        WebElement installment = waitService.waitForElementClickable(By.xpath("//p[text() = 'Рассрочка']"));
        installment.click();

        WebElement accountNumberField = waitService.waitForVisibilityLocatedBy(By.id("score-instalment"));
        String actualAccountText = accountNumberField.getAttribute("placeholder");
        Assert.assertEquals(actualAccountText, "Номер счета на 44", "Текст поля \"Номер счета на 44\" не совпадает");

        WebElement sumField = waitService.waitForVisibilityLocatedBy(By.xpath("//input[@id='instalment-sum']"));
        String actualSumText = sumField.getAttribute("placeholder");
        Assert.assertEquals(actualSumText, "Сумма", "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = waitService.waitForVisibilityLocatedBy(By.xpath("//input[@id='instalment-email']"));
        String actualEmailText = emailField.getAttribute("placeholder");
        Assert.assertEquals(actualEmailText, "E-mail для отправки чека", "Текст поля \"Email\" не совпадает");
    }
}
