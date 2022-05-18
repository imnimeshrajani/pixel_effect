package com.example.mypixeleffect.Adapters.Text_Adapters;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Activity.Photo_Editing_Activity;
import com.example.mypixeleffect.R;

public class Text_Pattern_Adapter extends RecyclerView.Adapter<Text_Pattern_Adapter.ViewTextPattern> {
    Activity activity_pattern;
    int[] pattern;
    public Text_Pattern_Adapter(Activity activity, int[] pattern) {
        activity_pattern=activity;
        this.pattern=pattern;
    }

    @NonNull
    @Override
    public ViewTextPattern onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity_pattern).inflate(R.layout.effect_view_item,parent,false);
        return new ViewTextPattern(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTextPattern holder, @SuppressLint("RecyclerView") int position) {
        holder.uri_img.setImageResource(pattern[position]);
        holder.effect_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {;
                ((Photo_Editing_Activity)activity_pattern).Pattern(pattern[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pattern.length;
    }

    class ViewTextPattern extends RecyclerView.ViewHolder {
        private final ImageView uri_img,effect_img;
        private final LinearLayout linear;

        public ViewTextPattern(@NonNull View itemView) {
            super(itemView);
            uri_img=itemView.findViewById(R.id.uri_img);
            linear=itemView.findViewById(R.id.linear);
            effect_img=itemView.findViewById(R.id.effect_img);
        }
    }
}
