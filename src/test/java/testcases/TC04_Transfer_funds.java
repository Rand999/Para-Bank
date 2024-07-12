package testcases;

import Pages.P03_Open_new_account;
import Pages.P04_Transfer_funds;
import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_Transfer_funds extends Testbase{

    static String  new_account_id;
    @Test(priority = 1,description = "open new account")
    public void Transfer_mony_to_new_account_P() throws InterruptedException {



        new PageBase(driver).Wait();
        new  P04_Transfer_funds(driver).click_transfer_link();
        new PageBase(driver).Wait();
        new  P04_Transfer_funds(driver).input_amount(generateRandomamount());

        new P04_Transfer_funds(driver).select_transfer_to_account();
        new PageBase(driver).Wait();
        new P04_Transfer_funds(driver).transfer();
        new PageBase(driver).Wait();

        Assert.assertTrue(new P04_Transfer_funds(driver).check_transfared_successfully(), " transfer fail");

    }
}
