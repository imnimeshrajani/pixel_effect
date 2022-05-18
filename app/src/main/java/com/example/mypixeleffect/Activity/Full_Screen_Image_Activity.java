package com.example.mypixeleffect.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mypixeleffect.Adapters.Pager_Adapters.Image_Pager_Adapter;
import com.example.mypixeleffect.R;

import java.io.File;
import java.util.List;

public class Full_Screen_Image_Activity extends AppCompatActivity {

    private ImageView img;
    private Bitmap myBitmap;
    private ViewPager view_pager;
    private List<String> path_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);
        img=findViewById(R.id.img);
        view_pager=findViewById(R.id.view_pager);
        int path=getIntent().getIntExtra("path_position",0);
        path_array=getIntent().getStringArrayListExtra("path_array");
        Image_Pager_Adapter image_pager_adapter=new Image_Pager_Adapter(this,path_array,path);
        view_pager.setAdapter(image_pager_adapter);
        view_pager.setCurrentItem(image_pager_adapter.getCount()-1);
//        File imgFile = new  File(path);
//        myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//        img.setImageBitmap(myBitmap);

    }
}