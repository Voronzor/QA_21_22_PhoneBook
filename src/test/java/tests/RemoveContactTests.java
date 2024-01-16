package tests;

import Models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("vorronkovkirill@gmail.com").withPassword("Leet1337!"));
        }
        //if list<3 ==>add 3 contacts
        app.getHelperContact().provideContacts();


    }

    @Test
    public void removeOneContact(){
        logger.info("Start test with name `removeOneContact`");
        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);
        //Assert size list less by 1

    }
    @Test
    public void removeAllContacts(){
        logger.info("Start test with name `removeAllContacts`");
        app.getHelperContact().removeAllContact();
        Assert.assertEquals(app.getHelperContact().getMessage(), "No Contacts here!");
        logger.info("Assert check with text `No Contacts here!`");
        //"No contacts here"
    }
}
