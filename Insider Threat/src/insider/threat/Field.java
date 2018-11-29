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
        histogram = new int[24];            
    }

    public int[] getHistogram() {
        return histogram;
    }

    public void setHistogram(int[] histogram) {
        this.histogram = histogram;
    }
    
    public void increment(int index, int value){
        
    }
    
}
