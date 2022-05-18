package com.example.mypixeleffect.Adapters.Text_Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypixeleffect.Activity.Photo_Editing_Activity;
import com.example.mypixeleffect.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class Text_Bottom_Bar_Adapter extends RecyclerView.Adapter<Text_Bottom_Bar_Adapter.TextData> {
    Activity activity;
    List<String> list_text;
    int[] text_img_list;
    public static String get_Text;
    int[] pattern = {R.drawable.pattern_01, R.drawable.pattern_02, R.drawable.pattern_03, R.drawable.pattern_04, R.drawable.pattern_05, R.drawable.pattern_06, R.drawable.pattern_07, R.drawable.pattern_08, R.drawable.pattern_09, R.drawable.pattern_10};
    public Dialog dialog;


    public Text_Bottom_Bar_Adapter(Photo_Editing_Activity photo_editing_activity, List<String> list_text, int[] text_img_list, String get_Text) {
        activity = photo_editing_activity;
        this.list_text = list_text;
        this.text_img_list = text_img_list;
        this.get_Text = get_Text;
    }

    @NonNull
    @Override
    public TextData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.text_item, parent, false);
        return new TextData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextData holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(text_img_list[position]);
        holder.text.setText(list_text.get(position));
        holder.liner.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (position == 0) {
                    dialog = new Dialog(activity);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setContentView(R.layout.text_dialog);
                    CardView cardView = dialog.findViewById(R.id.btn_ok);
                    TextInputEditText edittext = dialog.findViewById(R.id.get_new_name);
                    dialog.setCancelable(true);
                    edittext.setText(get_Text);
                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            get_Text = edittext.getText().toString();
                            if (get_Text.length() == 0) {
                                edittext.setError("Enter");
                            } else {
                                ((Photo_Editing_Activity) activity).text.setText(get_Text);
                                dialog.dismiss();
                            }
                        }
                    });
                    dialog.show();
                    ((Photo_Editing_Activity)activity).pattern_bar.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).blur_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_size_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_color_layout.setVisibility(View.GONE);
                } else if (position == 1) {
                    ((Photo_Editing_Activity)activity).text_size_layout.setVisibility(View.VISIBLE);
                    ((Photo_Editing_Activity)activity).pattern_bar.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).blur_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_color_layout.setVisibility(View.GONE);
                } else if (position == 2) {
                    ((Photo_Editing_Activity)activity).Text_Color();
                    ((Photo_Editing_Activity)activity).pattern_bar.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).blur_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_size_layout.setVisibility(View.GONE);
                } else if (position == 3) {
                    Dialog dialog = new Dialog(activity);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setContentView(R.layout.font_piker_dialog);
                    TextView set_font_text = dialog.findViewById(R.id.set_font_text);
                    RecyclerView rv_font = dialog.findViewById(R.id.rv_font);
                    LinearLayout ok_btn = dialog.findViewById(R.id.ok_btn);
                    LinearLayout cancel_btn = dialog.findViewById(R.id.cancel_btn);
                    set_font_text.setText(get_Text);
                    Font_Adapter font_adapter = new Font_Adapter(activity, set_font_text);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity, 3);
                    rv_font.setLayoutManager(layoutManager);
                    rv_font.setAdapter(font_adapter);
                    cancel_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    ok_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Typeface typeface = set_font_text.getTypeface();
                            ((Photo_Editing_Activity) activity).text.setTypeface(typeface);
                            dialog.dismiss();
                        }
                    });
                    dialog.show();

                    ((Photo_Editing_Activity)activity).pattern_bar.setVisibility(View.GONE);
                    ((Photo_Editing_Activity) activity).blur_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_size_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_color_layout.setVisibility(View.GONE);
                } else if (position == 4) {
                    Text_Pattern_Adapter text_pattern_adapter = new Text_Pattern_Adapter(activity, pattern);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
                    ((Photo_Editing_Activity) activity).pattern_bar.setLayoutManager(layoutManager);
                    ((Photo_Editing_Activity) activity).pattern_bar.setAdapter(text_pattern_adapter);

                    ((Photo_Editing_Activity)activity).pattern_bar.setVisibility(View.VISIBLE);
                    ((Photo_Editing_Activity)activity).blur_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_size_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_color_layout.setVisibility(View.GONE);
                } else if (position == 5) {
                    ((Photo_Editing_Activity) activity).blur();

                    ((Photo_Editing_Activity)activity).blur_layout.setVisibility(View.VISIBLE);
                    ((Photo_Editing_Activity)activity).pattern_bar.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_size_layout.setVisibility(View.GONE);
                    ((Photo_Editing_Activity)activity).text_color_layout.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_text.size();
    }

    class TextData extends RecyclerView.ViewHolder {
        private final LinearLayout liner;
        private final ImageView img;
        private final TextView text;

        public TextData(@NonNull View itemView) {
            super(itemView);
            liner = itemView.findViewById(R.id.liner);
            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);
        }
    }
}
