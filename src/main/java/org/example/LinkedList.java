package org.example;

public class LinkedList<T> {
    private Node<T> root;

    public LinkedList(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void printAll() {
        Node<T> current = root;
        while (current != null) {
            System.out.println("Node ->  " + current + " Value -> " + current.getValue());
            current = current.getNext();
        }
    }

    public Node<T> getLastElement() {
        Node<T> current = root;
        while (current.hasNext()) {
            current = current.getNext();
        }
        return current;
    }

    public Node<T> reverse(){
        Node<T> current = root, previous = null, next;
        while (current != null){
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        return previous;
    }

    public Node<T> deleteNodeFromMiddle(Node<T> node){
        if (!node.hasNext()){
            throw new IllegalStateException("Node need to have a next node");
        }
        node.setValue(node.getNext().getValue());
        node.setNext(node.getNext().getNext());
        return node;
    }
}
