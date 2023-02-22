package com.Project4Homework.test.homework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='authUser']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='clearPass']")
    WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    WebElement loginButton;


    public void login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();

    }


}
