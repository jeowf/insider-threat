/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class DataManager {
    private Tree<User> tree;
    private HashMap<String, User> hashmap;

    public DataManager() {
        Node<User> root= new Node<User>(null);
        tree = new Tree<User>(root);
        hashmap = new HashMap<String, User>();
    }
    
    public HashMap<String, User> getHashMap() {
        return hashmap;
    }
    
    public void insertUser(User user)
    {
        if (hashmap.get(user.getId()) == null)
        {
            hashmap.put(user.getId(), user);
        }
    }

    //public User getUser(String id)
    //{
    //return tree.search()zz
    //}
    public void setHashMap(HashMap<String, User> hashMap) {
        this.hashmap = hashMap;
    }

    public Tree<User> getTree() {
        return tree;
    }

    public void setTree(Tree<User> tree) {
        this.tree = tree;
    }
}
