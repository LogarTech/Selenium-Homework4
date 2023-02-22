package com.Project4Homework.test.homework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverHelper.driver;

public class MessagesPage {
    public MessagesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary btn-add']")
    WebElement addNewButton;

    public void addNew() {
        driver.switchTo().frame("msg");
        addNewButton.click();
    }

}
