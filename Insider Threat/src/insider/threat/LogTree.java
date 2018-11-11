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
public class LogTree {
    private Node<Field> root;

    public LogTree(Node<Field> root) {
        this.root = root;
    }
    
    public void insert(Field field){
        if (field instanceof User)
        {
            Node node = new Node<Field>(field);
            root.setBrother(root);
        }
    }
    
    public Field search(Field field){
        return root.getValue();
    }
    
    public void remove(Field field){
        
    }
    
    
}
