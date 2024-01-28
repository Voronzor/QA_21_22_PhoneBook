package manager;

import Models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/data.csv")));
        String line = reader.readLine();// vorronkovkirill@gmail.com,Leet1337!
        while(line!=null){
            String[] all = line.split(","); //["vorronkovkirill@gmail.com"] ["Leet1337!"]
            list.add(new Object[]{
                    new User().withEmail(all[0]).withPassword(all[1])});
            line = reader.readLine(); //sonya@gmail.com,Ss12345$


        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"vorronkovkirill@gmail.com", "Leet1337!"});
        list.add(new Object[]{"vorronkovkirill@gmail.com", "Leet1337!"});


        return list.listIterator();
    }
    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("vorronkovkirill@gmail.com").withPassword("Leet1337!")});
        list.add(new Object[]{new User().withEmail("sonya@gmail.com").withPassword("Ss12345$")});

        return list.iterator();
    }




}
