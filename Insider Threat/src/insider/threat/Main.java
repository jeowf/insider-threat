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
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class Main {

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {

        // Lendo arquivo de preferencias
        String preferencesPath = "prefs.txt";

        IOManager ioManager;
        DataManager dataManager = new DataManager();
        CommandHandler ch;

        LocalDate beginDate = null;//LocalDate.of(2010, 1, 4);
        LocalDate endDate = null;//LocalDate.of(2010, 12, 5);

        if (args.length == 1) {
            preferencesPath = args[0];
        }

        System.out.println("Reading " + preferencesPath);

        try {
            ioManager = new IOManager(preferencesPath);
            ioManager.read(dataManager);
            ch = new CommandHandler(ioManager, dataManager);
            
            Scanner scan = new Scanner(System.in);
            System.out.println("All files have been read correctly.");
            System.out.println("Insert your commands. Check all the command in README.md");
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
