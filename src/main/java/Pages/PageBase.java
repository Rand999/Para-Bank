package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PageBase {


    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }


    private final By REGISTER_LINK = By.xpath("//a[normalize-space()='Register']");


  //  private final By PRODUCTS_TAB = By.xpath("//a[@href='/products']");
   // private final By TESTCASES_TAB = By.xpath("//a[@href='/test_cases']");

   // private final By CONTACTUS_TAB = By.xpath("//a[@href='/contact_us']");

    private final By LOGOUT = By.xpath("//a[normalize-space()='Logout']");




    /*public PageBase searchFunction(String keyword) {
        driver.findElement(this.SEARCH_BOX).sendKeys(keyword, Keys.ENTER);

        return this;
    }*/

    public PageBase click_regester_link() {
        driver.findElement(this.REGISTER_LINK).click();
        return this;
    }




    public PageBase click_logout() {
        driver.findElement(this.LOGOUT).click();
        return this;
    }


    public PageBase scroll_down() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,360)", "");
        return this;
    }

    public PageBase Wait () throws InterruptedException {
        Thread.sleep(1300);
        return this;
    }

    public static void explicitWait(WebDriver driver, By element) {
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        // in action call it as following   pagebase.explicitWait(driver,LOGIN_BUTTON)
    }

    // long explicit wait
    public static WebDriverWait longWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    // short explicit wait
    public static WebDriverWait shortWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }


  /*  public static void fluentWaitHandling(WebDriver driver, String webElementXPATH) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementXPATH)));
}*/

    // TODO: Capture Screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/" + screenshotName + System.currentTimeMillis() + ".png"));
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
