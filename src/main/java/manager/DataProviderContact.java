package manager;

import Models.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
            Contact.builder()
                    .name("John")
                    .lastName("Wick")
                    .email("kohn@gmail.com")
                    .address("NY")
                    .phone("123")
                    .description("The best")
                    .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("John")
                        .lastName("Wick")
                        .email("kohn@gmail.com")
                        .address("NY")
                        .phone("12344444444444444444")
                        .description("The best")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("John")
                        .lastName("Wick")
                        .email("kohn@gmail.com")
                        .address("NY")
                        .phone("qqqqqqqqqqqq")
                        .description("The best")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("John")
                        .lastName("Wick")
                        .email("kohn@gmail.com")
                        .address("NY")
                        .phone("")
                        .description("The best")
                        .build()
        });
        return list.iterator();

    }

        @DataProvider
        public Iterator<Object[]> contactSuccess() {
            List<Object[]> list = new ArrayList<>();
            list.add(new Object[]{
                    Contact.builder()
                            .name("Tony")
                            .lastName("Stark")
                            .address("NY")
                            .phone("1234567890")
                            .email("stark@gmail.com")
                            .description("All fields")
                            .build()

            });
            list.add(new
                    Object[]{
                                    Contact.builder()
                                            .name("Tony")
                                            .lastName("Stark")
                                            .address("NY")
                                            .phone("3332221115")
                                            .email("stark@gmail.com")
                                            .build()
            });

            return list.iterator();
        }

}

