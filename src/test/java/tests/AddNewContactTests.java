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
        logger.info("Start test with the name `addContactSuccessAllFields`");
        logger.info("Login test data ---> email: 'vorronkovkirill@gmail.com' & password: 'Leet1337!' ");
        int i = (int)(System.currentTimeMillis()/100000 % 3600);
        Contact contact = Contact.builder()
                .name("Tony"+i)
                .lastName("Stark")
                .address("NY")
                .phone("356676"+i)
                .email("stark"+i+"@gmail.com")
                .description("All fields")
                .build();
        logger.info("Test start with test data --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addContactSuccessRequiredFields(){
        logger.info("Start test with the name `addContactSuccessRequiredFields`");
        logger.info("Login test data ---> email: 'vorronkovkirill@gmail.com' & password: 'Leet1337!' ");
        int i = (int)(System.currentTimeMillis()/100000 % 3600);
        Contact contact = Contact.builder()
                .name("Tony"+i)
                .lastName("Stark")
                .address("NY")
                .phone("356678" + i)
                .email("stark" + i + "@gmail.com")
                .build();
        logger.info("Test start with test data --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName(){
        logger.info("Start test with the name `addNewContactWrongName`");
        Contact contact = Contact.builder()
                .name("")
                .lastName("Stark")
                .address("NY")
                .phone("35667665432")
                .email("stark@gmail.com")
                .description("Wrong name")
                .build();
        logger.info("Test start with test data --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);;
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongAddress(){
        logger.info("Start test with the name `addNewContactWrongAddress`");
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("")
                .phone("35667643245")
                .email("stark@gmail.com")
                .description("Wrong address")
                .build();
        logger.info("Test start with test data --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongLastName(){
        logger.info("Start test with the name `addNewContactWrongLastName`");
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("")
                .address("yea")
                .phone("356676545433")
                .email("stark@gmail.com")
                .description("Wrong last")
                .build();
        logger.info("Test start with test data --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongPhone(){
        logger.info("Start test with the name `addNewContactWrongPhone`");
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("yeah")
                .phone("")
                .email("stark@gmail.com")
                .description("Wrong phone")
                .build();
        logger.info("Test start with test data --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
        logger.info("Assert check is alert with error text ` Phone not valid: Phone number must contain only digits! And length min 10, max 15!`");
    }

    @Test
    public void addNewContactWrongEmail(){
        logger.info("Start test with the name `addNewContactWrongEmail`");
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("yeah")
                .phone("3566768787")
                .email("starkgmail.com")
                .description("Wrong email")
                .build();
        logger.info("Test start with test data --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid: must be a well-formed email address"));
        logger.info("Assert check is alert with error text `Email not valid: must be a well-formed email address`");
    }
}

