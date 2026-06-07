package pages;

import drivers.DriverFactory;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;
import pages.abstracts.components.TopBarNavigation;
import pages.android.AndroidHomePage;
import pages.android.AndroidLoginPage;
import pages.android.components.AndroidTopBarNavigation;
import pages.ios.IOSHomePage;
import pages.ios.IOSLoginPage;
import pages.ios.components.IOSTopBarNavigation;
import utils.PlatformUtil;

public class PageFactory {
    public static HomePage getHomePage(){
        if(PlatformUtil.isAndroid()){
            return new AndroidHomePage(DriverFactory.getDriver());
        }else{
            return new IOSHomePage(DriverFactory.getDriver());
        }
    }

    public static LoginPage getLoginPage(){
        if(PlatformUtil.isAndroid()){
            return new AndroidLoginPage(DriverFactory.getDriver());
        }else{
            return new IOSLoginPage(DriverFactory.getDriver());
        }
    }

    public static TopBarNavigation getTopBarNavigation(){
        if(PlatformUtil.isAndroid()){
            return new AndroidTopBarNavigation(DriverFactory.getDriver());
        }else{
            return new IOSTopBarNavigation(DriverFactory.getDriver());
        }
    }
}
