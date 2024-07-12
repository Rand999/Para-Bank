package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login {

    WebDriver driver;

    public P02_Login(WebDriver driver) {
        this.driver = driver;
    }


    private final By USERNAME = By.xpath("//input[@name='username']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By Login_BUTTON = By.xpath("//input[@value='Log In']");
   // private final By DELETE_ACCOUNT = By.xpath("//a[normalize-space()='Delete Account']");





    public P02_Login fill_username(String username) {
        driver.findElement(this.USERNAME).sendKeys(username);
        return this;
    }

    public P02_Login fill_pass(String pass) {
        driver.findElement(this.PASSWORD).sendKeys(pass);
        return this;
    }

    public P02_Login click_login_button() {
        driver.findElement(this.Login_BUTTON).click();
        return this;
    }


   /* public P02_Login click_delete_account() {
        driver.findElement(this.DELETE_ACCOUNT).click();
        return this;
    }*/

    public String check_URL() {
        return  driver.getCurrentUrl();

    }


    public boolean check_login_successfully() {
        return  driver.findElement(By.xpath("//h1[normalize-space()='Accounts Overview']")).isDisplayed();

    }
}
