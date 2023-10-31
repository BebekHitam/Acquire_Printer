package com.SplashScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acquireprinter.R;

import java.util.List;

public class ListRentAdapter extends ArrayAdapter<ItemData> {
    private Context context;

    public ListRentAdapter(Context context, List<ItemData> items) {
        super(context, 0, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.in_list, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        ItemData item = getItem(position);

        if (item != null) {
            imageView.setImageResource(item.getImageResourceId());
            textView.setText(item.getText());
        }

        return convertView;
    }
}
