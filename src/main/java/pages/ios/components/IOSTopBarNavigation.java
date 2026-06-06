package pages.ios.components;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.abstracts.components.TopBarNavigation;

public class IOSTopBarNavigation extends TopBarNavigation {
    @iOSXCUITFindBy(accessibility = "More-tab-item")
    WebElement mainMenu;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    WebElement loginMenuBtn;

    public IOSTopBarNavigation(WebDriver driver) {
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
