package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P04_Transfer_funds {


    WebDriver driver;

    public P04_Transfer_funds(WebDriver driver) {
        this.driver = driver;
    }


    private final By AMOUNT = By.xpath("//input[@id='amount']");

    private final By TRANSFER_LINK = By.xpath("//a[normalize-space()='Transfer Funds']");


    private final By VIEW_ACCOUNTS= By.xpath("//select[@id='toAccountId']");
    private final By SELECT_TO_ACCOUNT = By.xpath("//select[@id='toAccountId']/option[2]");
    private final By TRANSFER_BUTTON = By.xpath("//input[@value='Transfer']");




    public P04_Transfer_funds input_amount(String amount) {
        driver.findElement(this.AMOUNT).sendKeys(amount);
        return this;
    }

    public P04_Transfer_funds select_transfer_to_account() throws InterruptedException {
        driver.findElement(this.VIEW_ACCOUNTS).click();
        Thread.sleep(500);
        driver.findElement(this.SELECT_TO_ACCOUNT).click();
        return this;
    }


    public P04_Transfer_funds click_transfer_link() {
        driver.findElement(this.TRANSFER_LINK).click();
        return this;
    }

    public P04_Transfer_funds transfer() {
        driver.findElement(this.TRANSFER_BUTTON).click();
        return this;
    }

    public String check_URL() {
        return  driver.getCurrentUrl();

    }

    public boolean check_transfared_successfully() {
        return  driver.findElement(By.xpath("//h1[normalize-space()='Transfer Complete!']")).isDisplayed();

    }
}
