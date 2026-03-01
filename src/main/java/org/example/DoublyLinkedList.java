package org.example;

public class DoublyLinkedList<T> {
    private Node<T> root;
    private Node<T> last;

    public DoublyLinkedList(Node<T> root, Node<T> last) {
        this.root = root;
        this.last = last;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public void printAllReverse(){
        Node<T> current = last;
        while (current != null){
            System.out.println("Node ->  " + current + " Value -> " + current.getValue());
            current = current.getPrevious();
        }
    }
}
