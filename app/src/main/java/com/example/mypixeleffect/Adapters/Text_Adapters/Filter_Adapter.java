package com.example.mypixeleffect.Adapters.Text_Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Filter_Effects;
import com.example.mypixeleffect.Activity.Photo_Editing_Activity;
import com.example.mypixeleffect.R;

public class Filter_Adapter extends RecyclerView.Adapter<Filter_Adapter.ViewFilter> {
    Activity activity;
    ImageView b;

    public Filter_Adapter(Photo_Editing_Activity activity, ImageView bitmap) {
        this.activity = activity;
        b=bitmap;
    }

    @NonNull
    @Override
    public ViewFilter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.filter_item, parent, false);
        return new ViewFilter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewFilter holder, @SuppressLint("RecyclerView") int position) {
        switch (position) {
            case 0:
                Filter_Effects.applyEffectNone(holder.img);
//                holder.img.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Filter_Effects.applyEffectNone(b);
//                    }
//                });
                break;
            case 1:
                Filter_Effects.applyEffect1(holder.img);
//                holder.img.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Filter_Effects.applyEffect1(b);
//                    }
//                });
                break;
            case 2:
                Filter_Effects.applyEffect2(holder.img);
                break;
            case 3:
                Filter_Effects.applyEffect3(holder.img);
                break;
            case 4:
                Filter_Effects.applyEffect4(holder.img);
                break;
            case 5:
                Filter_Effects.applyEffect5(holder.img);
                break;
            case 6:
                Filter_Effects.applyEffect6(holder.img);
                break;
            case 7:
                Filter_Effects.applyEffect7(holder.img);
                break;
            case 8:
                Filter_Effects.applyEffect8(holder.img);
                break;
            case 9:
                Filter_Effects.applyEffect9(holder.img);
                break;
            case 10:
                Filter_Effects.applyEffect10(holder.img);
                break;
            case 11:
                Filter_Effects.applyEffect11(holder.img);
                break;
            case 12:
                Filter_Effects.applyEffect12(holder.img);
                break;
            case 13:
                Filter_Effects.applyEffect13(holder.img);
                break;
            case 14:
                Filter_Effects.applyEffect14(holder.img);
                break;
            case 15:
                Filter_Effects.applyEffect15(holder.img);
                break;
            case 16:
                Filter_Effects.applyEffect16(holder.img);
                break;
            case 17:
                Filter_Effects.applyEffect17(holder.img);
                break;
            case 18:
                Filter_Effects.applyEffect18(holder.img);
                break;
            case 19:
                Filter_Effects.applyEffect19(holder.img);
                break;
            case 20:
                Filter_Effects.applyEffect20(holder.img);
                break;
            case 21:
                Filter_Effects.applyEffect21(holder.img);
                break;
            case 22:
                Filter_Effects.applyEffect22(holder.img);
                break;
        }
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){
                    Filter_Effects.applyEffectNone(b);
                } else if (position==1){
                    Filter_Effects.applyEffect1(b);
                } else if (position==2){
                    Filter_Effects.applyEffect2(b);
                } else if (position==3){
                    Filter_Effects.applyEffect3(b);
                } else if (position==4){
                    Filter_Effects.applyEffect4(b);
                } else if (position==5){
                    Filter_Effects.applyEffect5(b);
                } else if (position==6){
                    Filter_Effects.applyEffect6(b);
                } else if (position==7){
                    Filter_Effects.applyEffect7(b);
                } else if (position==8){
                    Filter_Effects.applyEffect8(b);
                } else if (position==9){
                    Filter_Effects.applyEffect9(b);
                } else if (position==10){
                    Filter_Effects.applyEffect10(b);
                } else if (position==11){
                    Filter_Effects.applyEffect11(b);
                } else if (position==12){
                    Filter_Effects.applyEffect12(b);
                } else if (position==13){
                    Filter_Effects.applyEffect13(b);
                } else if (position==14){
                    Filter_Effects.applyEffect14(b);
                } else if (position==15){
                    Filter_Effects.applyEffect15(b);
                } else if (position==16){
                    Filter_Effects.applyEffect16(b);
                } else if (position==17){
                    Filter_Effects.applyEffect17(b);
                } else if (position==18){
                    Filter_Effects.applyEffect18(b);
                }  else if (position==19){
                    Filter_Effects.applyEffect19(b);
                } else if (position==20){
                    Filter_Effects.applyEffect20(b);
                } else if (position==21){
                    Filter_Effects.applyEffect21(b);
                } else if (position==22){
                    Filter_Effects.applyEffect22(b);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 22;
    }

    class ViewFilter extends RecyclerView.ViewHolder {
        private final ImageView img;

        public ViewFilter(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
