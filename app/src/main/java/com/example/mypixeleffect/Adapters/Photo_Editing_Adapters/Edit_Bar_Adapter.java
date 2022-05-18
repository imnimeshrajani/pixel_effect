package com.example.mypixeleffect.Adapters.Photo_Editing_Adapters;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Adapters.Text_Adapters.Filter_Adapter;
import com.example.mypixeleffect.Color_Picker.ColorPickerView;
import com.example.mypixeleffect.Color_Picker.OnColorSelectedListener;
import com.example.mypixeleffect.Color_Picker.builder.ColorPickerClickListener;
import com.example.mypixeleffect.Color_Picker.builder.ColorPickerDialogBuilder;
import com.example.mypixeleffect.Activity.Crop_Activity;
import com.example.mypixeleffect.Activity.Photo_Editing_Activity;
import com.example.mypixeleffect.R;

import java.util.List;


public class Edit_Bar_Adapter extends RecyclerView.Adapter<Edit_Bar_Adapter.ViewData> {
    Activity activity;
    List<String> list;
    int[] image;
    int[] sticker_cat = {R.drawable.a1, R.drawable.monster_01, R.drawable.l7, R.drawable.wedding01, R.drawable.s1, R.drawable.b1};
    public RecyclerView sticker_recycle;
    public int selected_color;
    private Effect_View_Adapter effect_view_adapter;

    public Edit_Bar_Adapter(Photo_Editing_Activity photo_editing_activity, List<String> list, int[] image) {
        activity = photo_editing_activity;
        this.list = list;
        this.image = image;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.edit_bar_item, parent, false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(image[position]);
        holder.text.setText(list.get(position));
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    ((Photo_Editing_Activity) activity).effect_view_bar.setVisibility(View.VISIBLE);
                    ((Photo_Editing_Activity) activity).effect_view_bar_layout.setVisibility(View.VISIBLE);
                    effect_view_adapter = new Effect_View_Adapter((Photo_Editing_Activity) activity, Crop_Activity.cropped, ((Photo_Editing_Activity) activity).effect, selected_color);
                    RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(activity, HORIZONTAL, false);
                    ((Photo_Editing_Activity) activity).effect_view_bar.setLayoutManager(layoutManager1);
                    ((Photo_Editing_Activity) activity).effect_view_bar.setAdapter(effect_view_adapter);

                } else if (position == 1) {
                    ((Photo_Editing_Activity) activity).effect_view_bar.setVisibility(View.VISIBLE);
                    ((Photo_Editing_Activity) activity).effect_view_bar_layout.setVisibility(View.VISIBLE);
                    effect_view_adapter = new Effect_View_Adapter((Photo_Editing_Activity) activity, Crop_Activity.cropped, ((Photo_Editing_Activity) activity).effect2, selected_color);
                    RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(activity, HORIZONTAL, false);
                    ((Photo_Editing_Activity) activity).effect_view_bar.setLayoutManager(layoutManager1);
                    ((Photo_Editing_Activity) activity).effect_view_bar.setAdapter(effect_view_adapter);
                } else if (position == 2) {
                    ColorPickerDialogBuilder
                            .with(activity)
                            .setTitle("Choose color")
                            .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                            .density(12)
                            .setOnColorSelectedListener(new OnColorSelectedListener() {
                                @Override
                                public void onColorSelected(int selectedColor) {

                                }
                            })
                            .setPositiveButton("ok", new ColorPickerClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                    ((Photo_Editing_Activity) activity).effect_image.setColorFilter(selectedColor);
                                    selected_color = selectedColor;
                                    if (((Photo_Editing_Activity) activity).effect_image != null) {
                                        try {

                                            effect_view_adapter.color(selected_color);
                                        } catch (Exception e) {
                                            Toast.makeText(activity, "Please Choose An Effect", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            })
                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .build()
                            .show();
                } else if (position == 3) {
                    ((Photo_Editing_Activity) activity).effect_view_bar.setVisibility(View.VISIBLE);
                    ((Photo_Editing_Activity) activity).effect_view_bar_layout.setVisibility(View.VISIBLE);
                    Glare_Adapter glare_adapter = new Glare_Adapter((Photo_Editing_Activity) activity, Crop_Activity.cropped, ((Photo_Editing_Activity) activity).glare);
                    RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(activity, HORIZONTAL, false);
                    ((Photo_Editing_Activity) activity).effect_view_bar.setLayoutManager(layoutManager1);
                    ((Photo_Editing_Activity) activity).effect_view_bar.setAdapter(glare_adapter);
                } else if (position == 4) {
                    ((Photo_Editing_Activity) activity).effect_view_bar.setVisibility(View.VISIBLE);
                    ((Photo_Editing_Activity) activity).effect_view_bar_layout.setVisibility(View.VISIBLE);
                    Filter_Adapter filter_adapter = new Filter_Adapter((Photo_Editing_Activity) activity, ((Photo_Editing_Activity) activity).img);
                    RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(activity, HORIZONTAL, false);
                    ((Photo_Editing_Activity) activity).effect_view_bar.setLayoutManager(layoutManager1);
                    ((Photo_Editing_Activity) activity).effect_view_bar.setAdapter(filter_adapter);
                } else if (position == 5) {
                    ((Photo_Editing_Activity) activity).TextActivity();
                } else if (position == 6) {
                    Dialog dialog = new Dialog(activity);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setContentView(R.layout.sticker_dialog);
                    ImageView sticker_dialog_back = dialog.findViewById(R.id.sticker_dialog_back);
                    sticker_recycle = dialog.findViewById(R.id.sticker_recycle);
                    RecyclerView sticker_category = dialog.findViewById(R.id.sticker_category);
                    sticker_dialog_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    Sticker_Cat_Adapter sticker_Cat_adapter = new Sticker_Cat_Adapter(activity, sticker_cat, sticker_recycle, dialog);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity, HORIZONTAL, false);
                    sticker_category.setLayoutManager(layoutManager);
                    sticker_category.setAdapter(sticker_Cat_adapter);
                    dialog.setCancelable(false);
                    dialog.show();
                } else if (position == 7) {
                    ((Photo_Editing_Activity) activity).img.setRotation(((Photo_Editing_Activity) activity).img.getRotation() + 90);
                } else if (position == 8) {
                    if (((Photo_Editing_Activity) activity).img.getRotationY() == 180) {
                        ((Photo_Editing_Activity) activity).img.setRotationY(360);
                    } else {
                        ((Photo_Editing_Activity) activity).img.setRotationY(180);
                    }
//
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewData extends RecyclerView.ViewHolder {
        private final TextView text;
        private final ImageView img;
        private final LinearLayout linear;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            img = itemView.findViewById(R.id.img);
            linear = itemView.findViewById(R.id.linear);

        }
    }

}
