package com.blog;

import com.blog.system.BlogPost;
import com.blog.system.Commentable;
import com.blog.system.TreeNode;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double x = Calculation.factorial(4);
        System.out.println("x = "+x);
        TreeNode rootNode = new TreeNode(9);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        rootNode.getChildren().add(node5);
        rootNode.getChildren().add(node7);

        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        node5.getChildren().add(node6);
        node5.getChildren().add(node1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.getChildren().add(node2);
        node1.getChildren().add(node3);

        //Calculation.preOrder(rootNode);
        Calculation.postOrder(rootNode);


        /*
        BlogPost blogPost =new BlogPost();
        Scanner scanner = new Scanner(System.in);
        //input here
        blogPost.input();
        blogPost.publish();
        blogPost.display();
        int numberOfComments = 0;
        while (true) {
            System.out.println("Enter number of comments(min = 2): ");
            numberOfComments = scanner.nextInt();
            if(numberOfComments >= 2){
                System.out.println("Enter commenter's name: ");
                String commenterName = scanner.nextLine();

                System.out.println("Enter content: ");
                String comment = scanner.nextLine();
                blogPost.addComment(commenterName, comment);
            } else {
                System.err.println("Number of comments must be >= 2");
            }
        }
        */
    }
}