package pages.abstracts.components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class TopBarNavigation extends BasePage {

    public TopBarNavigation(WebDriver driver) {
        super(driver);
    }

    public abstract void navigateToRegisterPage();

    public abstract void navigateToLoginPage();
}
