package com.Project4Homework.test.homework.test;

import com.Project4Homework.test.homework.pages.CreateNewMessagePage;
import com.Project4Homework.test.homework.pages.LoginPage;
import com.Project4Homework.test.homework.pages.MainPage;
import com.Project4Homework.test.homework.pages.MessagesPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateNewMessageTest extends TestBase {

    @Parameters({"userName", "password", "patient", "message"})

    @Test
    public void createNewMessage(String userName, String password, String patient, String message) {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        MessagesPage messagesPage = new MessagesPage(driver);

        loginPage.login(userName, password);
        mainPage.searchPatient(patient);
        mainPage.goToMessages();
        messagesPage.addNew();
        CreateNewMessagePage createNewMessagePage = new CreateNewMessagePage(driver);
        createNewMessagePage
                .selectType()
                .selectUser()
                .sendMessage(message);
    }
}
