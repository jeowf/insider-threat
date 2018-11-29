/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

/**
 *
 * @author felipemorais2013
 */
public class LogEntry {
    
    public enum Action{
        SEARCH,
        INSERT
    }
    
    private Action action;
    private String[] fields;
    
    public LogEntry(Action action, String[] fields){
        this.action = action;
        this.fields = fields;
    }

    public Action getAction() {
        return action;
    }

    public String[] getFields() {
        return fields;
    }
    
    
    
}
