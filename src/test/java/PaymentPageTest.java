import configurator.ReadProperties;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PaymentPageTest extends BaseTest {
    @Test
    public void paymentPageTest(){
        WebElement communicationService = waitService.waitForElementClickable(By.xpath("//ul[@class='select__list']//li[1]"));
        communicationService.click();

        WebElement phoneNumberField = waitService.waitForVisibilityLocatedBy(By.id("connection-phone"));
        WebElement sumField = waitService.waitForVisibilityLocatedBy(By.id("connection-sum"));
        WebElement emailField = waitService.waitForVisibilityLocatedBy(By.id("connection-email"));

        phoneNumberField.sendKeys(ReadProperties.phoneNumber());
        sumField.sendKeys(ReadProperties.sum());
        emailField.sendKeys(ReadProperties.email());

        WebElement continueButton = waitService.waitForElementClickable(By.xpath("//form[@id='pay-connection']/button"));
        continueButton.submit();

        WebElement checkWindow = waitService.waitForVisibilityLocatedBy(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(checkWindow);

        WebElement iframeSum = waitService.waitForVisibilityLocatedBy(By.xpath("//*[@class='pay-description__cost']/span"));
        String actualSum = iframeSum.getText().replace(" BYN", "");
        Assert.assertEquals(actualSum, ReadProperties.sum(), "Сумма отображается неверно");

        WebElement iframeNumber = waitService.waitForVisibilityLocatedBy(By.xpath("//*[@class='pay-description__text']"));
        String actualNumber = iframeNumber.getText().replace("Оплата: Услуги связи Номер:375", "");
        Assert.assertEquals(actualNumber, ReadProperties.phoneNumber(), "Номер телефона отображается неверно");

        WebElement iframeButtonSubmit = waitService.waitForVisibilityLocatedBy(By.xpath("//*[@class='colored disabled']"));
        String actualButton = iframeButtonSubmit.getText().trim().substring(9, 14);
        Assert.assertEquals(actualButton, ReadProperties.sum(), "Сумма на кнопке отображается неверно");

        List<WebElement> placeholders = waitService.waitForAllExistElementsLocatedBy(By.xpath("//app-card-input//input//following-sibling::label"));
        List<String> placeholdersText = new ArrayList<>();
        for (WebElement attribute : placeholders) {
            placeholdersText.add(attribute.getAttribute("textContent"));
        }
        Assert.assertEquals(List.of("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)"), placeholdersText);

        WebElement labelMasterCard = waitService.waitForVisibilityLocatedBy(By.xpath("//img[contains(@src, 'types/mastercard')]"));
        WebElement labelVisa = waitService.waitForVisibilityLocatedBy(By.xpath("//img[contains(@src, 'types/visa')]"));
        WebElement labelBelkard = waitService.waitForVisibilityLocatedBy(By.xpath("//img[contains(@src, 'types/belkart')]"));
        WebElement labelMir = waitService.waitForVisibilityLocatedBy(By.xpath("//img[contains(@src, 'types/mir')]"));

        labelMasterCard.isDisplayed();
        labelVisa.isDisplayed();
        labelBelkard.isDisplayed();
        labelMir.isDisplayed();
    }
}
