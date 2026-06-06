package drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        XCUITestOptions iosOption = new XCUITestOptions();
        iosOption.setPlatformName("ios");
        iosOption.setAutomationName("XCUITest");
        iosOption.setDeviceName("iPhone 17 Pro Max");
        iosOption.setUdid("07C579B9-11C0-47C9-85CE-D8E556917C41");
        iosOption.setApp("com.saucelabs.mydemo.app.ios");

        try{
            IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/"), iosOption);
        }catch(MalformedURLException e){
            throw new RuntimeException();
        }
    }
}
