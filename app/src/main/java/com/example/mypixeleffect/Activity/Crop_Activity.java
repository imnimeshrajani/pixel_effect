package com.example.mypixeleffect.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.mypixeleffect.Crop.CropImageView;
import com.example.mypixeleffect.R;

public class Crop_Activity extends AppCompatActivity {

    private CropImageView ImageView_image;
    private ImageView crop_done,crop_back;
    public static Bitmap cropped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        ImageView_image = findViewById(R.id.crop);
        crop_done = findViewById(R.id.crop_done);
        crop_back = findViewById(R.id.crop_back);
        Uri uri = Uri.parse(getIntent().getStringExtra("uri"));
        Glide.with(Crop_Activity.this)
                .asBitmap()
                .load(uri)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

                        ImageView_image.setImageBitmap(resource);

                    }
                });
        crop_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        crop_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    cropped = ImageView_image.getCroppedImage();
                    startActivity(new Intent(Crop_Activity.this,Photo_Editing_Activity.class));
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });

    }


}