package com.pages;

import com.driver.util.DriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BurgerEatsPage {

    private WebElement nameField;
    private WebElement cpfField;
    private WebElement emailField;
    private WebElement whatsappField;



    public BurgerEatsPage() {

        nameField = DriverConfig.getDriver().findElement(By.name("name"));
        cpfField = DriverConfig.getDriver().findElement(By.name("cpf"));
        emailField = DriverConfig.getDriver().findElement(By.name("email"));
        whatsappField = DriverConfig.getDriver().findElement(By.name("whatsapp"));

    }

    public WebElement getNameField() {

        return nameField;

    }

    public void setNameField(WebElement nameField) {

        this.nameField = nameField;

    }

    public WebElement getCpfField() {
        return cpfField;
    }

    public void setCpfField(WebElement cpfField) {
        this.cpfField = cpfField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    public WebElement getWhatsappField() {
        return whatsappField;
    }

    public void setWhatsappField(WebElement whatsappField) {
        this.whatsappField = whatsappField;
    }
}
