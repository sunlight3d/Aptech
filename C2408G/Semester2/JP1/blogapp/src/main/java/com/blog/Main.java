package com.blog;

import com.blog.system.BlogPost;
import com.blog.system.Commentable;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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
    }
}