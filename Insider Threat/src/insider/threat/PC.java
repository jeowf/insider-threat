/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class PC extends Field{
    private String id;
    
    private HashMap<String, Activity> activities;

    public PC(String id) {
        this.id = id;
        this.activities = new HashMap<String, Activity>();
    }
    
    public void insert (Activity act, String time)
    {
        if(activities.get(act.getId()) == null)
        {
            addtoHistogram(time);
            act.addtoHistogram(time);
            //System.out.println(act.getId());
            activities.put(act.getId(), act);
        }
        else
        {
            System.out.println("'"+activities.get(act.getId()).getId());
            addtoHistogram(time);
            Activity activity = activities.get(act.getId());
            activity.addtoHistogram(time);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Activity> getActivities() {
        return activities;
    }

    public void setActivities(HashMap<String, Activity> activities) {
        this.activities = activities;
    }

    
}
