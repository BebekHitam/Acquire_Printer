package com.stall;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.authenticate.SignUp;
import com.bumptech.glide.Glide;
import com.example.acquireprinter.R;

import java.io.Serializable;
import java.util.ArrayList;

public class StallAdapter extends RecyclerView.Adapter<StallAdapter.ViewHolder>{
    View view;

    private ArrayList<DataStall> listItem;
    private Context thisUp;
    public StallAdapter (ArrayList<DataStall> ArraylistItem, Context thisUp){
        this.listItem = ArraylistItem;
        this.thisUp=thisUp;
    }


    //koneksi ke xml stall menggunakan layout inflater dan context
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //membaca layout yang digunakan ini
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stall_show_piece, parent, false);
        return new ViewHolder(view);
    }
    //taruh data posisi produk dengan menggunakan ini
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position){
        //deklarasi datastall di kelas Datastall
        DataStall item = listItem.get(position);
        //set datastall name/price
        holder.text.setText(item.getItemName());
        //set datastall image
        //holder.image.setImageResource(item.getImageId());
        Glide.with(thisUp).load(item.imageUrl).into(holder.image);
        //set harganya
        holder.price.setText(Integer.toString(item.getPrice()));
        holder.city.setText(item.getCity());
        
        //holder.city.setText(item.getCity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity.
                Intent intent = new Intent(thisUp, ItemDetail.class);
                intent.putExtra("item_data", listItem.get(position));
                thisUp.startActivity(intent);
            }
        });


    }
    public int getItemCount(){
        //menyampaikan ukuran dari recycler view
        return listItem.size();
    }



    //akhinrnya handler recyclerviewnya
    public static class ViewHolder extends RecyclerView.ViewHolder{


        ImageView image;
        TextView text;
        TextView price;
        TextView city;
        public ViewHolder(@NonNull View productView){
            super(productView);
            image = productView.findViewById(R.id.product_small_view);
            text = productView.findViewById(R.id.product_name);
            price = productView.findViewById(R.id.product_price);
            city = productView.findViewById(R.id.product_city);


        }
    }
    private void onItemClick(int position) {
        // Create an Intent object to start the NewActivity class.
        Intent intent = new Intent(thisUp, ItemDetail.class);

        // Pass the item data to the NewActivity class.
        intent.putExtra("item_data", listItem.get(position));

        // Start the NewActivity class.
        thisUp.startActivity(intent);
    }

}