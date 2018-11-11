/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.io.BufferedReader;

/**
 *
 * @author daniel
 */
public class IOManager {
    private BufferedReader in_file;
    
    private BufferedReader out_file;

    public IOManager() {
    }

    public BufferedReader getIn_file() {
        return in_file;
    }

    public void setIn_file(BufferedReader in_file) {
        this.in_file = in_file;
    }

    public BufferedReader getOut_file() {
        return out_file;
    }

    public void setOut_file(BufferedReader out_file) {
        this.out_file = out_file;
    }
    
    
    
    
}
