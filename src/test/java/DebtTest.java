import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DebtTest extends BaseTest {

    @Test
    public void debtTest() {
        WebElement debt = waitService.waitForElementClickable(By.xpath("//p[text() = 'Задолженность']"));
        debt.click();

        WebElement accountNumberField = waitService.waitForVisibilityLocatedBy(By.id("score-arrears"));
        String actualAccountText = accountNumberField.getAttribute("placeholder");
        Assert.assertEquals(actualAccountText, "Номер счета на 2073", "Текст поля \"Номер счета на 2073\" не совпадает");

        WebElement sumField = waitService.waitForVisibilityLocatedBy(By.xpath("//input[@id='arrears-sum']"));
        String actualSumText = sumField.getAttribute("placeholder");
        Assert.assertEquals(actualSumText, "Сумма", "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = waitService.waitForVisibilityLocatedBy(By.xpath("//input[@id='arrears-email']"));
        String actualEmailText = emailField.getAttribute("placeholder");
        Assert.assertEquals(actualEmailText, "E-mail для отправки чека", "Текст поля \"Email\" не совпадает");
    }
}
