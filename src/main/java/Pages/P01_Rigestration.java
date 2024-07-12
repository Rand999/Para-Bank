package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_Rigestration {

    WebDriver driver;

    public P01_Rigestration(WebDriver driver) {
        this.driver = driver;
    }


    private final By FIRST_NAME = By.xpath("//input[@id='customer.firstName']");
    private final By LAST_NAME = By.xpath("//input[@id='customer.lastName']");
    private final By ADDRESS = By.xpath("//input[@id='customer.address.street']");

    private final By CITY = By.xpath("//input[@id='customer.address.city']");
    private final By STATE = By.xpath("//input[@id='customer.address.state']");
// -------------------------------------------------------------------------------


    private final By ZIP = By.xpath("//input[@id='customer.address.zipCode']");
    private final By PHONE = By.xpath("//input[@id='customer.phoneNumber']");
    private final By SSN = By.xpath("//input[@id='customer.ssn']");

    // -------------------------------------------------------------------------

    private final By USERNAME = By.xpath("//input[@id='customer.username']");
    private final By PASSWORD = By.xpath("//input[@id='customer.password']");
    private final By CONFIRM_PASSWORD = By.xpath("//input[@id='repeatedPassword']");
    private final By REGESTER_BUTTON = By.xpath("//input[@value='Register']");
//
//private final By REGESTER_BUTTON = By.xpath("//input[normalize-space()='Register']");




    public P01_Rigestration fill_firstname(String f_name) {
        driver.findElement(this.FIRST_NAME).sendKeys(f_name);
        return this;
    }

    public P01_Rigestration fill_lastname(String l_name) {
        driver.findElement(this.LAST_NAME).sendKeys(l_name);
        return this;
    }


    public P01_Rigestration address(String adress) {
        driver.findElement(this.ADDRESS).sendKeys(adress);
        return this;
    }

    public P01_Rigestration fill_state(String state) {
        driver.findElement(this.STATE).sendKeys(state);
        return this;
    }

    public P01_Rigestration fill_city(String city) {
        driver.findElement(this.CITY).sendKeys(city);
        return this;
    }

    public P01_Rigestration fill_zip(String zip) {
        driver.findElement(this.ZIP).sendKeys(zip);
        return this;
    }

    public P01_Rigestration fill_ssn(String ssn) {
        driver.findElement(this.SSN).sendKeys(ssn);
        return this;
    }

    public P01_Rigestration fill_phone(String mobile) {
        driver.findElement(this.PHONE).sendKeys(mobile);
        return this;
    }


    public P01_Rigestration fill_username(String username) {
        driver.findElement(this.USERNAME).sendKeys(username);
        return this;
    }
    public P01_Rigestration fill_paswword(String pass) {
        driver.findElement(this.PASSWORD).sendKeys(pass);
        return this;
    }

    public P01_Rigestration confirm_paswword(String pass) {
        driver.findElement(this.CONFIRM_PASSWORD).sendKeys(pass);
        return this;
    }

    public P01_Rigestration create_account() {
        driver.findElement(this.REGESTER_BUTTON).click();
        return this;
    }

    // -----------------------------------------------------------------------------

    public String check_URL() {
        return  driver.getCurrentUrl();

    }

    public boolean check_text() {
        return  driver.findElement(By.xpath("//*[text()[contains(.,'Enter Account Information')]]")).isDisplayed();

    }


    public boolean check_account_is_created() {
        return  driver.findElement(By.xpath("//p[normalize-space()='Your account was created successfully. You are now logged in.']")).isDisplayed();

    }


    public boolean check_verification_message_is_displayed() {
        return  driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']")).isDisplayed();

    }
}
