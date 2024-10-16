package nguyenvana.aprotrain.com.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context,
                    @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE tblNotes ("
                + TblNotes.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TblNotes.COLUMN_CONTENT +  " TEXT,"
                + TblNotes.COLUMN_IMPORTANT +  " INTEGER,"
                + TblNotes.COLUMN_CREATED_DATE +  " REAL)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TblNotes.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
