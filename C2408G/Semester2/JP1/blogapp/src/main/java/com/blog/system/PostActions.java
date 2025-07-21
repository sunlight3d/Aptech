package com.blog.system;

public interface PostActions {
    void publish(); //– đăng bài viết
    void edit(String newContent); //– chỉnh sửa nội dung
    void display(); //– hiển thị nội dung bài viết

}
