package com.ImageHandler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.acquireprinter.R;

import java.util.List;

public class AdapterSlider extends PagerAdapter {
    private Context context;
    private List<Integer> ListofImage;

    public AdapterSlider(Context context, List<Integer> ListofImage){
        this.context = context;
        this.ListofImage = ListofImage;
    }


    @Override
    public int getCount() {
        return ListofImage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.slider_item, container, false);

        ImageView imageView = itemView.findViewById(R.id.imageViewerr);
        imageView.setImageResource(ListofImage.get(position));

        container.addView(itemView);

        return (itemView);
    }
    @Override
    public void destroyItem(ViewGroup conntainer, int position, Object object){
        conntainer.removeView((View) object);
    }
}
