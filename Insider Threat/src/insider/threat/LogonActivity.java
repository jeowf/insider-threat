/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

/**
 *
 * @author daniel
 */
public class LogonActivity extends Activity{
    private String value;
    
    /**
     *
     * @param id
     * @param value
     */
    public LogonActivity(String id, String value) {
        super(id);
        this.value = value;
    }

    /**
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     *
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
