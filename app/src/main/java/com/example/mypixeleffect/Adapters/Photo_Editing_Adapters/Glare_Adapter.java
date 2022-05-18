package com.example.mypixeleffect.Adapters.Photo_Editing_Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Activity.Photo_Editing_Activity;
import com.example.mypixeleffect.R;

public class Glare_Adapter extends RecyclerView.Adapter<Glare_Adapter.ViewGlare> {
    Activity activity;
    Bitmap b;
    int[] glare;
    public Glare_Adapter(Photo_Editing_Activity activity, Bitmap bitmap, int[] glare) {
        this.activity=activity;
        b=bitmap;
        this.glare=glare;
    }

    @NonNull
    @Override
    public ViewGlare onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.effect_view_item,parent,false);
        return new ViewGlare(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewGlare holder, @SuppressLint("RecyclerView") int position) {
        holder.uri_img.setImageBitmap(b);
        holder.effect_img.setImageResource(glare[position]);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Photo_Editing_Activity)activity).glare_image.setImageResource(glare[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return glare.length;
    }

    class ViewGlare extends RecyclerView.ViewHolder {
        private final ImageView uri_img;
        private final ImageView effect_img;
        private final LinearLayout linear;
        public ViewGlare(@NonNull View itemView) {
            super(itemView);
            uri_img=itemView.findViewById(R.id.uri_img);
            effect_img=itemView.findViewById(R.id.effect_img);
            linear=itemView.findViewById(R.id.linear);
        }
    }
}
