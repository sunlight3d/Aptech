package nguyenvana.aprotrain.com.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NOTE = "Note";
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS "+TABLE_NOTE+"("+
            "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "noidung TEXT,"+
            "quantrong INTEGER," +
            "ngaytao TEXT)";

    public static final String DATABASE_NAME = "NoteDB.db";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Note");
        onCreate(sqLiteDatabase);

    }
}
