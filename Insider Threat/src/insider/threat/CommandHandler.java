/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

/**
 *
 * @author morai
 */
public class CommandHandler {
    
    private IOManager ioManager;
    private DataManager dataManager;
    
    private User user;
    private PC pc;
    private Activity act;

    public CommandHandler(IOManager ioManager, DataManager dataManager) {
        this.ioManager = ioManager;
        this.dataManager = dataManager;
    }

    public IOManager getIoManager() {
        return ioManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
    
    public void execute(String s){
        boolean valid = false;
        
        String [] fields = s.split(" ");
        
        if (fields.length > 0){
          
            
            
        } 
        
        
    }
    
    
    
}
