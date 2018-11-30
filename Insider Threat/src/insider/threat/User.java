package insider.threat;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Representa os usuários
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class User extends Field implements Comparable<User>{
    private String id;
    
    private String name;
    
    private String domain;
    
    private String email;
    
    private String role;
    
    private Date date;

    /**
     * Construtor
     * @param id
     * @param name
     * @param domain
     * @param email
     * @param role
     * @param date
     */
    public User(String id, String name, String domain, String email, String role, Date date) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.email = email;
        this.role = role;
        this.date = date;
    }

    /**
     * Recupera data
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Altera data
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * Insere um log
     * @param newDate
     * @param pc
     * @param act
     * @param time
     */
    public void insert(Date newDate, PC pc, Activity act, String time){

        if(date.getBeginDate() == null && date.getEndDate() == null)
        {
            date.insertPC(pc, act, time);
            addtoHistogram(time);
        }
        else if(date.getBeginDate() != null && date.getEndDate() != null)
        {
            if(date.getBeginDate().compareTo(newDate.getBeginDate()) <= 0 &&
               date.getEndDate().compareTo(newDate.getBeginDate()) >= 0)
            {
                //System.out.println(date.getEndDate().compareTo(newDate.getBeginDate()));
                date.insertPC(pc, act, time);
                addtoHistogram(time);
            }
        }
    }

    /**
     * Recupera o id
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
     * Recebe o nome
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Altera o nome
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Recupera o domínio
     * @return
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Altera o domínio
     * @param domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * Recupera o email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Altera email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Recupera role
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * Altera role
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public int compareTo(User other) {
        if(this.id.equals(other.getId()))
        {
            return 0;
        }        
        return -1;
    }
    @Override
    public String toString(){
        return "Id: "+id + ", Name: "+name + ", Role: " + role;
    }


}
