package com.stall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;

import java.util.ArrayList;
import java.util.List;

public class comChat extends AppCompatActivity {
    View view;
    ListView boxChat;
    String chatnya;
    EditText gottext;
    Button send;
    TextView textChat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_chat);
        boxChat = view.findViewById(R.id.chateee);
        List<String> dummeyChat = new ArrayList<>();
        gottext = view.findViewById(R.id.gottext);
        send = view.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatnya = gottext.getText().toString();
                if (chatnya.isEmpty()){//coba cari kenapa null tadinya
                    Toast.makeText(comChat.this, "masukkan teks", Toast.LENGTH_SHORT).show();

                }
                else {
                    dummeyChat.add(chatnya);
                    DummyChat dcAdapter = new DummyChat(dummeyChat);
                    boxChat.setAdapter(dcAdapter);
                    gottext.setText("");
                }

            }
        });
    }
}
