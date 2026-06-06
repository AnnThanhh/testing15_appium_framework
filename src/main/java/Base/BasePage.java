package Base;

import Constants.TimeOutConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //thuộc tính
    protected WebDriver driver;
    protected final Logger LOG = LogManager.getLogger(getClass());
    public BasePage(WebDriver webDriver){
        this.driver = webDriver;
    }

    //phương thức
    public WebElement waitForElementVisible(By locator, long timeOutInSec){
        LOG.info("Waiting for element visible with locator: " + locator.toString() + " and timeout: " + timeOutInSec + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement waitForElementClickable(By locator, long timeOutInSec){
        LOG.info("Waiting for element clickable with locator: " + locator.toString() + " and timeout: " + timeOutInSec + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public WebElement waitForElementClickable(WebElement element, long timeOutInSec){
        LOG.info("Waiting for element clickable: " + element.toString() + " and timeout: " + timeOutInSec + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementVisible(WebElement element, long timeOutInSec){
        LOG.info("Waiting for element visible with locator: " + element.toString() + " and timeout: " + timeOutInSec + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void inputText(By locator, String text, long timeOutInSec){
        LOG.info("Inputting text: '" + text + "' into element with locator: " + locator.toString() + " and timeout: " + timeOutInSec + " seconds");
        //code nhập text vào ô input
        WebElement element = waitForElementVisible(locator, timeOutInSec);
        element.sendKeys(text);
    }

    public void inputText(By locator, String text){
        inputText(locator, text, TimeOutConstants.TIME_OUT_DEFAULT);
    }

    public void inputText(WebElement element, String text, long timeOutInSec){
        LOG.info("Inputting text: '" + text + "' into element: " + element.toString() + " and timeout: " + timeOutInSec + " seconds");
        waitForElementVisible(element, timeOutInSec).sendKeys(text);
    }

    public void inputText(WebElement element, String text){
        inputText(element, text, TimeOutConstants.TIME_OUT_DEFAULT);
    }

    public void click(By locator, long timeOutInSec){
        LOG.info("Clicking on element with locator: " + locator.toString() + " and timeout: " + timeOutInSec + " seconds");
        WebElement btn = waitForElementClickable(locator, timeOutInSec);
        btn.click();
    }
    public void click(By locator){
        click(locator, TimeOutConstants.TIME_OUT_DEFAULT);
    }

    public void click(WebElement element, long timeOutInSec){
        LOG.info("Clicking on element: " + element.toString() + " and timeout: " + timeOutInSec + " seconds");
        waitForElementClickable(element, timeOutInSec).click();
    }

    public void click(WebElement element){
        click(element, TimeOutConstants.TIME_OUT_DEFAULT);
    }

    public String getText(By locator, long timeOutInSect){
        LOG.info("Getting text from element with locator: " + locator.toString() + " and timeout: " + timeOutInSect + " seconds");
        WebElement element = waitForElementVisible(locator, timeOutInSect);
        return element.getText();
    }

    public String getText(By locator){
        return getText(locator, TimeOutConstants.TIME_OUT_DEFAULT);
    }

    public String getText(WebElement element, long timeOutInSec){
        LOG.info("Getting text from element: " + element.toString() + " and timeout: " + timeOutInSec + " seconds");
        return waitForElementVisible(element, timeOutInSec).getText();
    }

    public String getText(WebElement element){
        return getText(element, TimeOutConstants.TIME_OUT_DEFAULT);
    }
}
