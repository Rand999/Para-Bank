package testcases;

import Pages.P01_Rigestration;
import Pages.P02_Login;
import Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

//import static testcases.TC01_Regestration.Reg_email;
import static testcases.TC01_Regestration.Reg_password;
import static testcases.TC01_Regestration.UserName;

public class TC02_Login extends Testbase{


    @Test(priority = 1,description = "Login to System with Valid Data")
    public void Login_with_valid_data_P() throws InterruptedException {

       new PageBase(driver).click_regester_link();

        new PageBase(driver).Wait();
        new P02_Login(driver).fill_username(UserName).fill_pass(Reg_password);
        new P02_Login(driver).click_login_button();
        new PageBase(driver).Wait();

        System.out.println(UserName +"    " +Reg_password);
       // Assert.assertTrue(new P02_Login(driver).check_login_successfully(), " login fail");


    }



}
