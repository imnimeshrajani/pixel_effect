package com.example.mypixeleffect.Adapters.Photo_Editing_Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Activity.Photo_Editing_Activity;
import com.example.mypixeleffect.R;

public class Effect_View_Adapter extends RecyclerView.Adapter<Effect_View_Adapter.ViewData> {
    Activity activity;
    Bitmap uri;
    int[] effect;
    int selected_color;

    @SuppressLint("NotifyDataSetChanged")
    public Effect_View_Adapter(Photo_Editing_Activity photo_editing_activity, Bitmap uri, int[] effect, int selected_color) {
        activity = photo_editing_activity;
        this.uri = uri;
        this.effect = effect;
        this.selected_color = selected_color;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.effect_view_item, parent, false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        holder.uri_img.setImageBitmap(uri);
        holder.effect_img.setImageResource(effect[position]);
//        holder.effect_img.setColorFilter(selected_color);
        holder.effect_img.setColorFilter(Color.WHITE);
        if (holder.effect_img.getColorFilter()!=null){
            holder.effect_img.setColorFilter(selected_color);
        }
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Photo_Editing_Activity) activity).effect_image.setImageResource(effect[position]);

            }
        });
    }

    @Override
    public int getItemCount() {
        return effect.length;
    }

    public void color(int selected_color) {
        this.selected_color = selected_color;
        notifyDataSetChanged();
    }

    class ViewData extends RecyclerView.ViewHolder {
        private final ImageView uri_img;
        public ImageView effect_img;
        private final LinearLayout linear;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            uri_img = itemView.findViewById(R.id.uri_img);
            effect_img = itemView.findViewById(R.id.effect_img);
            linear = itemView.findViewById(R.id.linear);
        }
    }
}
