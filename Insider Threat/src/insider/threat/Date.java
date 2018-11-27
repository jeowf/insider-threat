/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.time.LocalDate;

/**
 *
 * @author felipemorais2013
 */
public class Date extends Field{
    LocalDate beginDate;
    LocalDate endDate;

    public Date() {
        this.beginDate = null;
        this.endDate = null;
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
    
    
    
}
