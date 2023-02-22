package com.Project4Homework.test.homework.test;

import com.Project4Homework.test.homework.pages.LoginPage;
import com.Project4Homework.test.homework.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase {

    @Parameters({"userName", "password", "patient", "fullName", "homePhone", "ssn", "dateOfBirth"})
    @Test
    public void patientFinder(String userName, String password, String patient, String fullName, String homePhone,
                              String ssn, String dateOfBirth) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        loginPage.login(userName, password);
        mainPage.searchPatient(patient);
        mainPage.validatePatientInfo(fullName, homePhone, ssn, dateOfBirth);
        mainPage.validatePatientAge();


    }

    @Parameters({"userName", "password", "patient"})
    @Test()
    public void validateAmmendment(String userName, String password, String patient) {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.login(userName, password);
        mainPage.searchPatient(patient);
        mainPage.clickOnPatient();

        mainPage.amendments();
    }


}
