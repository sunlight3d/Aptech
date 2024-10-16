package nguyenvana.aprotrain.com.models;

import android.database.Cursor;

import java.io.Serializable;
import java.util.Date;

import nguyenvana.aprotrain.com.database.TblNotes;

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
    public static Note getNoteFromCursor(Cursor cursor) {
        String content = cursor.getString((char)cursor
                .getColumnIndex(TblNotes.COLUMN_CONTENT));
        boolean isImportant = cursor.getInt((char)cursor
                .getColumnIndex(TblNotes.COLUMN_IMPORTANT)) > 0;
        Date createdDate = new Date(cursor.getLong((char)cursor
                .getColumnIndex(TblNotes.COLUMN_CREATED_DATE)));
        long id = cursor.getLong((char)cursor.getColumnIndex(TblNotes.COLUMN_ID));
        return new Note(content, isImportant, createdDate);
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
