package com.example.mypixeleffect.Adapters.Photo_Editing_Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.R;

public class Sticker_Cat_Adapter extends RecyclerView.Adapter<Sticker_Cat_Adapter.ViewData> {
    Activity activity1;
    int[] sticker_cat;
    RecyclerView sticker_recycle;
    Dialog dialog;

    int[] sticker_list1 = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a16, R.drawable.a19, R.drawable.a20, R.drawable.a21, R.drawable.a22, R.drawable.a24, R.drawable.a25, R.drawable.a26, R.drawable.a28, R.drawable.a29, R.drawable.a30, R.drawable.a32, R.drawable.a34, R.drawable.a35, R.drawable.a36};
    int[] sticker_list2 = {R.drawable.monster_01, R.drawable.monster_02, R.drawable.monster_03, R.drawable.monster_04, R.drawable.monster_05, R.drawable.monster_06, R.drawable.monster_07, R.drawable.monster_08, R.drawable.monster_09, R.drawable.monster_10, R.drawable.monster_11, R.drawable.monster_12, R.drawable.monster_13, R.drawable.monster_14, R.drawable.monster_15, R.drawable.monster_16, R.drawable.monster_17, R.drawable.monster_18, R.drawable.monster_19, R.drawable.monster_20, R.drawable.monster_21, R.drawable.monster_22, R.drawable.monster_23, R.drawable.monster_24, R.drawable.monster_25};
    int[] sticker_list3 = {R.drawable.l7, R.drawable.l8, R.drawable.l9, R.drawable.l10, R.drawable.l11, R.drawable.l12, R.drawable.l13, R.drawable.l14, R.drawable.l15, R.drawable.l16, R.drawable.l17, R.drawable.l18, R.drawable.l19, R.drawable.l20, R.drawable.l21, R.drawable.l22, R.drawable.l23, R.drawable.l24, R.drawable.l25, R.drawable.l26, R.drawable.l27, R.drawable.l28, R.drawable.l35, R.drawable.l36, R.drawable.l36, R.drawable.l37, R.drawable.l38, R.drawable.l39, R.drawable.l40, R.drawable.l42, R.drawable.cm_sticker_10, R.drawable.cm_sticker_11, R.drawable.cm_sticker_12, R.drawable.cm_sticker_13, R.drawable.cm_sticker_14, R.drawable.cm_sticker_15, R.drawable.cm_sticker_16, R.drawable.cm_sticker_17, R.drawable.cm_sticker_18, R.drawable.cm_sticker_18, R.drawable.cm_sticker_19, R.drawable.cm_sticker_20, R.drawable.cm_sticker_21};
    int[] sticker_list4 = {R.drawable.wedding01, R.drawable.wedding02, R.drawable.wedding03, R.drawable.wedding04, R.drawable.wedding05, R.drawable.wedding06, R.drawable.wedding07, R.drawable.wedding08, R.drawable.wedding09, R.drawable.wedding10, R.drawable.wedding11, R.drawable.wedding12, R.drawable.wedding13, R.drawable.wedding14, R.drawable.wedding15, R.drawable.wedding16, R.drawable.wedding17, R.drawable.wedding18, R.drawable.wedding19, R.drawable.wedding20, R.drawable.wedding21, R.drawable.wedding22};
    int[] sticker_list5 = {R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10, R.drawable.s11, R.drawable.s12, R.drawable.s13, R.drawable.s14, R.drawable.s15, R.drawable.s16, R.drawable.s17, R.drawable.s18, R.drawable.s19, R.drawable.s20};
    int[] sticker_list6 = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12, R.drawable.b13, R.drawable.b14, R.drawable.b15, R.drawable.b16, R.drawable.b17};

    public Sticker_Cat_Adapter(Activity activity, int[] sticker_cat, RecyclerView sticker_recycle, Dialog dialog) {
        this.activity1 = activity;
        this.sticker_cat = sticker_cat;
        this.sticker_recycle=sticker_recycle;
        this.dialog=dialog;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity1).inflate(R.layout.sticker_bar_item, parent, false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        holder.sticker_img.setImageResource(sticker_cat[position]);
        Sticker_Adapter sticker_adapter=new Sticker_Adapter(activity1,sticker_list1,dialog);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(activity1,3,RecyclerView.VERTICAL,false);
        sticker_recycle.setLayoutManager(layoutManager);
        sticker_recycle.setAdapter(sticker_adapter);
        holder.sticker_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    sticker(sticker_list1);
                } else if (position == 1) {
                    sticker(sticker_list2);
                } else if (position == 2) {
                    sticker(sticker_list3);
                } else if (position == 3) {
                    sticker(sticker_list4);
                } else if (position == 4) {
                    sticker(sticker_list5);
                } else if (position == 5) {
                    sticker(sticker_list6);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sticker_cat.length;
    }

    class ViewData extends RecyclerView.ViewHolder {
        private final ImageView sticker_img;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            sticker_img = itemView.findViewById(R.id.sticker_img);
        }
    }
    void sticker(int[] sticker_list_obj){
        Sticker_Adapter sticker_adapter=new Sticker_Adapter(activity1,sticker_list_obj,dialog);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(activity1,3,RecyclerView.VERTICAL,false);
        sticker_recycle.setLayoutManager(layoutManager);
        sticker_recycle.setAdapter(sticker_adapter);
    }
}
