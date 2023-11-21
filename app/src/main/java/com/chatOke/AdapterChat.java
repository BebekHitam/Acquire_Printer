package com.chatOke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acquireprinter.R;

import java.util.List;

public class AdapterChat extends ArrayAdapter<UserChatData> {
    private Context contexx;
    public AdapterChat(Context contexx, List<UserChatData> items){
        super(contexx,0, items);
        this.contexx = contexx;

    }


    @Override
    public View getView(int position, View theChat, ViewGroup parent){
        if (theChat == null) {
            theChat = LayoutInflater.from(contexx).inflate(R.layout.chat_list_2, parent, false);

        }
        ImageView otherSide = theChat.findViewById(R.id.the_far_away);
        TextView nameOtherSide = theChat.findViewById(R.id.namaa);
        TextView content = theChat.findViewById(R.id.contents);
        TextView timeSend = theChat.findViewById(R.id.time_itsend);

        otherSide.setImageResource(getItem(position).getUserIDImage());
        nameOtherSide.setText(getItem(position).getUserName());
        content.setText(getItem(position).getKonten());
        timeSend.setText(getItem(position).getTimeNow());


        return theChat;
    }
}
