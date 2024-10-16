package nguyenvana.aprotrain.com.models;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private String content;
    private boolean isImportant;
    private Date createdDate;
    public Note() {}
    public Note(String content, boolean isImportant, Date createdDate) {
        this.content = content;
        this.isImportant = isImportant;
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
