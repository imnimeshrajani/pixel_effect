package com.example.mypixeleffect.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.example.mypixeleffect.Adapters.Image_Adapters.Image_Adapter;
import com.example.mypixeleffect.R;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Image_Activity extends AppCompatActivity {


    private RecyclerView image_rv;
    private List<String> img_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image_rv=findViewById(R.id.image_rv);
        getAllImages();

        Image_Adapter image_adapter=new Image_Adapter(Image_Activity.this,img_path);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(Image_Activity.this,3);
        image_rv.setLayoutManager(layoutManager);
        image_rv.setAdapter(image_adapter);

    }
    public void getAllImages()
    {
        img_path=new ArrayList<>();
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "/MyPixelEffect/");
        if(folder.exists()) {
            File[] allFiles = folder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
                }
            });

            for (int i=0;i<allFiles.length;i++) {
                img_path.add(allFiles[i].getPath());
            }
        }
        else
        {
            Toast.makeText(this, "Folder Not Exist", Toast.LENGTH_SHORT).show();
        }

    }
}