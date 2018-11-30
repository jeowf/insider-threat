/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import insider.threat.LogEntry.LogType;
import static java.lang.Math.floor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import javafx.util.Pair;

/**
 *
 * @author daniel
 */
public class DataManager {

    //private Tree<User> tree;
    private HashMap<String, User> hashmap;
    
    private LocalDate beginDate;
    private LocalDate endDate;

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

    public void processLog(LogEntry log, LocalDate beginDate, LocalDate endDate) {
        String[] fields = log.getFields();

        if (log.getLogType() == LogType.USER) {
            String name = fields[0];
            String id = fields[1];
            String domain = fields[2];
            String email = fields[3];
            String role = fields[4];
            Date date = new Date(beginDate, endDate);

            User user = new User(id, name, domain, email, role, date);
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
            Date d = new Date(dateTime, dateTime);

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
            Date d = new Date(dateTime, dateTime);

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
            Date d = new Date(dateTime, dateTime);

            User searchUser = hashmap.get(user.split("/")[1]);
            
            if (searchUser != null) {
                PC newPc = new PC(pc);
                HTTPActivity activity = new HTTPActivity(id, value);
                searchUser.insert(d, newPc, activity, splitDate[1]);
            }
        }
        
        int debug_step = 0;

    }

    public User createMeanUser(String role, LocalDate beginDate, LocalDate endDate)
    {
        int[] mean = new int[24];
        Arrays.fill(mean, 0);
        int count = 0;
        for (Map.Entry<String,User> pair : hashmap.entrySet()) {
            if(pair.getValue().getRole().equals(role))
            {
                count++;
                for (int i = 0; i< pair.getValue().getHistogram().length; ++i)
                {
                    mean[i] += pair.getValue().getHistogram()[i];
                }
            }
        }
        for(int i = 0; i < 24; i++){
            mean[i] = (mean[i]/count);
        }
        Date date = new Date(beginDate, endDate);
        User meanUser = new User("MEAN", "MEAN", "MEAN", "MEAN", role, date);
        meanUser.setHistogram(mean);
        insertUser(meanUser); 
        return meanUser;
    }
    
    public double euclideanDistance(double[] ha, double[] hm)
    {
        double sum = 0;
        for(int i = 0; i< ha.length;++i)
        {
            sum += (ha[i] - hm[i]) * (ha[i] - hm[i]);
        }
        return Math.sqrt(sum);
    }
    
    public double[] normalize(int[] array){
        double[] newArray = new double[24];
        Arrays.fill(newArray, 0);
        double max = array[0];
        for(int i = 1; i< array.length; ++i)
        {
            if(array[i]> max)
            {
                max = (double)array[i];
            }
        }
        if(max != 0)
        {
            for(int i = 0; i< array.length; ++i)
            {
                newArray[i] = (double)array[i]/(double)max;
            }
        }
        return newArray;
    }

    public LinkedHashMap<User, Double> 
        detectOutliers(LinkedHashMap<User, Double> list, int[] hist){
        
        ArrayList<Double> value = new ArrayList<>(list.values());
        double q3 = value.get((int)floor((value.size()+1.0)/4.0));
        double q1 = value.get((int)floor(((value.size()+1.0)*3)/4.0));
        
        double iqr = q3-q1;
        LinkedHashMap<User, Double> nlist= new LinkedHashMap<User, Double>();
        for (Map.Entry<User,Double> pair : list.entrySet()) {
            double teste = q3+ (1.5*iqr);
            if(pair.getValue() > q3+ (1.5*iqr) ){
                nlist.put(pair.getKey(), pair.getValue());
            }
        }
        return nlist;     
    }
    
    /**
     * based on https://howtodoinjava.com/sort/java-sort-map-by-values/
     * @param role
     * @param beginDate
     * @param endDate
     * @return
     */
    public Pair<LinkedHashMap<User, Double>,LinkedHashMap<User, Double>> 
        generateAnalyze(String role, LocalDate beginDate, LocalDate endDate)
    {
        User meanUser = createMeanUser(role, beginDate, endDate);
        Map<User, Double> treemap = new HashMap<User, Double>();
        for (Map.Entry<String,User> pair : hashmap.entrySet()) {
            if(pair.getValue().getRole().equals(role) && !pair.getValue().getName().equals("MEAN"))
            {
                double[] ha = normalize(pair.getValue().getHistogram());
                double[] hm = normalize(meanUser.getHistogram());
                double distance = euclideanDistance(ha, hm);
                treemap.put(pair.getValue(),distance);
            }
        }
        Map<User, Double> unSortedMap = treemap;
        LinkedHashMap<User, Double> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        
        LinkedHashMap<User, Double> outliersSortedMap = detectOutliers(reverseSortedMap, meanUser.getHistogram());
        
        Pair<LinkedHashMap<User, Double>,LinkedHashMap<User, Double>> ret =
                new Pair<LinkedHashMap<User, Double>,LinkedHashMap<User, Double>>(outliersSortedMap, reverseSortedMap);
        
        return ret;        
    }

    public void setHashMap(HashMap<String, User> hashMap) {
        this.hashmap = hashMap;
    }
    
    public String toString(){
        int size = hashmap.size();
        return "Users: " + size;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setHashmap(HashMap<String, User> hashmap) {
        this.hashmap = hashmap;
    }

    public HashMap<String, User> getHashmap() {
        return hashmap;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
