package com.blog.system;

public interface Commentable {
    void addComment(String commenter, String message); //– thêm phản hồi
    void showAllComments(); //– hiển thị toàn bộ phản hồi
}
