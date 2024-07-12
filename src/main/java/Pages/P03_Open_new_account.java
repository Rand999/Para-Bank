package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_Open_new_account {


    WebDriver driver;

    public P03_Open_new_account(WebDriver driver) {
        this.driver = driver;
    }


    private final By ACCOUNT_TYPE = By.xpath("//select[@id='type']");
    //private final By SELECT_ACCOUNT_TYPE = By.xpath("//select[@id='type']/option[]");
    private final By OPEN_BUTTON = By.xpath("//input[@value='Open New Account']");


     private final By NEW_ACCOUNT_LINK = By.xpath("//a[normalize-space()='Open New Account']");





    public P03_Open_new_account view_types() {
        driver.findElement(this.ACCOUNT_TYPE).click();
        return this;
    }

    public P03_Open_new_account click_create_button() {
        driver.findElement(this.OPEN_BUTTON).click();
        return this;
    }


    public P03_Open_new_account click_open_account_link() {
        driver.findElement(this.NEW_ACCOUNT_LINK).click();
        return this;
    }

    public String check_URL() {
        return  driver.getCurrentUrl();

    }

    public boolean check_open_new_account_successfully() {
        return  driver.findElement(By.xpath("//p[normalize-space()='Congratulations, your account is now open.']")).isDisplayed();

    }



}
