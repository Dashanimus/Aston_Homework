import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    public static void main(String[] args) {

        // Драйвер для работы с Selenium
        System.setProperty("webdriver.chromedriver", "E:\\Intellij Idea Projects\\Aston_Homework\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Поиск элемента на странице Google
        driver.get("https://google.com");
        WebElement input = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));

        input.click();
        driver.quit();
    }
}
