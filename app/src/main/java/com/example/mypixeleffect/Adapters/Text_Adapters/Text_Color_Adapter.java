package com.example.mypixeleffect.Adapters.Text_Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Activity.Photo_Editing_Activity;
import com.example.mypixeleffect.R;

public class Text_Color_Adapter extends RecyclerView.Adapter<Text_Color_Adapter.ViewTextColor> {
    Activity activity;
    int[] color_picker;
    public Text_Color_Adapter(Photo_Editing_Activity photo_editing_activity, int[] color_picker) {
        activity=photo_editing_activity;
        this.color_picker=color_picker;
    }

    @NonNull
    @Override
    public ViewTextColor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.color_item,parent,false);
        return new ViewTextColor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTextColor holder, @SuppressLint("RecyclerView") int position) {
        holder.color.setBackgroundColor(color_picker[position]);
        holder.color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Photo_Editing_Activity)activity).text.setTextColor(color_picker[position]);
                ((Photo_Editing_Activity)activity).text.getPaint().setShader(null);;
            }
        });
    }

    @Override
    public int getItemCount() {
        return color_picker.length;
    }

    class ViewTextColor extends RecyclerView.ViewHolder {
        private final LinearLayout linear,color;

        public ViewTextColor(@NonNull View itemView) {
            super(itemView);
            color=itemView.findViewById(R.id.color);
            linear=itemView.findViewById(R.id.linear);
        }
    }
}
