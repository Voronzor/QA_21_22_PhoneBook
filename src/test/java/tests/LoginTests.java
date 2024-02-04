package tests;

import Models.User;
import manager.DataProviderUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase{


    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //if SingOut present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password){
        logger.info("Start test with name `loginSuccess`");
        logger.info("Test data ---> email: " +email+ "& password: " +password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button `Sign Out` present");

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }

    @Test(dataProvider = "loginFile", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user){
        logger.info("Test data ---> " + user.toString());

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button `Sign Out` present");
    }


    @Test(dataProvider = "loginModels", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user){
        logger.info("Test data ---> " + user.toString());

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button `Sign Out` present");

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }

    @Test(groups = {"smoke"})
    public void loginWrongEmail(){
        logger.info("Start test with name `loginWrongEmail`");
        logger.info("Test data ---> email: 'vorronkovkirillgmail.com' & password: 'Leet1337!' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkirillgmail.com", "Leet1337!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text `Wrong email or password`");
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Start test with name `loginWrongPassword`");
        logger.info("Test data ---> email: 'vorronkovkirill@gmail.com' & password: 'eet1337!' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkirill@gmail.com", "eet1337!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text `Wrong email or password`");
    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Start test with name `loginUnregisteredUser`");
        logger.info("Test data ---> email: 'vorronkovkeril@gmail.com' & password: 'Leettt1337!' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkeril@gmail.com", "Leettt1337!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text `Wrong email or password`");
    }

}
