package org.example;

public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T value;

    public boolean hasRight(){
        return right != null;
    }
}
