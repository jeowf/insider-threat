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
    
    private DataManager dataManager;
    private BufferedReader preferences;
    private String[] files;
            
    public IOManager(DataManager dataManager, String preferencesFile) throws FileNotFoundException, IOException {
        files = new String[5];
        
        this.dataManager = dataManager;
        preferences = new BufferedReader(new FileReader(preferencesFile));
        
        String line = "";
        
        while( (line = preferences.readLine() ) != null){
            String [] fields = line.split(" ");
            int index = toIndex(fields[0]);
            if (fields.length == 2 && index != -1){
                files[index] = fields[1];
            }
        }
        
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null)
                throw new IOException();
        }
    }

    private int toIndex(String fileType){
        
        if (fileType.contains("users"))
            return 0;
        
        if (fileType.contains("logons"))
            return 1;
        
        if (fileType.contains("devices"))
            return 2;
        
        if (fileType.contains("https"))
            return 3;
        
        if (fileType.contains("out"))
            return 4;

        return -1;
    }
    
    public LogEntry readUser() throws FileNotFoundException, IOException{
        
        BufferedReader br;
        boolean first_line = true;
        String line = "";
        br = new BufferedReader(new FileReader(files[0]));
        
        while ( (line = br.readLine()) != null ){
            
        }
        
        return null;
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
