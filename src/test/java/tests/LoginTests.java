package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @BeforeMethod
    public void preCondition(){
        //if SingOut present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test
    public void loginSuccess(){
        logger.info("Start test with name `loginSuccess`");
        logger.info("Test data ---> email: 'vorronkovkirill@gmail.com' & password: 'Leet1337!' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkirill@gmail.com", "Leet1337!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button `Sign Out` present");

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }
    @Test
    public void loginSuccessModel(){
        logger.info("Start test with name `loginSuccessModel`");
        logger.info("Test data ---> email: 'vorronkovkirill@gmail.com' & password: 'Leet1337!' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkirill@gmail.com", "Leet1337!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button `Sign Out` present");

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }

    @Test
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
