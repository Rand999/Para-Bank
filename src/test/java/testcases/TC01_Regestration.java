package testcases;

import Pages.P01_Rigestration;
import Pages.PageBase;
import Utility.Utilities;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.PageBase.captureScreenshot;

public class TC01_Regestration extends Testbase {

    //String username = Utility.Utilities.getRandomFirstName();

    String state = faker.country().capital();
    static String UserName;
    String zip = Utilities.getSingleJsonData(System.getProperty("user.dir")+"\\src\\test\\resources\\test_data\\regesterdata.json","ZIP");

     String phone = Utilities.getSingleJsonData(System.getProperty("user.dir")+"\\src\\test\\resources\\test_data\\regesterdata.json","PHONE");;

     String ssn = Utilities.getSingleJsonData(System.getProperty("user.dir")+"\\src\\test\\resources\\test_data\\regesterdata.json","SSN");;

     String first_name =Utilities.getExcelData(0,0,"regester");
    String last_name =Utilities.getExcelData(1,0,"regester");
    String address =Utilities.getExcelData(2,0,"regester");
    String city =Utilities.getExcelData(3,0,"regester");

    static String Reg_password;

    public TC01_Regestration() throws IOException, ParseException {
    }


    // check login positive scenarios
    @Test(priority = 1, description = "register with Valid Username and Password")
    public void Regester_User_P() throws InterruptedException {

        UserName = Utility.Utilities.getRandomUsertName();
        Reg_password = Utility.Utilities.generateRandomPassword(9, 1, 7, 5, 1);
        new PageBase(driver).click_regester_link();
        new PageBase(driver).Wait();

      new P01_Rigestration(driver).fill_firstname(first_name)
                .fill_lastname(last_name)
                .address(address)
                .fill_city(city);
        captureScreenshot(driver, "regester positive - reading data from excle");

        //---------------------------------------------------------------------
        new P01_Rigestration(driver).fill_state(state);
        new PageBase(driver).Wait();
        captureScreenshot(driver, "regester positive - java faker being used");
        new PageBase(driver).Wait();

        //--------------------------------------------------------------------------
        new PageBase(driver).Wait();
        new PageBase(driver).Wait();
        new P01_Rigestration(driver)
                .fill_zip(zip)
                .fill_phone(phone)
                .fill_ssn(ssn);
        captureScreenshot(driver, "regester positive - json being used");
        new PageBase(driver).Wait();

//----------------------------------------------------------------------------------------
       new P01_Rigestration(driver)
               .fill_username(UserName)
               .fill_paswword(Reg_password)
               .confirm_paswword(Reg_password);

        captureScreenshot(driver, "regester positive - java being used");
        // --------------------------------------------------------------------------

        //Assert.assertTrue(new P01_Rigestration(driver).check_text(), "Enter Account Information");


        new PageBase(driver).Wait();

        new P01_Rigestration(driver).create_account();
        System.out.println(UserName +"    " +Reg_password);
      // Assert.assertTrue(new P01_Rigestration(driver).check_account_is_created(), " regester fail");


    }


}



