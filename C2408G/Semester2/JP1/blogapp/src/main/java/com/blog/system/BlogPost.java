package com.blog.system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlogPost implements PostActions,Commentable{
    private String title;
    private String author;
    private String content;
    private LocalDate publishDate;
    private boolean isPublished;
    List<Comment> comments = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    class Comment {
        String commenterName;
        String commentText;
        LocalDate commentDate;

        public Comment(String commenterName, String commentText, LocalDate commentDate) {
            this.commenterName = commenterName;
            this.commentText = commentText;
            this.commentDate = commentDate;
        }

        @Override
        public String toString() {
            return "Name: "+commenterName+
                    "text: "+commentText+
                    "date: "+commentDate;
        }
    }
    //all arguments constructor
    public BlogPost(String title, String author,
                    String content,
                    LocalDate publishDate,
                    boolean isPublished) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.publishDate = publishDate;
        this.isPublished = isPublished;
    }
    public void input() {
        System.out.println("Enter title: ");
        this.title = scanner.nextLine();

        System.out.println("Enter author: ");
        this.author = scanner.nextLine();

        System.out.println("Enter content: ");
        this.content = scanner.nextLine();

        System.out.println("Enter published date(eg: 2024-12-24): ");
        String strDate = scanner.nextLine();
        int year = Integer.parseInt(strDate.split("-")[0]);
        int month = Integer.parseInt(strDate.split("-")[1]);
        int day = Integer.parseInt(strDate.split("-")[2]);
        this.publishDate = LocalDate.of(year, month, day);

        System.out.println("Published(1), or not(0): ");
        this.isPublished = scanner.nextInt() == 1;
    }
    //no argument constructor = default constructor
    public BlogPost() {

    }

    @Override
    public void addComment(String commenter, String message) {
        this.comments.add(new Comment(commenter, message, LocalDate.now()));
    }

    @Override
    public void showAllComments() {
        for(Comment comment: comments) {
            System.out.println(comment);
        }
    }

    @Override
    public void publish() {
        publishDate = LocalDate.now();
        isPublished = true;
    }

    @Override
    public void edit(String newContent) {
        this.content = newContent;
    }
/*
title;
    private String author;
    private String content;
    private LocalDate publishDate;
    private boolean isPublished;
* */
    @Override
    public void display() {
        System.out.println(
                "title"+ title+"\n"+
                "content"+ content+"\n"+
                "publishDate"+ publishDate+"\n"+
                "isPublished"+ isPublished+"\n"+
                "author"+ author+"\n"
        );
        showAllComments();
    }
}
