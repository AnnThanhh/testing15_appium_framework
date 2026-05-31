import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoStartApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName("Android");
        androidOptions.setAutomationName("UiAutomator2");
        androidOptions.setUdid("emulator-5554");
        androidOptions.setDeviceName("Testing-15-pixel-9");
        androidOptions.setAppPackage("com.saucelabs.mydemoapp.android");
        androidOptions.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), androidOptions);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String username = "testing_15";
        String password = "testing_15";

        //bước 1: click menu
        By byMenu = AppiumBy.accessibilityId("View menu");
        WebElement mainMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(byMenu));
        mainMenu.click();
        //bước 2: click login
        By byLoginBtn=AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn));
        loginBtn.click();
        //bước 3: nhập username và password
        By byUserName = AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/nameET\")");
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(byUserName));
        usernameInput.sendKeys(username);

        By byPassword = AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/passwordET\")");
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword));
        passwordInput.sendKeys(password);
        //bước 4: click login button
        By byLoginBtnPage = AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/loginBtn\")");
        WebElement loginBtnPage = wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtnPage));
        loginBtnPage.click();

        //bước 5: verify valid account login successfully
        By byTitle = AppiumBy.accessibilityId("title");
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(byTitle));
        String actualTitle = title.getText();
        Assert.assertEquals(actualTitle, "Products", "Products title should be displayed after login successfully");

        Thread.sleep(2000);
        driver.quit();
    }
}
