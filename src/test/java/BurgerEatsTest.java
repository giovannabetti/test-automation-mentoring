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
        /*
        Efetue uma tentativa de cadastro informando um CPF inválido e deixando de enviar a foto da CNH e valide que
        mensagens informando da necessidade de corrigir os campos são exibidas.
         */

        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

        // tem como definir esses elementos em um outro arquivo ou deixá-los acessíveis para outros testes neste
        // mesmo arquivo?
        WebElement registerButton = driver.findElement(By.xpath("//*[@id='page-home']/div/main/a"));
        registerButton.click();

        BurgerEatsPage burgerEatsPage = new BurgerEatsPage();

        burgerEatsPage.getNameField().sendKeys("João Da Silva");
        burgerEatsPage.getCpfField().sendKeys("000000000000000");
        burgerEatsPage.getEmailField().sendKeys("test@test.com");
        burgerEatsPage.getWhatsappField().sendKeys("3333333333");

        WebElement cepField = driver.findElement(By.name("postalcode"));
        cepField.sendKeys("59139-160");

        WebElement cepButton = driver.findElement(By.cssSelector("[type='button']"));
        cepButton.click();

        WebElement addressNumberField = driver.findElement(By.name("address-number"));
        addressNumberField.sendKeys("13");

        WebElement bikeButton = driver.findElement(By.xpath("//*[@id='page-deliver']/form/fieldset[3]/ul/li[2]"));
        bikeButton.click();

        WebElement submitButton = driver.findElement(By.className("button-success"));
        submitButton.click();

        WebElement cpfAlert = driver.findElement(By.className("alert-error"));
        assertThat(cpfAlert.getText(), is("Oops! CPF inválido"));

    }

    @Test
    public void validRegister() {
    /*
    Efetue um cadastro completo, informando os dados necessários corretamente, selecionando o método de entrega
    “Bicicleta” (porque somos amigos da natureza 😀🚲). Valide que o cadastro foi concluído com sucesso.
    */
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

        WebElement submitButton = driver.findElement(By.className("button-success"));
        submitButton.click();

    }
}

/*
* Dúvidas:
* 1. Como consigo selecionar um arquivo para CNH
* 2. O site tá funcionando mesmo? Pq não consegui manualmente
* 3. Como pegar a mensagem de erro e conferir se ela está na tela?
* 4. Tem algum playground?
* */