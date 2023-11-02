package com.stall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;

import java.util.ArrayList;
import java.util.List;

public class TalkTo extends AppCompatActivity {
    View view;
    ListView columnChat;
    private EditText gotTheText;
    private Button goChat;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talk_to);
        List<String> dummeyChat = new ArrayList<>();
        gotTheText = findViewById(R.id.gottext);
        goChat = findViewById(R.id.send);
        columnChat = findViewById(R.id.talking_box);

        goChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chatnya = gotTheText.getText().toString();
                if (chatnya.isEmpty()) {//coba cari kenapa null tadinya
                    Toast.makeText(getApplicationContext(), "masukkan teks", Toast.LENGTH_SHORT).show();

                } else {
                    dummeyChat.add(chatnya);
                    DummyChat dcAdapter = new DummyChat(dummeyChat);
                    columnChat.setAdapter(dcAdapter);
                    gotTheText.setText("");
                }

            }
        });
    }
}
