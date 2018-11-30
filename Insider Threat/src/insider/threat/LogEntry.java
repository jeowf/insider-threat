package insider.threat;

/**
 * Sua instância é passa como parâmetro em métodos do DataManager
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
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
     * Construtor
     * @param logType
     * @param fields
     */
    public LogEntry(LogType logType, String[] fields){
        this.logType = logType;
        this.fields = fields;
    }

    /**
     * Retorna os campos do log
     * @return
     */
    public String[] getFields() {
        return fields;
    }
    
    /**
     * Retorna o tipo de log
     * @return
     */
    public LogType getLogType(){
        return logType;
    }
    
    /**
     * Converte um índice em um tipo de log
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
