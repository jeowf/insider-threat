/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author felipemorais2013
 */
public class Date extends Field implements Comparable<Date>{
    private LocalDate beginDate;
    
    private LocalDate endDate;
    
    //private ArrayList<PC> pcs;
    
    private HashMap<String, PC> pcsMap;

    public Date(LocalDate begDate) {
        this.beginDate = begDate;
        this.endDate = null;
        //this.pcs = new ArrayList<PC>();
        this.pcsMap = new HashMap<String, PC>();
    }

    public void insertPC(PC pc, Activity act, String time )
    {
        //pcs.add(pc);
        if (pcsMap.get(pc.getId()) == null)
        {
            pc.insert(act, time);
            addtoHistogram(time);
            pcsMap.put(pc.getId(), pc);
        }
        else{
            pcsMap.get(pc.getId()).insert(act, time);
            addtoHistogram(time);
            //pcsMap.put(pc.getId(), pc);
            
        }
        pcsMap.put(pc.getId(), pc);
    }

    public HashMap<String, PC> getPcsMap() {
        return pcsMap;
    }

    public void setPcsMap(HashMap<String, PC> pcsMap) {
        this.pcsMap = pcsMap;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public int compareTo(Date d) {
        if(d.getBeginDate() == beginDate)
        {
            return 0;
        }
        return -1;
    }
    
    
    
}
