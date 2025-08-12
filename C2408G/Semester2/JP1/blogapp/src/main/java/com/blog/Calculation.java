package com.blog;

import com.blog.system.TreeNode;

public class Calculation {
    /*
    public static double factorial(int n) {
        if(n <= 1) {
            return 1;
        } else {
            return n*factorial(n - 1);
        }
    }
     */
    public static double factorial(int n) {
        int i = n;
        double result = 1;
        while (true) {
            if(i <= 1) {
                return result;
            }
            result = result * i;
            i = i - 1;
        }
    }
    public static void preOrder(TreeNode treeNode) {
        if(treeNode != null){
            System.out.print(treeNode.getData()+", ");
            preOrder(treeNode.getChildren().size() > 0 ? treeNode.getChildren().get(0) : null);
            preOrder(treeNode.getChildren().size() > 1 ? treeNode.getChildren().get(1) : null);
        }
    }
    public static void postOrder(TreeNode treeNode) {
        if(treeNode != null){
            postOrder(treeNode.getChildren().size() > 0 ? treeNode.getChildren().get(0) : null);
            postOrder(treeNode.getChildren().size() > 1 ? treeNode.getChildren().get(1) : null);
            System.out.print(treeNode.getData()+", ");
        }
    }
    public static void inOrder(TreeNode treeNode) {
        if(treeNode != null){
            inOrder(treeNode.getChildren().size() > 0 ? treeNode.getChildren().get(0) : null);
            System.out.print(treeNode.getData()+", ");
            inOrder(treeNode.getChildren().size() > 1 ? treeNode.getChildren().get(1) : null);
        }
    }
}
