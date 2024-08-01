import com.driver.util.DriverConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.pages.BugBankPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BugBankTest {

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {

        driver = DriverConfig.getDriver();

    }

    @AfterAll
    public static void afterAll() {

        driver.quit();

    }

    @Test
    public void createAnAccount() {

        driver.get("https://bugbank.netlify.app/");
        driver.getWindowHandles();

        WebElement registerButton = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[2]"));
        registerButton.click();
        // não sei porque não é clicável, é um botão

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
        assertThat(modalConfirmation.getText(), is("A conta foi criada com sucesso"));

    }

    @Test
    public void createAnAccountRefactor() {

        driver.get("https://bugbank.netlify.app/");
        driver.getWindowHandles();

        BugBankPage bugBankPage = new BugBankPage();

        bugBankPage.getRegisterButton().click();

        bugBankPage.getEmailField().sendKeys("test@test.com");
        bugBankPage.getNameField().sendKeys("Joana Da Silva");
        bugBankPage.getPasswordField().sendKeys("123qwe");
        bugBankPage.getPasswordConfirmation().sendKeys("123qwe");
        bugBankPage.getModalConfirmation().sendKeys("123qwe");

        bugBankPage.getBalanceToggle().click();

        bugBankPage.getCreateAccount().click();

        assertThat(bugBankPage.getModalConfirmation().getText(), is("A conta foi criada com sucesso"));

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
        assertThat(welcomeMessage.getText(), is("Olá Joana Da Silva,"));

    }

    @Test
    public void loginRefactor() {

        driver.get("https://bugbank.netlify.app/");
        driver.getWindowHandles();

        BugBankPage bugBankPage = new BugBankPage();

        bugBankPage.getEmailField().sendKeys("test@test.com");
        bugBankPage.getPasswordField().sendKeys("123qwe");

        WebElement accessButton = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3" +
                "]/button[1]"));
        accessButton.click();

        WebElement welcomeMessage = driver.findElement(By.id("textName"));
        assertThat(welcomeMessage.getText(), is("Olá Joana Da Silva,"));

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
        assertThat(availableBalance.getText(), is("Saldo disponível"));

    }

}
