/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

/**
 *
 * @author felipemorais2013
 * @author Daniel Henrique Ferreira Gomes
 */
public class Tree<T> {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
    
    public void insert(Node<T> key){
        Node<T> aux = root.getSon();
        if(aux == null)
        {
            root.setSon(key);
        }
        else
        {
            while(aux != null){
                try
                {
                    if(aux.getValue().getClass() == key.getValue().getClass() )
                    {
                        Node<T> brother = aux;
                        while( brother.getBrother() != null){
                            brother = brother.getBrother();
                        }
                        brother.setBrother(key);
                        if (key.getValue() instanceof User)
                        {
                            Date date = new Date();
                            Node<T> n = new Node<T>((T)date);
                            brother.setSon(n);
                        }
                        brother.setSon(aux);
                        return;
                    }
                }
                catch(Exception ex){
                    aux = aux.getSon();
                }
            }
        }
        
    }
    
    public void print()
    {
        Node<T> aux = root.getSon();
        System.out.println( "TESTEEE" );
        while (aux != null)
        {
            if (aux.getValue() instanceof User)
            {
                System.out.println( ((User)aux.getValue()).getId() );
                aux = aux.getBrother();
            }            
        }
    }
    
}
