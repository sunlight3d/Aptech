package myapp.MyApp.models;

import java.util.ArrayList;

public class News implements INews{
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
    private ArrayList<Integer> rateList = new ArrayList<>();
    public static int MAX_RATE_LIST_SIZE = 3;
    @Override
    public void display() {
        System.out.println(
                        "id = "+String.valueOf(id)+
                        "title = "+title+
                        "publishDate = "+publishDate+
                        "author = "+author+
                        "content = "+content
                );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        float sum = 0.0f;
        for (Integer rate: rateList) {
            sum += rate;
        }
        this.averageRate = sum / rateList.size();
        return this.averageRate;
    }
}
