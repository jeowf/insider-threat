/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.time.LocalTime;

/**
 *
 * @author daniel
 */
public abstract class Activity extends Field{
    private String id;

    /**
     *
     * @param id
     */
    public Activity(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Id: " + id;
    }

}
