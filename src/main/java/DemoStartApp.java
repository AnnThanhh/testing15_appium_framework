import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoStartApp {
    public static void main(String[] args) throws MalformedURLException {
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

        //bước 2: click login

        //bước 3: nhập username và password

        //bước 4: click login button

        //bước 5: verify valid account login successfully


        driver.quit();
    }
}
