package org.example;

public class BinarySearchTree extends Tree<Integer> {
    public int findGreatestValue(TreeNode<Integer> node) {
        if (node.hasRight()) return findGreatestValue(node.right);
        return node.value;
    }

    public void insert(int value) {
        TreeNode<Integer> newNode = new TreeNode<>();
        newNode.value = value;
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        insert(value, this.root);
    }

    public void print() {
        if (this.root == null) {
            System.out.println("(empty tree)");
            return;
        }
        printSubtree(this.root.right, "    ", true);
        System.out.println("── " + this.root.value);
        printSubtree(this.root.left, "    ", false);
    }

    private void printSubtree(TreeNode<Integer> node, String prefix, boolean isRight) {
        if (node == null) return;
        printSubtree(node.right, prefix + (isRight ? "    " : "│   "), true);
        System.out.println(prefix + (isRight ? "┌── " : "└── ") + node.value);
        printSubtree(node.left, prefix + (isRight ? "│   " : "    "), false);
    }

    private void insert(int value, TreeNode<Integer> node) {
        if (value < node.value) {
            if (node.left == null) {
                TreeNode<Integer> newNode = new TreeNode<>();
                newNode.value = value;
                node.left = newNode;
            } else {
                insert(value, node.left);
            }
        } else {
            if (node.right == null) {
                TreeNode<Integer> newNode = new TreeNode<>();
                newNode.value = value;
                node.right = newNode;
            } else {
                insert(value, node.right);
            }
        }
    }
}
