package insider.threat;

import java.time.LocalTime;

/**
 * Generalização dos tipos de atividade
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public abstract class Activity extends Field{
    private String id;

    /**
     * Construtor
     * @param id
     */
    public Activity(String id) {
        this.id = id;
    }

    /**
     * Retorna o id
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
    
    @Override
    public String toString() {
        return "Id: " + id;
    }

}
