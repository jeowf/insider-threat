/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author felipemorais2013
 */
public class Date extends Field implements Comparable<Date>{
    private LocalDate beginDate;
    
    private LocalDate endDate;
    
    private ArrayList<PC> pcs;

    public Date(LocalDate begDate) {
        this.beginDate = begDate;
        this.endDate = null;
        this.pcs = new ArrayList<PC>();
    }

    public void insertPC(PC pc)
    {
        pcs.add(pc);
    }
    
    public ArrayList<PC> getPcs() {
        return pcs;
    }

    public void setPcs(ArrayList<PC> pcs) {
        this.pcs = pcs;
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
