package com.example.mypixeleffect.Adapters.Photo_Editing_Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Activity.Photo_Editing_Activity;
import com.example.mypixeleffect.R;

public class Sticker_Adapter extends RecyclerView.Adapter<Sticker_Adapter.ViewSticker> {
    Activity activity;
    int[] sticker_list;
    Dialog dialog;

    public Sticker_Adapter(Activity activity, int[] sticker_list, Dialog dialog) {
        this.activity=activity;
        this.sticker_list=sticker_list;
        this.dialog=dialog;
    }

    @NonNull
    @Override
    public ViewSticker onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.sticker_item,parent,false);
        return new ViewSticker(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewSticker holder, @SuppressLint("RecyclerView") int position) {
        holder.sticker.setImageResource(sticker_list[position]);
        holder.sticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Photo_Editing_Activity)activity).sticker_Create(sticker_list[position]);
                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sticker_list.length;
    }

    class ViewSticker extends RecyclerView.ViewHolder {
        private final ImageView sticker;

        public ViewSticker(@NonNull View itemView) {
            super(itemView);
            sticker=itemView.findViewById(R.id.sticker);
        }
    }
}
