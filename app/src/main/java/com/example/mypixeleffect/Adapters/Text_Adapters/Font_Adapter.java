package com.example.mypixeleffect.Adapters.Text_Adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.R;

public class Font_Adapter extends RecyclerView.Adapter<Font_Adapter.ViewFont> {
    Activity activity;
    String[] font_path = {"Font/font1.ttf", "Font/font2.ttf", "Font/font3.ttf", "Font/font4.TTF", "Font/font5.ttf", "Font/font6.TTF", "Font/font7.ttf", "Font/font8.ttf", "Font/font9.ttf", "Font/font10.TTF", "Font/font11.ttf", "Font/font12.ttf", "Font/font14.TTF", "Font/font16.TTF", "Font/font18.ttf", "Font/font19.ttf", "Font/font20.ttf", "Font/font21.ttf"};
    TextView set_font_text;
    public Font_Adapter(Activity activity, TextView set_font_text) {
        this.activity = activity;
        this.set_font_text=set_font_text;
    }

    @NonNull
    @Override
    public ViewFont onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.font_item, parent, false);
        return new ViewFont(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewFont holder, int position) {
        Typeface typeface = Typeface.createFromAsset(activity.getAssets(),font_path[position]);
        holder.font_style.setTypeface(typeface);
        holder.font_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_font_text.setTypeface(typeface);
            }
        });
    }

    @Override
    public int getItemCount() {
        return font_path.length;
    }

    class ViewFont extends RecyclerView.ViewHolder {
        private final TextView font_style;
        private final LinearLayout font_click;

        public ViewFont(@NonNull View itemView) {
            super(itemView);
            font_style = itemView.findViewById(R.id.font_style);
            font_click = itemView.findViewById(R.id.font_click);
        }
    }
}
