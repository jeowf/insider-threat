/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

/**
 *
 * @author Daniel Henrique Ferreira Gomes
 */
public abstract class Field {
    private int[] histogram;

    public Field() {
        this.histogram = new int[24];

    }

    public int[] getHistogram() {
        return histogram;
    }

    public void setHistogram(int[] histogram) {
        this.histogram = histogram;
    }
    

    public void addtoHistogram(String time)
    {
        int pos = Integer.parseInt(time.split(":")[0]);
        if(getHistogram()[pos] == 0)
        {
            getHistogram()[pos]=1;
        }
        else
        {
            getHistogram()[pos]+=1;
        }
        
    }

    
    
}
