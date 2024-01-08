package tests;

import Models.Contact;
import Models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.name;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("vorronkovkirill@gmail.com").withPassword("Leet1337!"));
        }
    }

    @Test
    public void addContactSuccessAllFields(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .phone("356678"+i)
                .email("stark"+i+"@gmail.com")
                .description("The best")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

    }

    @Test
    public void addContactSuccessRequiredFields(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .phone("356678" + i)
                .email("stark" + i + "@gmail.com")

                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
    }

    @Test
    public void addNewContactWrongName(){

    }

    @Test
    public void addNewContactWrongAddress(){

    }

    @Test
    public void addNewContactWrongLastName(){

    }

    @Test
    public void addNewContactWrongPhone(){

    }

    @Test
    public void addNewContactWrongEmail(){

    }
}

