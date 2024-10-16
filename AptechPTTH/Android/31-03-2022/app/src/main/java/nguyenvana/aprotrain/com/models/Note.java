package nguyenvana.aprotrain.com.models;

import android.database.Cursor;

import java.util.Date;
/*
CREATE TABLE Note(
    noidung TEXT,
    quantrong  INTEGER,
    ngaytao TEXT
)
*/


public class Note {
    private long id;
    private String noidung;
    private Boolean quantrong;
    private Date ngaytao; //ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS").

    public Note(long id, String noidung, Boolean quantrong, Date ngaytao) {
        this.id = id;
        this.noidung = noidung;
        this.quantrong = quantrong;
        this.ngaytao = ngaytao;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Boolean getQuantrong() {
        return quantrong;
    }

    public void setQuantrong(Boolean quantrong) {
        this.quantrong = quantrong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }
    public static Note getNoteFromCursor(Cursor cursor) {
        //"factory method"
        try {
            String content = cursor.getString(
                    cursor.getColumnIndexOrThrow("noidung"));
            Boolean isImportant = cursor.getInt(
                    cursor.getColumnIndexOrThrow("quantrong")) > 0;
            long dateLong = cursor.getLong(
                    cursor.getColumnIndexOrThrow("ngaytao"));
            long id =  cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            Date createdDate = new Date(dateLong);
            return new Note(id, content,isImportant, createdDate);
        }catch (Exception e) {
            System.out.println("Cannot create TaskNote. Error: "+e.toString());
            return null;
        }
    }
}
