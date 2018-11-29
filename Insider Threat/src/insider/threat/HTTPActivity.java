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
public class HTTPActivity extends Activity{
    private String url;

    public HTTPActivity(String id, String utl) {
        super(id);
        this.url = utl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
