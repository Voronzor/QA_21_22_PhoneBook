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
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkirill@gmail.com", "Leet1337!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkirill@gmail.com", "Leet1337!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }

    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkirillgmail.com", "Leet1337!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkirill@gmail.com", "eet1337!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vorronkovkeril@gmail.com", "Leettt1337!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

}
