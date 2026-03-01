package org.example;

public class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private T value;

    public Node(Node<T> next, T value) {
        this.next = next;
        this.value = value;
        this.previous = null;
    }

    public Node(Node<T> next, Node<T> previous, T value){
        this.next = next;
        this.value = value;
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext(){
        return next != null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
