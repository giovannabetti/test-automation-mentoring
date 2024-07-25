import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class BugBankRefactor {

    protected WebDriver driver;

    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By accessBy = By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3" +
            "]/button[1]");

    /*public SignInPage(WebDriver driver) {
        // alterar
        this.driver = driver;
        if (!driver.getTitle().equals("Sign In Page")) {
            throw new IllegalStateException("This is not Sign In Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    /**
     * Faz login como um usuário válido
     *
     * @param userName
     * @param password
     * @return pbjeto da Pagina Inicial
     */
    /*public HomePage loginValidUser(String userName, String password) {
        driver.findElement(usernameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signinBy).click();
        return new HomePage(driver);
    }
*/
}
