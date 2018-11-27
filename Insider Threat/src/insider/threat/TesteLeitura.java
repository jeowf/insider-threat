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
        obj.run();
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
    
}
