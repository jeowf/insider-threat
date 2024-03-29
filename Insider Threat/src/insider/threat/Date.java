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
 * Representação da janela de tempo
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class Date extends Field implements Comparable<Date>{
    private LocalDate beginDate;
    
    private LocalDate endDate;
    
    //private ArrayList<PC> pcs;
    
    private HashMap<String, PC> pcsMap;

    /**
     * Construtor
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
     * Insere um dispositivo como filho dessa janela de tempo
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
     * Acessa os dipositivos associados a essa data
     * @return
     */
    public HashMap<String, PC> getPcsMap() {
        return pcsMap;
    }

    /**
     * Altera os dispositivos associados a essa data
     * @param pcsMap
     */
    public void setPcsMap(HashMap<String, PC> pcsMap) {
        this.pcsMap = pcsMap;
    }

    /**
     * Acessa a data de ínício
     * @return
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }

    /**
     * Altera a data de início
     * @param beginDate
     */
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * Acessa a data final
     * @return
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Altera a data final
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
