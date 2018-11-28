/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class TesteLeitura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TesteLeitura obj = new TesteLeitura();
        obj.run2();
    }

    private void run() {
        ArrayList<String> files = new ArrayList();
        files.add("data/ldap.csv");
        files.add("data/logon.csv"); 
        files.add("data/device.csv");
        files.add("data/http.csv");
        String arquivoCSV = files.get(0);
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        Node<Field> root = new Node<Field>(null);
        Tree<Field> tree = new Tree<Field>(root);
        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            boolean primeira_linha = true;
            
            while ((linha = br.readLine()) != null) {
                if (primeira_linha == false)
                {
                    String[] usuarios = linha.split(csvDivisor);
                    
                    String name = usuarios[0];
                    String id = usuarios[1];
                    String domain = usuarios[2];
                    String email = usuarios[3];
                    String role = usuarios[4];
                    
                    User user = new User(id, name, domain, email, role);
                    Node<Field> userNode = new Node<Field>(user);
                    tree.insert(userNode);
                }
                else
                {
                    primeira_linha = false;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        tree.print();

    }
    
     private void run2() {
        ArrayList<String> files = new ArrayList();
        files.add("data/ldap.csv");
        files.add("data/logon.csv"); 
        files.add("data/device.csv");
        files.add("data/http.csv");
        String arquivoCSV = files.get(0);
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        DataManager dmanager = new DataManager();
        Node<User> root = dmanager.getTree().getRoot();
        Tree<User> tree = dmanager.getTree();
        boolean primeira_linha;
        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            primeira_linha = true;
            
            while ((linha = br.readLine()) != null) {
                if (primeira_linha == false)
                {
                    String[] usuarios = linha.split(csvDivisor);
                    
                    String name = usuarios[0];
                    String id = usuarios[1];
                    String domain = usuarios[2];
                    String email = usuarios[3];
                    String role = usuarios[4];
                    
                    User user = new User(id, name, domain, email, role);
                    Node<User> userNode = new Node<User>(user);
                    tree.insert(userNode);
                }
                else
                {
                    primeira_linha = false;
                }
            }
            String file = files.get(1);
            //for (String file: files)
            //{
                br = new BufferedReader(new FileReader(file));
                primeira_linha = true;
                while ((linha = br.readLine()) != null) {
                    if("data/logon.csv".equals(file))
                    {
                        if (false == primeira_linha)
                        {
                            String[] teste = linha.split(csvDivisor);
                            String id = teste[0];
                            String date = teste[1];
                            String user = teste[2];
                            String[] splitDate = date.split(" ");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                            LocalDate dateTime= LocalDate.parse(splitDate[0], formatter);
                            Date d = new Date(dateTime);
                            User newUser =  new User(user.split("/")[1], null, null, null, null);
                            Node<User> nuser = tree.search(newUser);
                            nuser.getValue().insert(d);
                        }
                        else
                        {
                            primeira_linha = false;
                        }
                    }
                }
            //}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        tree.print();

    }
    
}
