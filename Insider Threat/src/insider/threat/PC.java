package insider.threat;

import java.util.HashMap;

/**
 * Representa os dispositivos
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class PC extends Field{
    private String id;
    
    private HashMap<String, Activity> activities;

    /**
     * Construtor
     * @param id
     */
    public PC(String id) {
        this.id = id;
        this.activities = new HashMap<String, Activity>();
    }
    
    /**
     * Insere uma atividade
     * @param act
     * @param time
     */
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

    /**
     * Recupera Id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Altera o id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Recupera as atividades filhas desse dispositivo
     * @return
     */
    public HashMap<String, Activity> getActivities() {
        return activities;
    }

    /**
     * Altera as atividades filhas desse dispositivo
     * @param activities
     */
    public void setActivities(HashMap<String, Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Total of Activities: " + activities.size();
    }
    
    

    
}
