package pages.abstracts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class LoginPage extends CommonPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public abstract void enterAccount(String accountName);

    public abstract void enterPassword(String password);

    public abstract void clickLogin();
}
