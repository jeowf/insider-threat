/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import insider.threat.LogEntry.LogType;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class DataManager {

    //private Tree<User> tree;
    private HashMap<String, User> hashmap;

    public DataManager() {
        //Node<User> root= new Node<User>(null);
        //tree = new Tree<User>(root);
        hashmap = new HashMap<String, User>();
    }

    public HashMap<String, User> getHashMap() {
        return hashmap;
    }

    public void insertUser(User user) {
        if (hashmap.get(user.getId()) == null) {
            hashmap.put(user.getId(), user);
        }
    }

    public void processLog(LogEntry log) {
        String[] fields = log.getFields();

        if (log.getLogType() == LogType.USER) {
            String name = fields[0];
            String id = fields[1];
            String domain = fields[2];
            String email = fields[3];
            String role = fields[4];

            User user = new User(id, name, domain, email, role);
            insertUser(user);
            int a = 1;
        }

    }

    //public User getUser(String id)
    //{
    //return tree.search()zz
    //}
    public void setHashMap(HashMap<String, User> hashMap) {
        this.hashmap = hashMap;
    }
}
