import com.driver.util.DriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SauceDemoTest {

    @Test
    public void login() {

        WebDriver driver = DriverConfig.getDriver();
        driver.get("https://www.saucedemo.com/");
        driver.getWindowHandles();

    }
}
