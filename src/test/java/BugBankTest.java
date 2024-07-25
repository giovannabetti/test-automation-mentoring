import com.driver.util.DriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.bytebuddy.matcher.ElementMatchers.is;

public class BugBankTest {

    @Test
    public void createAnAccount() {

        WebDriver driver = DriverConfig.getDriver();
        driver.get("https://bugbank.netlify.app/");
        driver.getWindowHandles();

        WebElement registerButton = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[2]"));
        registerButton.click();

        WebElement emailField = driver.findElement(By.name("email"));
        WebElement nameField = driver.findElement(By.name("name"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement passwordConfirmation = driver.findElement(By.name("passwordConfirmation"));
        emailField.sendKeys("test@test.com");
        nameField.sendKeys("Joana Da Silva");
        passwordField.sendKeys("123qwe");
        passwordConfirmation.sendKeys("123qwe");

        WebElement balanceToggle = driver.findElement(By.id("toggleAddBalance"));
        balanceToggle.click();

        WebElement createAccount = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/button"));
        createAccount.click();

        WebElement modalConfirmation = driver.findElement(By.id("modalText"));
        modalConfirmation.isDisplayed();
        // assert(modalConfirmation).getText(), is("A conta foi criada com sucesso");

    }

    @Test
    public void login() {

        WebDriver driver = DriverConfig.getDriver();
        driver.get("https://bugbank.netlify.app/");
        driver.getWindowHandles();

        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        emailField.sendKeys("test@test.com");
        passwordField.sendKeys("123qwe");

        WebElement accessButton = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3" +
                "]/button[1]"));
        accessButton.click();

        WebElement welcomeMessage = driver.findElement(By.id("textName"));
        // Olá Joana Da Silva,

    }

    @Test
    public void getStatement() {

        WebDriver driver = DriverConfig.getDriver();
        driver.get("https://bugbank.netlify.app/");
        driver.getWindowHandles();

        // tem como fazer um login mais fácil aqui?

        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        emailField.sendKeys("test@test.com");
        passwordField.sendKeys("123qwe");

        WebElement accessButton = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3" +
                "]/button[1]"));
        accessButton.click();

        WebElement statementButton = driver.findElement(By.id("btn-EXTRATO"));
        statementButton.click();

        WebElement availableBalance = driver.findElement(By.xpath("//*[@id='__next']/div/div[3]/div/div[1]/p[1]"));
        // Saldo disponível

    }

}
