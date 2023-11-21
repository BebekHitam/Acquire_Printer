package com.stall;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chatOke.AdapterChat;
import com.chatOke.UserChatData;
import com.example.acquireprinter.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TalkTo extends AppCompatActivity {
    View view;
    ListView columnChat;
    private EditText gotTheText;
    private Button goChat;
    private String name, contents;
    private int image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talk_to);

        //List<String> dummeyChat = new ArrayList<>();
        List<UserChatData> newTalk = new ArrayList<>();
        gotTheText = findViewById(R.id.gottext);
        goChat = findViewById(R.id.send);
        //columnChat = findViewById(R.id.talking_box);


        goChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chatnya = gotTheText.getText().toString();
                if (chatnya.isEmpty()) {//coba cari kenapa null tadinya
                    Toast.makeText(getApplicationContext(), "masukkan teks", Toast.LENGTH_SHORT).show();

                } else {
                    newTalk.add(new UserChatData(R.drawable.cat_bob, "Bob", chatnya, currentTime()));
                    AdapterChat chatAdapter = new AdapterChat(getApplicationContext(), newTalk);
                    ListView listChat = findViewById(R.id.talking_box);
                    listChat.setAdapter(chatAdapter);
                    gotTheText.setText("");



                    /*
                    dummeyChat.add(chatnya);
                    DummyChat dcAdapter = new DummyChat(dummeyChat);
                    columnChat.setAdapter(dcAdapter);
                    gotTheText.setText("");*/
                }

            }
        });


    }
    public String currentTime(){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        String timenow = sdf.format(now);
        return timenow;

    }
}
