package drivers;

import io.appium.java_client.AppiumDriver;

public class DriverFactory {
    private static ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();

    // Phương thức để thiết lập AppiumDriver cho Thread hiện tại
    public static void setDriverThreadLocal(AppiumDriver driver){
        driverThreadLocal.set(driver);
    }

    // Phương thức để lấy AppiumDriver của Thread hiện tại
    public static AppiumDriver getDriver(){
        return driverThreadLocal.get();
    }

    // Phương thức để xóa AppiumDriver của Thread hiện tại
    public static void removeDriver(){
        driverThreadLocal.remove();
    }
}
