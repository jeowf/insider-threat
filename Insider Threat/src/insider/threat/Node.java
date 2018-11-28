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
public class Node<T> {
    private T value;
    private Node<T> brother;
    private Node<T> son;
    private int[] histogram;

    public Node(T value) {
        this.value = value;
        this.brother = null;
        this.son = null;
        this.histogram = new int[24];
    }

    public int[] getHistogram() {
        return histogram;
    }

    public void setHistogram(int[] histogram) {
        this.histogram = histogram;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getBrother() {
        return brother;
    }

    public void setBrother(Node<T> brother) {
        this.brother = brother;
    }

    public Node<T> getSon() {
        return son;
    }

    public void setSon(Node<T> son) {
        this.son = son;
    }

    
}
