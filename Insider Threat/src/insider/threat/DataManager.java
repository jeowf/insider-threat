/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

/**
 *
 * @author daniel
 */
public class DataManager {
    private Tree<User> tree;

    public DataManager() {
        Node<User> root= new Node<User>(null);
        tree = new Tree<User>(root);
    }
    
    //public User getUser(String id)
    //{
        //return tree.search()zz
    //}

    public Tree<User> getTree() {
        return tree;
    }

    public void setTree(Tree<User> tree) {
        this.tree = tree;
    }
}
