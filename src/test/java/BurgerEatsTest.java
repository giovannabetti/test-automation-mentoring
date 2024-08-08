import com.driver.util.DriverConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.pages.BurgerEatsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;

public class BurgerEatsTest {

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
    public void invalidRegister() {

        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

        BurgerEatsPage burgerEatsPage = new BurgerEatsPage(driver);

        burgerEatsPage.getRegisterButton().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        burgerEatsPage.getNameField().sendKeys("João Da Silva");
        burgerEatsPage.getCpfField().sendKeys("000000000000000");
        burgerEatsPage.getEmailField().sendKeys("test@test.com");
        burgerEatsPage.getWhatsappField().sendKeys("3333333333");
        burgerEatsPage.getCepField().sendKeys("59139-160");
        burgerEatsPage.getCepButton().click();
        burgerEatsPage.getAddressNumberField().sendKeys("13");
        burgerEatsPage.getBikeButton().click();
        burgerEatsPage.getSubmitButton().click();


        assertThat(burgerEatsPage.getAlert().getText(), is("Oops! CPF inválido"));

        // só aparece a mensagem da cnh se o cpf estiver correto
    }

    @Test
    public void invalidCnh() {

        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

        BurgerEatsPage burgerEatsPage = new BurgerEatsPage(driver);

        burgerEatsPage.getRegisterButton().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        burgerEatsPage.getNameField().sendKeys("João Da Silva");
        burgerEatsPage.getCpfField().sendKeys("57528767026");
        burgerEatsPage.getEmailField().sendKeys("test@test.com");
        burgerEatsPage.getWhatsappField().sendKeys("3333333333");
        burgerEatsPage.getCepField().sendKeys("59139-160");
        burgerEatsPage.getCepButton().click();
        burgerEatsPage.getAddressNumberField().sendKeys("13");
        burgerEatsPage.getBikeButton().click();
        burgerEatsPage.getSubmitButton().click();


        assertThat(burgerEatsPage.getAlert().getText(), is("Adicione uma foto da sua CNH"));

    }

    @Test
    public void validRegisterRetest() {

        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

        BurgerEatsPage burgerEatsPage = new BurgerEatsPage(driver);

        burgerEatsPage.getRegisterButton().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        burgerEatsPage.getNameField().sendKeys("João Da Silva");
        burgerEatsPage.getCpfField().sendKeys("57528767026");
        burgerEatsPage.getEmailField().sendKeys("test@test.com");
        burgerEatsPage.getWhatsappField().sendKeys("3333333333");
        burgerEatsPage.getCepField().sendKeys("59139-160");
        burgerEatsPage.getCepButton().click();
        burgerEatsPage.getAddressNumberField().sendKeys("13");
        burgerEatsPage.getBikeButton().click();

        File file = new File("resources/cnhpicture.png");
        burgerEatsPage.getCnhPicture().sendKeys(file.getAbsolutePath());

        burgerEatsPage.getSubmitButton().click();

        assertThat(burgerEatsPage.getSuccessModal().getText(), is("Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato."));

    }

}
