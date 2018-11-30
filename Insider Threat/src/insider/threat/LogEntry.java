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
    
    enum LogType{
        USER,
        LOGON,
        DEVICE,
        HTTP
        
    }
    private LogType logType;
    private String[] fields;
    
    /**
     *
     * @param logType
     * @param fields
     */
    public LogEntry(LogType logType, String[] fields){
        this.logType = logType;
        this.fields = fields;
    }

    /**
     *
     * @return
     */
    public String[] getFields() {
        return fields;
    }
    
    /**
     *
     * @return
     */
    public LogType getLogType(){
        return logType;
    }
    
    /**
     *
     * @param i
     * @return
     */
    public static LogType toLogType(int i){
        if (i==0)
            return LogType.USER;
        if (i==1)
            return LogType.LOGON;
        if (i==2)
            return LogType.DEVICE;
        if (i==3)
            return LogType.HTTP;
        return null;
    }
    
    
}
