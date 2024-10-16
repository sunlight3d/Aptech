package nguyenvana.aprotrain.com.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.Date;

import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.models.Note;
import nguyenvana.aprotrain.com.utilities.DateTimeUtility;

public class CustomAdapter extends CursorAdapter {
    //ArrayList data => NO !
    public CustomAdapter(Context context, Cursor cursor, boolean autoRequery) {
        super(context, cursor, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        View leftView = view.findViewById(R.id.leftView);
        TextView textViewNoidung = view.findViewById(R.id.textViewNoidung);
        TextView textViewNgaytao = view.findViewById(R.id.textViewNgaytao);

        //Get data from cursor
        String noidung = cursor.getString(cursor.getColumnIndexOrThrow("noidung"));
        String ngaytao = cursor.getString(cursor.getColumnIndexOrThrow("ngaytao"));
        Boolean quantrong = cursor.getInt(cursor.getColumnIndexOrThrow("quantrong")) > 0;
        textViewNoidung.setText(noidung);
        textViewNgaytao.setText(ngaytao);
        leftView.setBackgroundColor(quantrong == true ? 0xFFFF0000 : 0xFF00FF00);
        //leftView.setBackground();
        //Date ngaytao = DateTimeUtility.convertStringToDate(cursor.getString(cursor.getColumnIndexOrThrow("ngaytao")));
    }
}
