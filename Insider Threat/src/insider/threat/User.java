/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author felipemorais2013
 * @author Daniel Henrique Ferreira Gomes
 */
public class User extends Field implements Comparable<User>{
    private String id;
    
    private String name;
    
    private String domain;
    
    private String email;
    
    private String role;
    
    //private Tree<Date> dates;
    
    private HashMap<LocalDate, Date> datesmap;

    public User(String id, String name, String domain, String email, String role) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.email = email;
        this.role = role;
        //this.dates = new Tree<>(root);
        this.datesmap = new HashMap<LocalDate, Date>();
    }

    public HashMap<LocalDate, Date> getDatesmap() {
        return datesmap;
    }

    public void setDatesmap(HashMap<LocalDate, Date> datesmap) {
        this.datesmap = datesmap;
    }

    public void insert(Date date, PC pc, Activity act, String time){
        //Node<Date>key = new Node<Date>(date);
        //dates.insert(key);
        if(datesmap.get(date.getBeginDate()) == null)
        {
            date.insertPC(pc, act, time);
            addtoHistogram(time);
            datesmap.put(date.getBeginDate(), date);
        }
        else
        {
            datesmap.get(date.getBeginDate()).insertPC(pc, act, time);
            addtoHistogram(time);
            //datesmap.put(date.getBeginDate(), date);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

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


}
