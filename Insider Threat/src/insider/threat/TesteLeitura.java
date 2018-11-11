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
        String arquivoCSV = "data/2009-12.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
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

    }
    
}
