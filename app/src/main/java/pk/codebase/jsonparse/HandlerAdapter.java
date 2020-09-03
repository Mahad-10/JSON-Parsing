package pk.codebase.jsonparse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HandlerAdapter extends ArrayAdapter {
    public HandlerAdapter(Context context, ArrayList<Handler> competition){
        super( context,0,competition);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_main,parent,false);
        }
        Handler currentHandler = (Handler)getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.name_view);
        nameTextView.setText(currentHandler.getName());

        TextView startDateTextView = listItemView.findViewById(R.id.start_date_view);
        startDateTextView.setText(currentHandler.getStart_date());

        TextView endDateTextView = listItemView.findViewById(R.id.end_date_view);
        endDateTextView.setText(currentHandler.getEnd_date());

        TextView uidTextView = listItemView.findViewById(R.id.uid_view);
        uidTextView.setText(currentHandler.getUid());

        TextView detailTextView = listItemView.findViewById(R.id.detail_view);
        detailTextView.setText(currentHandler.getDetail());

        TextView styleTextView = listItemView.findViewById(R.id.style_view);
        styleTextView.setText(currentHandler.getStyle());

        TextView enabledTextView = listItemView.findViewById(R.id.enabled_view);
        enabledTextView.setText(currentHandler.getEnabled());

        return listItemView;
    }
}
