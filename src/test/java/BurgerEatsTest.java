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

        BurgerEatsPage burgerEatsPage = new BurgerEatsPage();

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


        assertThat(burgerEatsPage.getCpfAlert().getText(), is("Oops! CPF inválido"));

        // só aparece a mensagem da cnh se o cpf estiver correto
    }

    @Test
    public void invalidCnh() {

        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

        BurgerEatsPage burgerEatsPage = new BurgerEatsPage();

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


        assertThat(burgerEatsPage.getCnhAlert().getText(), is("Adicione uma foto da sua CNH"));

    }

    @Test
    public void validRegister() {

        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

        WebElement registerButton = driver.findElement(By.xpath("//*[@id='page-home']/div/main/a"));
        registerButton.click();

        WebElement nameField = driver.findElement(By.name("name"));
        WebElement cpfField = driver.findElement(By.name("cpf"));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement whatsappField = driver.findElement(By.name("whatsapp"));
        nameField.sendKeys("João Da Silva");
        cpfField.sendKeys("57528767026");
        emailField.sendKeys("test@test.com");
        whatsappField.sendKeys("3333333333");

        WebElement cepField = driver.findElement(By.name("postalcode"));
        cepField.sendKeys("59139-160");

        WebElement cepButton = driver.findElement(By.cssSelector("[type='button']"));
        cepButton.click();

        WebElement addressNumberField = driver.findElement(By.name("address-number"));
        addressNumberField.sendKeys("13");

        WebElement bikeButton = driver.findElement(By.xpath("//*[@id='page-deliver']/form/fieldset[3]/ul/li[2]"));
        bikeButton.click();


        String filePath = "/home/giovannabetti/IdeaProjects/mentoria/resources/cnhpicture.png";
        WebElement cnhPicture = driver.findElement(By.xpath("//*[@id='page-deliver']/form/div/input"));
        cnhPicture.sendKeys(filePath);

        WebElement submitButton = driver.findElement(By.className("button-success"));
        submitButton.click();

        WebElement successModal = driver.findElement(By.id("swal2-html-container"));
        assertThat(successModal.getText(), is("Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato."));

    }

    @Test
    public void validRegisterRetest() {

        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

        BurgerEatsPage burgerEatsPage = new BurgerEatsPage();

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

        // como não colocar o endereço direto aqui? é boa prática?
        String filePath = "/home/giovannabetti/IdeaProjects/mentoria/resources/cnhpicture.png";
        burgerEatsPage.getCnhPicture().sendKeys(filePath);

        burgerEatsPage.getSubmitButton().click();

        assertThat(burgerEatsPage.getSuccessModal().getText(), is("Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato."));

    }

}
