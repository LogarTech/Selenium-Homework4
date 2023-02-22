package com.Project4Homework.test.homework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import static utils.DriverHelper.driver;

public class CreateNewMessagePage {
    public CreateNewMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='form_note_type']")
    WebElement typeSelect;

    @FindBy(xpath = "//select[@id='users']")
    WebElement users;

    @FindBy(xpath = "//textarea[@id='note']")
    WebElement textBox;

    @FindBy(xpath = "//button[@id='newnote']")
    WebElement sendMessageButton;

    public CreateNewMessagePage selectType() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("msg");
        BrowserUtils.selectBy(typeSelect, "Lab Results", "text");
        return this;
    }

    public CreateNewMessagePage selectUser() {
        BrowserUtils.selectBy(users, "Jarvis, Fred", "text");
        return this;
    }

    public CreateNewMessagePage sendMessage(String message) {
        textBox.sendKeys(message);
        sendMessageButton.click();
        return this;
    }

}
