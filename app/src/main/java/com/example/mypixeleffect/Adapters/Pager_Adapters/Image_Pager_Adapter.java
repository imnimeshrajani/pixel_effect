package com.example.mypixeleffect.Adapters.Pager_Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mypixeleffect.Activity.Full_Screen_Image_Activity;
import com.example.mypixeleffect.Activity.Image_Activity;
import com.example.mypixeleffect.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Image_Pager_Adapter extends PagerAdapter {

    LayoutInflater mLayoutInflater;
    Activity context;
    List<String> list;
    int path;
    private Bitmap myBitmap;

    public Image_Pager_Adapter(Full_Screen_Image_Activity full_screen_image_activity, List<String> path_array, int path) {
        context=full_screen_image_activity;
        list=path_array;
        this.path=path;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
        File imgFile = new File(list.get(position));
        myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        imageView.setImageBitmap(myBitmap);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
