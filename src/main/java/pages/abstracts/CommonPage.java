package pages.abstracts;

import Base.BasePage;
import org.openqa.selenium.WebDriver;

import pages.PageFactory;
import pages.abstracts.components.TopBarNavigation;

public class CommonPage extends BasePage {

    private TopBarNavigation topBarNavigation;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.topBarNavigation = PageFactory.getTopBarNavigation();
    }

    public TopBarNavigation getTopBarNavigation() {
        return this.topBarNavigation;
    }
}
