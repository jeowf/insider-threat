package insider.threat;

/**
 * Generalização dos elementos do sistema
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public abstract class Field {
    private int[] histogram;

    /**
     * Construtor
     */
    public Field() {
        this.histogram = new int[24];

    }

    /**
     * Acessa o histograma
     * @return
     */
    public int[] getHistogram() {
        return histogram;
    }

    /**
     * Altera o histograma
     * @param histogram
     */
    public void setHistogram(int[] histogram) {
        this.histogram = histogram;
    }
    
    /**
     * Soma frequência ao histograma
     * @param time
     */
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
