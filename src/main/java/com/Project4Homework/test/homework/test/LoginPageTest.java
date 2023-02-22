package com.Project4Homework.test.homework.test;

import com.Project4Homework.test.homework.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {


    @Parameters({"userName", "password"})

    @Test
    public void validateLogin(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password);

    }
}
