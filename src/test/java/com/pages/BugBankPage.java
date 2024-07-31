package com.pages;

import com.driver.util.DriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BugBankPage {

    private WebElement registerButton;
    private WebElement emailField;
    private WebElement nameField;
    private WebElement passwordField;
    private WebElement passwordConfirmation;
    private WebElement balanceToggle;
    private WebElement createAccount;
    private WebElement modalConfirmation;

    public BugBankPage() {

        registerButton = DriverConfig.getDriver().findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[2]"));
        emailField = DriverConfig.getDriver().findElement(By.name("email"));
        passwordField = DriverConfig.getDriver().findElement(By.name("password"));
        passwordConfirmation = DriverConfig.getDriver().findElement(By.name("passwordConfirmation"));
        balanceToggle = DriverConfig.getDriver().findElement(By.id("toggleAddBalance"));
        createAccount = DriverConfig.getDriver().findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/button"));
        modalConfirmation = DriverConfig.getDriver().findElement(By.id("modalText"));

    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(WebElement registerButton) {
        this.registerButton = registerButton;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public void setNameField(WebElement nameField) {
        this.nameField = nameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
    }

    public WebElement getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(WebElement passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public WebElement getBalanceToggle() {
        return balanceToggle;
    }

    public void setBalanceToggle(WebElement balanceToggle) {
        this.balanceToggle = balanceToggle;
    }

    public WebElement getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(WebElement createAccount) {
        this.createAccount = createAccount;
    }

    public WebElement getModalConfirmation() {
        return modalConfirmation;
    }

    public void setModalConfirmation(WebElement modalConfirmation) {
        this.modalConfirmation = modalConfirmation;
    }
}
