package tests;

import Models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess(){
        logger.info("Start test with name `registrationSuccess`");
        Random random = new Random();
        int i = random.nextInt(1000);
        //int i = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User().withEmail("don"+i+"@gmail.com").withPassword("Don123456!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }

    @Test(description = "Bug report #12211, Fixed", groups = {"smoke"})
    public void registrationWrongEmail(){
        logger.info("Start test with name `registrationWrongEmail`");
        User user = new User().withEmail("dongmail.com").withPassword("Don123456!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert with error text `Wrong email or password format`");
    }

    @Test
    public void registrationWrongPassword(){
        logger.info("Start test with name `registrationWrongPassword`");
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().withEmail("don"+i+"@gmail.com").withPassword("Don1");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert with error text `Wrong email or password format`");
    }

    @Test
    public void registrationExistsUser(){
        logger.info("Start test with name `registrationExistsUser`");
        User user = new User().withEmail("vorronkovkirill@gmail.com").withPassword("Don1234567!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
        logger.info("Assert check is alert with error text `User already exist`");
    }


}

