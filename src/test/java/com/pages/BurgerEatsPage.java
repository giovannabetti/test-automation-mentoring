package com.pages;

import com.driver.util.DriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BurgerEatsPage {

    private WebElement nameField;
    private WebElement cpfField;
    private WebElement emailField;
    private WebElement whatsappField;
    private WebElement registerButton;
    private WebElement cepField;
    private WebElement cepButton;
    private WebElement addressNumberField;
    private WebElement bikeButton;
    private WebElement submitButton;
    private WebElement cpfAlert;
    private WebElement cnhAlert;
    private WebElement successModal;
    private WebElement cnhPicture;


    public BurgerEatsPage() {

        nameField = DriverConfig.getDriver().findElement(By.name("name"));
        cpfField = DriverConfig.getDriver().findElement(By.name("cpf"));
        emailField = DriverConfig.getDriver().findElement(By.name("email"));
        whatsappField = DriverConfig.getDriver().findElement(By.name("whatsapp"));
        registerButton = DriverConfig.getDriver().findElement(By.xpath("//*[@id='page-home']/div/main/a"));
        cepField = DriverConfig.getDriver().findElement(By.name("postalcode"));
        cepButton = DriverConfig.getDriver().findElement(By.cssSelector("[type='button']"));
        addressNumberField = DriverConfig.getDriver().findElement(By.name("address-number"));
        bikeButton = DriverConfig.getDriver().findElement(By.xpath("//*[@id='page-deliver']/form/fieldset[3]/ul/li[2]"));
        submitButton = DriverConfig.getDriver().findElement(By.className("button-success"));
        cpfAlert = DriverConfig.getDriver().findElement(By.className("alert-error"));
        cnhAlert = DriverConfig.getDriver().findElement(By.className("alert-error"));
        cnhPicture = DriverConfig.getDriver().findElement(By.xpath("//*[@id='page-deliver']/form/div/input"));
        successModal = DriverConfig.getDriver().findElement(By.id("swal2-html-container"));

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

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(WebElement registerButton) {
        this.registerButton = registerButton;
    }

    public WebElement getCepField() {
        return cepField;
    }

    public void setCepField(WebElement cepField) {
        this.cepField = cepField;
    }

    public WebElement getCepButton() {
        return cepButton;
    }

    public void setCepButton(WebElement cepButton) {
        this.cepButton = cepButton;
    }

    public WebElement getAddressNumberField() {
        return addressNumberField;
    }

    public void setAddressNumberField(WebElement addressNumberField) {
        this.addressNumberField = addressNumberField;
    }

    public WebElement getBikeButton() {
        return bikeButton;
    }

    public void setBikeButton(WebElement bikeButton) {
        this.bikeButton = bikeButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }

    public WebElement getCpfAlert() {
        return cpfAlert;
    }

    public void setCpfAlert(WebElement cpfAlert) {
        this.cpfAlert = cpfAlert;
    }

    public WebElement getCnhAlert() {
        return cnhAlert;
    }

    public void setCnhAlert(WebElement cnhAlert) {
        this.cnhAlert = cnhAlert;
    }

    public WebElement getSuccessModal() {
        return successModal;
    }

    public void setSuccessModal(WebElement successModal) {
        this.successModal = successModal;
    }

    public WebElement getCnhPicture() {
        return cnhPicture;
    }

    public void setCnhPicture(WebElement cnhPicture) {
        this.cnhPicture = cnhPicture;
    }

}
