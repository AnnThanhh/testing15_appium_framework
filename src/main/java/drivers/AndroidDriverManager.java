package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigManager;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        //load properties từ config.properties file
        ConfigManager.loadProperties();
        //lấy các giá trị cần thiết từ config.properties file thông qua getProperty method
        String platformName = ConfigManager.getProperty("platform");
        String UiAutomator2 = "UiAutomator2";
        String udid = ConfigManager.getProperty("android.udid");
        String deviceName = ConfigManager.getProperty("android.deviceName");
        String appPackage = ConfigManager.getProperty("android.package");
        String appActivity = ConfigManager.getProperty("android.startActivity");
        String host = ConfigManager.getProperty("appium.host");
        String port = ConfigManager.getProperty("appium.port");

        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName(platformName);
        androidOptions.setAutomationName(UiAutomator2);
        androidOptions.setUdid(udid);
        androidOptions.setDeviceName(deviceName);
        androidOptions.setAppPackage(appPackage);
        androidOptions.setAppActivity(appActivity);

        try{
             this.driver = new AndroidDriver(new URL("http://" + host + ":" + port + "/"), androidOptions);
        }catch (MalformedURLException e){
            throw new RuntimeException();
        }

    }
}
