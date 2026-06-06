package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.abstracts.LoginPage;

public class AndroidLoginPage extends LoginPage {
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/nameET\")")
    WebElement userNameInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/passwordET\")")
    WebElement passwordInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/loginBtn\")")
    WebElement loginBtn;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void enterAccount(String accountName) {
        inputText(userNameInput, accountName);
    }

    @Override
    public void enterPassword(String password) {
        inputText(passwordInput, password);
    }

    @Override
    public void clickLogin() {
        click(loginBtn);
    }
}
