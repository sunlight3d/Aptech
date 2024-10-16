package nguyenvana.aprotrain.com.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.Date;

import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.Utilities;
import nguyenvana.aprotrain.com.database.TblNotes;
import nguyenvana.aprotrain.com.models.Note;

public class CustomAdapter extends CursorAdapter {
    private Context context;
    public CustomAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.context = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(this.context)
                .inflate(R.layout.list_item, viewGroup, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CardView cardView = view.findViewById(R.id.cardView);
        TextView textViewContent = view.findViewById(R.id.textViewContent);
        TextView textViewCreatedDate = view.findViewById(R.id.textViewCreatedDate);
        String content = cursor.getString((char)cursor
                            .getColumnIndex(TblNotes.COLUMN_CONTENT));
        boolean isImportant = cursor.getInt((char)cursor
                .getColumnIndex(TblNotes.COLUMN_IMPORTANT)) > 0;
        Date createdDate = new Date(cursor.getLong((char)cursor
                .getColumnIndex(TblNotes.COLUMN_CREATED_DATE)));
        long id = cursor.getLong((char)cursor.getColumnIndex(TblNotes.COLUMN_ID));
        //Note selectedNode = cursor.get
        //fetch data to ui
        cardView.setCardBackgroundColor(isImportant ? 0xFF00FF00 : 0xFFFF0000);
        textViewContent.setText(content);
        textViewCreatedDate.setText(Utilities.convertDateToString(createdDate));
    }
}
