package testcases;

import Pages.P02_Login;
import Pages.P03_Open_new_account;
import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static testcases.TC01_Regestration.Reg_password;
import static testcases.TC01_Regestration.UserName;

public class TC03_Open_new_account extends Testbase{

 static String  new_account_id;
    @Test(priority = 1,description = "open new account")
    public void Open_new_account_P() throws InterruptedException {



        new PageBase(driver).Wait();
        new P03_Open_new_account(driver).click_open_account_link();
        new PageBase(driver).Wait();

        new P03_Open_new_account(driver).view_types();
        WebElement type = driver.findElement(By.xpath("//select[@id='type']/option["+generateRandomnumber()+"]"));
        type.click();

        new PageBase(driver).Wait();
        new P03_Open_new_account(driver).click_create_button();
        new PageBase(driver).Wait();

        Assert.assertTrue(new P03_Open_new_account(driver).check_open_new_account_successfully(), " open account fail");
       new_account_id= driver.findElement(By.xpath("//a[@id='newAccountId']")).getText();

       System.out.println(new_account_id);
    }



}
