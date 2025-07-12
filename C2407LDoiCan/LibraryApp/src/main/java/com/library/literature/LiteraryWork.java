package com.library.literature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;

public class LiteraryWork implements ILiteraryWork{
    private String title;
    private String author;
    private int publicationYear;
    private int pageCount;
    BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public LiteraryWork() {
    }

    public LiteraryWork(String title, String author, int publicationYear, int pageCount) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    @Override
    public void inputDetails() throws IOException {
        while (true) {
            System.out.println("Enter title:");
            this.title = reader.readLine();
            if(this.title.length() > 3) {
                break;
            } else {
                System.err.println("Title must be at least 3 characters");
            }
        }

        while (true) {
            System.out.println("Enter author:");
            this.author = reader.readLine();
            if(this.author.length() > 3) {
                break;
            } else {
                System.err.println("Author must be at least 3 characters");
            }
        }
        while (true) {
            System.out.println("Enter publication's year:");
            this.publicationYear = Integer.parseInt(reader.readLine());
            if(this.publicationYear > 1500 || publicationYear <= Year.now().getValue()) {
                break;
            } else {
                System.err.println("year must be between 1500 and < now");
            }
        }

        while (true) {
            System.out.println("Enter page count:");
            this.pageCount = Integer.parseInt(reader.readLine());
            if(pageCount > 0) {
                break;
            } else {
                System.err.println("page count must be > 0");
            }
        }
    }
    public boolean isClassic() {
        return publicationYear < 1970;
    }
    @Override
    public void displayDetails() {
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Publication year: "+publicationYear);
        System.out.println("pageCount: "+pageCount);
        System.out.println(isClassic() ?
                "Tác phẩm ["+title+"] được xem là kinh điển":
                "Tác phẩm ["+title+"] được xem là hiện đại");
    }
}
