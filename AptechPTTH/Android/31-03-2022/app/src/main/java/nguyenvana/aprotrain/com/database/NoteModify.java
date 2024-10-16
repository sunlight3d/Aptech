package nguyenvana.aprotrain.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

import nguyenvana.aprotrain.com.models.Note;
import nguyenvana.aprotrain.com.utilities.DateTimeUtility;

public class NoteModify {
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private Context context;
    private NoteModify(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
    }
    //Singleton pattern
    private static NoteModify instance;
    public static NoteModify getInstance(Context context) {
        if(instance == null) {
            instance = new NoteModify(context);
        }
        instance.context = context;
        instance.dbHelper = new DBHelper(context);
        return instance;
    }

    public long insertNote(Note note) {
        try {
            this.db = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("noidung", note.getNoidung());
            contentValues.put("quantrong", note.getQuantrong());
            contentValues.put("ngaytao", DateTimeUtility.convertDateToString(note.getNgaytao()));
            long newRowId = db.insert(DBHelper.TABLE_NOTE, null, contentValues);
            return newRowId;
            //success => >=1
        }catch (Exception e) {
            return -1;
        }

    }
    //success => >=0
    public int updateNote(long id, Note note) {
        try {
            this.db = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("noidung", note.getNoidung());
            contentValues.put("quantrong", note.getQuantrong());
            contentValues.put("ngaytao", DateTimeUtility.convertDateToString(note.getNgaytao()));
            String[] selectionArgs = {String.format("%d", id)};

            int count = db.update(
                    DBHelper.TABLE_NOTE,
                    contentValues,
                    "_id = ?",
                    selectionArgs);
            return count;
        }catch (Exception e) {
            return -1;
        }
    }
    public void deleteNote(long id) {
        this.db = dbHelper.getWritableDatabase();
        String[] selectionArgs = {String.format("%d", id)};
        db.delete( DBHelper.TABLE_NOTE, "_id = ?", selectionArgs);
    }
    public Cursor getNotesCursor() {
        ArrayList<Note> notes = new ArrayList<>();
        this.db = dbHelper.getReadableDatabase();
        String[] fields = {
                "_id",
                "noidung",
                "quantrong",
                "ngaytao"
        };
        String selection =" 1 = 1";
        Cursor cursor = db.query(
                DBHelper.TABLE_NOTE,   // The table to query
                fields,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        return cursor;
    }
}
