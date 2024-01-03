package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("vorronkovkirill@gmail.com").withPassword("Leet1337!"))
        }
    }

    @Test
    public void addContactSuccessAllFields(){

    }

    @Test
    public void addContactSuccessRequiredFields(){

    }
}

