package insider.threat;

/**
 * Representa a atividade de dispositivo
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class DeviceActivity extends Activity {
    private String value;

    /**
     * Construtor
     * @param id
     * @param value
     */
    public DeviceActivity(String id, String value) {
        super(id);
        this.value = value;
    }

    /**
     * Recebe o valor da atividade
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Altera o valor da atividade
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Device: " + value;
    }
}
