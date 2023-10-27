package com.stall;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class DummyChat extends BaseAdapter {
    private List<String> dummyChatMessages;

    public DummyChat(List<String> dummyChatMessages) {
        this.dummyChatMessages = dummyChatMessages;
    }

    @Override
    public int getCount() {
        return dummyChatMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return dummyChatMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout;
        TextView textView;

        if (convertView == null) {
            linearLayout = new LinearLayout(parent.getContext());
            textView = new TextView(parent.getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(textView);
        } else {
            linearLayout = (LinearLayout) convertView;
            textView = (TextView) linearLayout.getChildAt(0);
        }

        textView.setText(dummyChatMessages.get(position));

        return linearLayout;
    }
}
