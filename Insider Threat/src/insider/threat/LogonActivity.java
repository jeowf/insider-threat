package insider.threat;

/**
 * Representa a atividade de logon
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class LogonActivity extends Activity{
    private String value;
    
    /**
     * Construtor
     * @param id
     * @param value
     */
    public LogonActivity(String id, String value) {
        super(id);
        this.value = value;
    }

    /**
     * Acessa o valor da atividade
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Modifica o valor da atividade
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Logon: " + value;
    }
        
}
