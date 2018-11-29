/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import insider.threat.LogEntry.LogType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        } else if (log.getLogType() == LogType.LOGON) {
            String id = fields[0];
            String date = fields[1];
            String user = fields[2];
            String pc = fields[3].split("-")[1];
            String value = fields[4];
            String[] splitDate = date.split(" ");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate dateTime = LocalDate.parse(splitDate[0], formatter);
            Date d = new Date(dateTime);

            User searchUser = hashmap.get(user.split("/")[1]);

            if (searchUser != null) {
                PC newPc = new PC(pc);
                LogonActivity activity = new LogonActivity(id, value);
                searchUser.insert(d, newPc, activity, splitDate[1]);
            }
        } else if (log.getLogType() == LogType.DEVICE) {
            String id = fields[0];
            String date = fields[1];
            String user = fields[2];
            String pc = fields[3].split("-")[1];
            String value = fields[4];
            String[] splitDate = date.split(" ");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate dateTime = LocalDate.parse(splitDate[0], formatter);
            Date d = new Date(dateTime);

            User searchUser = hashmap.get(user.split("/")[1]);

            if (searchUser != null) {
                PC newPc = new PC(pc);
                DeviceActivity activity = new DeviceActivity(id, value);
                searchUser.insert(d, newPc, activity, splitDate[1]);
            }

        } else if (log.getLogType() == LogType.HTTP) {
            String id = fields[0];
            String date = fields[1];
            String user = fields[2];
            String pc = fields[3].split("-")[1];
            String value = fields[4];
            String[] splitDate = date.split(" ");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate dateTime = LocalDate.parse(splitDate[0], formatter);
            Date d = new Date(dateTime);

            User searchUser = hashmap.get(user.split("/")[1]);
            
            if (searchUser != null) {
                PC newPc = new PC(pc);
                HTTPActivity activity = new HTTPActivity(id, value);
                searchUser.insert(d, newPc, activity, splitDate[1]);
            }
        }
        
        int debug_step = 0;

    }

    //public User getUser(String id)
    //{
    //return tree.search()zz
    //}
    public void setHashMap(HashMap<String, User> hashMap) {
        this.hashmap = hashMap;
    }
}
