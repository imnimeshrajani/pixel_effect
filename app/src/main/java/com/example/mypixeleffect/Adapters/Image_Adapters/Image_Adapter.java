package com.example.mypixeleffect.Adapters.Image_Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Activity.Full_Screen_Image_Activity;
import com.example.mypixeleffect.Activity.Image_Activity;
import com.example.mypixeleffect.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Image_Adapter extends RecyclerView.Adapter<Image_Adapter.ViewImages> {
    Activity activity;
    List<String> image_path;
    private Bitmap myBitmap;

    public Image_Adapter(Image_Activity image_activity, List<String> img_path) {
        activity=image_activity;
        image_path=img_path;
    }

    @NonNull
    @Override
    public ViewImages onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.image_item,parent,false);
        return new ViewImages(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewImages holder, @SuppressLint("RecyclerView") int position) {
        File imgFile = new  File(image_path.get(position));
        if(imgFile.exists()){
            myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.gallery_img.setImageBitmap(myBitmap);
        }
        holder.gallery_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, Full_Screen_Image_Activity.class);
                intent.putExtra("path_position",position);
                intent.putStringArrayListExtra("path_array", (ArrayList<String>) image_path);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image_path.size();
    }

    class ViewImages extends RecyclerView.ViewHolder {
        private final ImageView gallery_img;

        public ViewImages(@NonNull View itemView) {
            super(itemView);
            gallery_img=itemView.findViewById(R.id.gallery_img);
        }
    }
}
