package drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected AppiumDriver driver;

    public abstract void createDriver();

    public AppiumDriver getDriver(){
        return this.driver;
    }
}
