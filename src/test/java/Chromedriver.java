import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;


class Chromedriver {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
    }
}
