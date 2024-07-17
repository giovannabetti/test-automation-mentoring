import org.apache.log4j.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FirstTest {

    @Test
    public void testing(){

        System.setProperty("webdriver.chrome.driver", "/home/giovannabetti/Documents/chromedriver-linux64/chromedriver");
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary("/opt/google/chrome-beta/google-chrome-beta");
        WebDriver driver = new ChromeDriver(opt);

//        String log4jConfPath = "/path/to/log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);
        // percebi que mesmo sem essas linhas, ele funciona e dá o mesmo erro

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.getWindowHandles();

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();

        driver.quit();
    }

//    public static void configure() {
//        Logger root = Logger.getRootLogger();
//        root.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %p %c %x - %m%n")));
//    } mesma coisa aqui

}
