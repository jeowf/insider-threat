/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import org.jfree.ui.RefineryUtilities;

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
        CommandHandler ch;

        LocalDate beginDate = LocalDate.of(2010, 1, 4);
        LocalDate endDate = LocalDate.of(2010, 12, 5);

        if (args.length == 1) {
            preferencesPath = args[0];
        }

        System.out.println("Reading " + preferencesPath);

        try {
            ioManager = new IOManager(preferencesPath);
            ioManager.read(dataManager, beginDate, endDate);
            //ioManager.writeOutput(dataManager.generateAnalyze("Foreman", beginDate, endDate));
            ch = new CommandHandler(ioManager, dataManager);
            
            Scanner scan = new Scanner(System.in);

            String command = "";
            
            while (!command.equals("quit")) {
                ch.info();
                command = scan.nextLine();
                ch.execute(command);
            }

            System.out.println("Quitting...");
            
        } catch (IOException ex) {
            System.out.println("Problems to open the necessary files. Please, check the README.md!");
            System.exit(0);
        }

        System.exit(0);
    }

}
