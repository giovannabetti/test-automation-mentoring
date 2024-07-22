import com.driver.util.DriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BurgerEatsTest {

    @Test
    public void invalidRegister() {
        /*
        Efetue uma tentativa de cadastro informando um CPF
        inválido e deixando de enviar a foto da CNH e valide
        que mensagens informando da necessidade de corrigir
        os campos são exibidas.
         */

        // tem como colocar essa configuração antes de todos os testes
        // uma vez só pra não ter que repetir sempre?

        WebDriver driver = DriverConfig.getDriver();
        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

        // *[@id="page-home"]/div/main/a
        WebElement registerButton = driver.findElement(new By.ByLinkText("Cadastre-se para fazer entregas"));

        registerButton.click();

        driver.quit();

    }

    @Test
    public void validRegister() {
    /*
    Efetue um cadastro completo, informando os dados necessários
    corretamente, selecionando o método de entrega “Bicicleta”
    (porque somos amigos da natureza 😀🚲). Valide que o
    cadastro foi concluído com sucesso.
    */
        WebDriver driver = DriverConfig.getDriver();
        driver.get("https://buger-eats.vercel.app/");
        driver.getWindowHandles();

    }
}
