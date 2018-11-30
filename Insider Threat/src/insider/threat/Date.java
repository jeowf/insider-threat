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

    /**
     *
     * @param begDate
     * @param endDate
     */
    public Date(LocalDate begDate, LocalDate endDate) {
        this.beginDate = begDate;
        this.endDate = endDate;
        //this.pcs = new ArrayList<PC>();
        this.pcsMap = new HashMap<String, PC>();
    }

    /**
     *
     * @param pc
     * @param act
     * @param time
     */
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
        //pcsMap.put(pc.getId(), pc);
    }

    /**
     *
     * @return
     */
    public HashMap<String, PC> getPcsMap() {
        return pcsMap;
    }

    /**
     *
     * @param pcsMap
     */
    public void setPcsMap(HashMap<String, PC> pcsMap) {
        this.pcsMap = pcsMap;
    }

    /**
     *
     * @return
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }

    /**
     *
     * @param beginDate
     */
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    /**
     *
     * @return
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
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
