package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BurgerEatsPage {

    @FindBy(name="name")
    private WebElement nameField;

    @FindBy(name="cpf")
    private WebElement cpfField;

    @FindBy(name="email")
    private WebElement emailField;

    @FindBy(name="whatsapp")
    private WebElement whatsappField;

    @FindBy(xpath="//*[@id='page-home']/div/main/a")
    private WebElement registerButton;

    @FindBy(name="postalcode")
    private WebElement cepField;

    @FindBy(css="[type='button']")
    private WebElement cepButton;

    @FindBy(name="address-number")
    private WebElement addressNumberField;

    @FindBy(xpath="//*[@id='page-deliver']/form/fieldset[3]/ul/li[2]")
    private WebElement bikeButton;

    @FindBy(className="button-success")
    private WebElement submitButton;

    @FindBy(className="alert-error")
    private WebElement alert;

    @FindBy(id="swal2-html-container")
    private WebElement successModal;

    @FindBy(xpath="//*[@id='page-deliver']/form/div/input")
    private WebElement cnhPicture;


    private WebDriver driver;

    public BurgerEatsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public WebElement getAlert() {
        return alert;
    }

    public void setAlert(WebElement alert) {
        this.alert = alert;
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
