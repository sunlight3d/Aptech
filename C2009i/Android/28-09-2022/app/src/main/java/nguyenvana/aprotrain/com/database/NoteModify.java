package nguyenvana.aprotrain.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.Date;

import nguyenvana.aprotrain.com.models.Note;

public class NoteModify {
    private Context context;
    private static final String DB_NAME = "notedb";
    private static final int DB_VERSION = 1;

    private DBHelper dbHelper;
    public NoteModify(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }
    public void insertNote(Note note){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TblNotes.COLUMN_CONTENT, note.getContent());
        values.put(TblNotes.COLUMN_IMPORTANT, note.isImportant());
        values.put(TblNotes.COLUMN_CREATED_DATE, note.getCreatedDate().getTime());
        long insertedId = db.insert(TblNotes.TABLE_NAME, null, values);
        if(insertedId > 0) {
            Toast.makeText(this.context, "Insert successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this.context, "Insert failed", Toast.LENGTH_LONG).show();
        }
        db.close();
    }
    public long updateNote(long noteId, Note note) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TblNotes.COLUMN_CONTENT, note.getContent());
        contentValues.put(TblNotes.COLUMN_IMPORTANT, note.isImportant());
        contentValues.put(TblNotes.COLUMN_CREATED_DATE, note.getCreatedDate().getTime());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        long updatedId = db.update(TblNotes.TABLE_NAME,
                contentValues,
                String.format(TblNotes.TABLE_NAME+"."+TblNotes.COLUMN_ID +"= %d", noteId),
                null);
        if(updatedId > 0) {
            Toast.makeText(this.context, "Update successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this.context, "Update failed", Toast.LENGTH_LONG).show();
        }
        db.close();
        return updatedId;
    }

    public Cursor getAllNotes() {
        String[] columns = new String[] {
                TblNotes.COLUMN_ID,
                TblNotes.COLUMN_CONTENT,
                TblNotes.COLUMN_IMPORTANT,
                TblNotes.COLUMN_CREATED_DATE,
        };
        Cursor cursor = dbHelper.getReadableDatabase().query(
                TblNotes.TABLE_NAME,
                columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public void deleteNote(long noteId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(
                TblNotes.TABLE_NAME,
                String.format(TblNotes.TABLE_NAME+"."+TblNotes.COLUMN_ID +"= %d", noteId),
                null);
    }
}
