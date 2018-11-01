/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

/**
 *
 * @author felipemorais2013
 * @param <T>
 */
public class AVLTree<T> {
    // Comparator Constants
    private static final int LESS = -1;
    private static final int EQUAL = 0;
    private static final int GREATER = 1;
    
    
    // Node Class
    private class Node {
        private static final int SAMPLES = 24;
        
        private Comparable<T> key; // Key of the node
        
        private Node left;  // Son at left
        private Node right; // Son at right        

        private int [] histogram;
        
        private int bf; // Balance Factor

        public Node(Comparable<T> key,
                Node left,
                Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
            
            histogram = new int[SAMPLES];
        }


        public Node(Node copy) {
            this.key = copy.key;
            this.left = copy.left;
            this.right = copy.right;
            this.bf = copy.bf;
        }

        @Override
        public String toString() {
            String r = "";

            r += key.toString();

            return r;
        }

        public Comparable<T> getKey() {
            return key;
        }

        public void setKey(Comparable<T> key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int[] getHistogram() {
            return histogram;
        }

        public void setHistogram(int[] histogram) {
            this.histogram = histogram;
        }

        public int getBf() {
            return bf;
        }

        public void setBf(int bf) {
            this.bf = bf;
        }

    }
    
    public AVLTree(){
        
    }
    
    public void insert(T key){
        
    }
    
    public void remove(T key){
        
    }
    
    public T search (T key){
        return null;
    }
    
    
}
