import configurator.ReadProperties;

import services.WaitService;
import services.BrowserService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;
    protected WaitService waitService;

    @BeforeMethod
    public void beforeMethod() {
        driver = new BrowserService().getDriver();
        waitService = new WaitService(driver);

        driver.get(ReadProperties.getUrl());
        waitService.waitForVisibilityLocatedBy(By.id("cookie-agree")).click();

        WebElement selector = waitService.waitForVisibilityLocatedBy(By.xpath("//button[@class='select__header']"));
        selector.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
