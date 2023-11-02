package com.stall;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.SplashScreen.ItemData;
import com.SplashScreen.ListRentAdapter;
import com.example.acquireprinter.R;

import java.util.ArrayList;
import java.util.List;


public class Chat extends Fragment {
    View view;
    ListView boxChat;
    String chatnya;
    EditText gottext;
    Button send;
    TextView textChat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.chat_person, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<ItemData> items = new ArrayList<>();
        items.add(new ItemData(R.drawable.the_renter, "Mr. Fajar"));

        ListRentAdapter adapter = new ListRentAdapter(getContext(), items);

        ListView listView = view.findViewById(R.id.the_names); // Make sure to have a ListView with id 'listView' in your layout
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), TalkTo.class);
                //intent.putExtra("name", listView.getItemAtPosition(position));
                startActivity(intent);
            }
        });



        //textChat = view.findViewById(R.id.textView);
        //textChat.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

        /*
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set text alignment dari TextView
        TextView textView = findViewById(R.id.textView);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_RIGHT);

        // Tambahkan listener untuk update listview
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Update listview
                updateListView("Update " + position);
            }
        });
    }

    public void updateListView(String text) {
        // Tambahkan item baru ke listview
        ListView listView = findViewById(R.id.listView);
        listView.addView(new TextView(this).setText(text));

        // Geser item baru ke atas
        int count = listView.getCount();
        for (int i = count - 1; i >= 0; i--) {
            listView.getChildAt(i).setY(listView.getChildAt(i).getY() - 10);
        }
    }




        */
        /*

        */


        /*
        //fungsi untuk ngobreol
        List<String> dummeyChat = new ArrayList<>();
        gottext = view.findViewById(R.id.gottext);
        send = view.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatnya = gottext.getText().toString();
                if (chatnya.isEmpty()){//coba cari kenapa null tadinya
                    Toast.makeText(getContext(), "masukkan teks", Toast.LENGTH_SHORT).show();

                }
                else {
                    dummeyChat.add(chatnya);
                    DummyChat dcAdapter = new DummyChat(dummeyChat);
                    boxChat.setAdapter(dcAdapter);
                    gottext.setText("");
                }

            }
        });
        */



        /*
        * boxChat = view.findViewById(R.id.chatee);

    List<String> dummeyChat = new ArrayList<>();
    gottext = view.findViewById(R.id.gottext);

    send = view.findViewById(R.id.send);
    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (gottext != null) {
                chatnya = gottext.getText().toString();
                dummeyChat.add(chatnya);
            }
        }
    });
        * */

    }
}