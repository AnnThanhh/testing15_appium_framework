package pages.android.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.abstracts.components.TopBarNavigation;

public class AndroidTopBarNavigation extends TopBarNavigation {
    @AndroidFindBy(accessibility = "View menu")
    WebElement mainMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log In\")")
    WebElement loginMenuBtn;

    //constructor
    public AndroidTopBarNavigation(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void clickMenuButton() {
        click(mainMenu);
    }


    @Override
    public void navigateToLoginPage() {
        click(loginMenuBtn);
    }
}
