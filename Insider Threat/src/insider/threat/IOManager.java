/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class IOManager {
    //private BufferedReader in_file;

    //private BufferedReader out_file;
    private enum FileType {
        USERS,
        LOGONS,
        DEVICES,
        HTTPS,
        OUT
    };

    private static final String CSV_DIVISOR = ",";

    private BufferedReader preferences;
    private String[] files;

    public IOManager(String preferencesFile) throws FileNotFoundException, IOException {
        files = new String[5];

        preferences = new BufferedReader(new FileReader(preferencesFile));

        String line = "";

        while ((line = preferences.readLine()) != null) {
            String[] fields = line.split(" ");
            int index = toIndex(fields[0]);
            if (fields.length == 2 && index != -1) {
                files[index] = fields[1];
            }
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                throw new IOException();
            }
        }
    }

    private int toIndex(String fileType) {

        if (fileType.contains("users")) {
            return 0;
        }

        if (fileType.contains("logons")) {
            return 1;
        }

        if (fileType.contains("devices")) {
            return 2;
        }

        if (fileType.contains("https")) {
            return 3;
        }

        if (fileType.contains("out")) {
            return 4;
        }

        return -1;
    }

    public void read(DataManager dataManager, LocalDate beginDate, LocalDate endDate) throws IOException {
        for (int i = 0; i < 4; i++) {
            read(dataManager, i, beginDate, endDate);
        }
    }

    private void read(DataManager dataManager, int type, LocalDate beginDate, LocalDate endDate) throws FileNotFoundException, IOException {

        boolean first_line = true;
        String line = "";
        if(type == 3)
        {
            first_line = false;
        }
        BufferedReader br = new BufferedReader(new FileReader(files[type]));

        while ((line = br.readLine()) != null) {
            if (first_line) {
                first_line = false;
            } else {
                String[] fields = line.split(CSV_DIVISOR);
                LogEntry le = new LogEntry(LogEntry.toLogType(type), fields);
                dataManager.processLog(le, beginDate, endDate);
            }
        }

        br.close();

    }

    public void writeOutput(LinkedHashMap<String, Double> out) {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(files[toIndex("out")]), "utf-8"))) {
            
            for (Map.Entry<String, Double> pair : out.entrySet()) {
                 writer.write(pair.getKey() + " : " + pair.getValue() + " \n");
            }
        } catch (IOException ex) {
            Logger.getLogger(IOManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

//    public BufferedReader getIn_file() {
//        return in_file;
//    }
//
//    public void setIn_file(BufferedReader in_file) {
//        this.in_file = in_file;
//    }
//
//    public BufferedReader getOut_file() {
//        return out_file;
//    }
//
//    public void setOut_file(BufferedReader out_file) {
//        this.out_file = out_file;
//    }
}
