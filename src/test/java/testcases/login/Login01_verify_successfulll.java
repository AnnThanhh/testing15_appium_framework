package testcases.login;

import Base.BaseTest;
import Report.ExtentReportManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageFactory;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;

public class Login01_verify_successfulll extends BaseTest {
    @Test
    public void testValidLogin() {
        String username = "testing_15";
        String password = "testing_15";

        HomePage homePage = PageFactory.getHomePage();
        LoginPage loginPage = PageFactory.getLoginPage();
        //bước 1: click menu
        ExtentReportManager.info("Step 1: Click menu button");
        LOG.info("Step 1: Click menu button");
        homePage.getTopBarNavigation().clickMenuButton();

        //bước 2: click login
        ExtentReportManager.info("Step 2: Click login button");
        LOG.info("Step 2: Click login button");
        homePage.getTopBarNavigation().navigateToLoginPage();

        //bước 3: nhập username và password
        ExtentReportManager.info("Step 3: Enter username and password");
        LOG.info("Step 3: Enter username and password");
        loginPage.enterAccount(username);
        loginPage.enterPassword(password);

        //bước 4: click login button
        ExtentReportManager.info("Step 4: Click login button");
        LOG.info("Step 4: Click login button");
        loginPage.clickLogin();

        //bước 5: verify valid account login successfully
        ExtentReportManager.info("Verify point 1: Verify valid account login successfully");
        LOG.info("Verify point 1: Verify valid account login successfully");
        String actualTitle = homePage.getTitleHomePage();
        Assert.assertEquals(actualTitle, "Products", "Products title should be displayed after login successfully");


    }
}
