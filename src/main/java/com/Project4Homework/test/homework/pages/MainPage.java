package com.Project4Homework.test.homework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import static utils.DriverHelper.driver;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "anySearchBox")
    WebElement searchBox;

    @FindBy(xpath = "//tr[@id='pid_1']//td")
    List<WebElement> patientInfo;

    @FindBy(xpath = "(//tr[@id='pid_1']//td)[5]")
    WebElement externalIdMainPage;

    @FindBy(xpath = "//a[contains(text(),'Demographics')]")
    WebElement demographicsButton;

    @FindBy(xpath = "//td[@id='text_pubpid']")
    WebElement externalIdDemographicsPage;

    @FindBy(xpath = "//td[@id='text_DOB']")
    WebElement dateOfBirthOnWeb;

    @FindBy(xpath = "//span[contains(text(), ' DOB: 1972-02-09 Age: 50')]")
    WebElement fullDateAndAge;

    @FindBy(xpath = "//div[contains(text(),'Messages')]")
    WebElement messages;

    @FindBy(xpath = "//a[contains(text(),'Amendments')]")
    WebElement amendments;

    public void searchPatient(String patient) {
        this.searchBox.sendKeys(patient, Keys.ENTER);
    }

    public void validatePatientInfo(String fullName, String homePhone, String ssn, String dateOfBirth) throws InterruptedException {

        driver.switchTo().frame("fin");
        for (int i = 0; i < patientInfo.size() - 2; i++) {
            String text = BrowserUtils.getText(patientInfo.get(i));
            Assert.assertTrue(text.contains(fullName) || text.contains(homePhone) || text.contains(ssn) || text.contains(dateOfBirth));
        }

        String expectedText = externalIdMainPage.getText().trim();
        System.out.println("expectedText " + expectedText);
        Thread.sleep(5000);
        externalIdMainPage.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("pat");
        demographicsButton.click();
        String actualText = externalIdDemographicsPage.getAttribute("data-value").trim();
        System.out.println("actualText " + actualText);
        Assert.assertEquals(actualText, expectedText);
        Assert.assertNotNull(dateOfBirthOnWeb);
    }

    public boolean validatePatientAge() {
        String[] yearData = BrowserUtils.getText(dateOfBirthOnWeb).trim().split("-");
        for (String year : yearData) {
            driver.switchTo().defaultContent();
            if ((year.length() == 4)) {
                if (BrowserUtils.getText(fullDateAndAge).substring(16).contains(String.valueOf(LocalDate.now().getYear() - Integer.parseInt(year)))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void goToMessages() {
        driver.switchTo().defaultContent();
        messages.click();
    }

    public void clickOnPatient() {
        driver.switchTo().frame("fin");
        externalIdMainPage.click();
    }

    public void amendments() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("pat");
        amendments.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(BrowserUtils.getText(amendments).contains("Amendments"));

    }
}