/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author morai
 */
public class Main {
    public static void main(String[] args) {
        
        // Lendo arquivo de preferencias
        String preferencesPath = "prefs.txt";
        
        IOManager ioManager;
        DataManager dataManager = new DataManager();
        
        if (args.length == 1)
            preferencesPath = args[0];
        
        try {
            ioManager = new IOManager(preferencesPath);
            ioManager.read(dataManager);
        } catch (IOException ex) {
            System.out.println("Problems to open the necessary files. Please, check the README.md!");
            System.exit(0);
        }
        

        
        
    }
    
}
