package com.example.mypixeleffect.Activity;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

import static com.example.mypixeleffect.Adapters.Text_Adapters.Text_Bottom_Bar_Adapter.get_Text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.Shader;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypixeleffect.Adapters.Photo_Editing_Adapters.Edit_Bar_Adapter;
import com.example.mypixeleffect.Adapters.Text_Adapters.Text_Bottom_Bar_Adapter;
import com.example.mypixeleffect.Color_Picker.ColorPickerView;
import com.example.mypixeleffect.Color_Picker.OnColorSelectedListener;
import com.example.mypixeleffect.Color_Picker.builder.ColorPickerClickListener;
import com.example.mypixeleffect.Color_Picker.builder.ColorPickerDialogBuilder;
import com.example.mypixeleffect.R;
import com.example.mypixeleffect.Sticker.StickerView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Photo_Editing_Activity extends AppCompatActivity {

    public String editText;
    public ImageView effect_image, glare_image, img, text_back, text_done;
    public Uri uri;
    private LinearLayout text_activity;
    public LinearLayout blur_layout, text_size_layout, text_color_layout, effect_view_bar_layout;
    public TextView text, blur_done, text_size_done, text_color_done,effect_view_bar_done;
    private FrameLayout frame;
    private StickerView mCurrentView;
    public RecyclerView edit_bar, effect_view_bar, text_effect, pattern_bar, rv_color_picker;
    private int[] color_picker;
    private SeekBar seek_Bar;

    List<String> list = new ArrayList<>();
    List<String> list_text = new ArrayList<>();
    int[] image = {R.drawable.ic_3d, R.drawable.ic_effect, R.drawable.ic_baseline_colorize_24, R.drawable.ic_lenseflare, R.drawable.icon_edit, R.drawable.ic_baseline_text_format_24, R.drawable.ic_baseline_insert_emoticon_24, R.drawable.ic_baseline_screen_rotation_24, R.drawable.ic_baseline_flip_24};
    public int[] effect = {R.drawable.bg_3d_1_black, R.drawable.bg_3d_3_black, R.drawable.bg_3d_4_black, R.drawable.bg_3d_5_black,
            R.drawable.bg_3d_6_black, R.drawable.pixel_mask_1, R.drawable.pixel_mask_2, R.drawable.splash_06, R.drawable.splash_01,
            R.drawable.splash_02, R.drawable.splash_03, R.drawable.splash_04, R.drawable.splash_05};
    public int[] effect2 = {R.drawable.pixel_2, R.drawable.pixel_3, R.drawable.pixel_01, R.drawable.pixel_02, R.drawable.pixel_03,
            R.drawable.pixel_4, R.drawable.pixel_6, R.drawable.pixel_7, R.drawable.pixel_8, R.drawable.pixel_04, R.drawable.pixel_05,
            R.drawable.pixel_06, R.drawable.pixel_9, R.drawable.pixel_13, R.drawable.pixel_14, R.drawable.pixel_15, R.drawable.pixel_16,
            R.drawable.pixel_17, R.drawable.pixel_18, R.drawable.pixel_19, R.drawable.pixel_20, R.drawable.pixel_21, R.drawable.pixel_22,
            R.drawable.pixel_23, R.drawable.pixel_24, R.drawable.pixel_25, R.drawable.pixel_26, R.drawable.pixel_27, R.drawable.pixel_28,
            R.drawable.pixel_31, R.drawable.pixel_32, R.drawable.pixel_33, R.drawable.pixel_34};
    public int[] glare = {R.drawable.flare_01, R.drawable.flare_02, R.drawable.flare_03, R.drawable.flare_04, R.drawable.flare_05, R.drawable.flare_06};
    int[] text_img_list = {R.drawable.addtext, R.drawable.fontsize, R.drawable.colortext, R.drawable.fontstyle, R.drawable.ic_baseline_pattern_24, R.drawable.ic_baseline_blur_on_24};
    private RadioGroup blur_group;
    private RadioButton none_blur, inner_blur, normal_blur, outer_blur, solid_blur;
    private ImageView save_btn;
    private String ts;
    private float text_size;
    private float fs;
    public static Bitmap bitmap;
    private int selected_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_editing);
        id();
        effect_view_bar.setVisibility(View.GONE);
        list.add("3D");
        list.add("Effect");
        list.add("Color");
        list.add("Glare");
        list.add("Filter");
        list.add("Text");
        list.add("Sticker");
        list.add("Rotate");
        list.add("Flip");
        list_text.add("TEXT");
        list_text.add("SIZE");
        list_text.add("COLOR");
        list_text.add("STYLE");
        list_text.add("PATTERN");
        list_text.add("BLUR");
        try {

            img.setImageBitmap(Crop_Activity.cropped);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Recycle_View();
        if (effect_image.getColorFilter()==null){
            effect_image.setColorFilter(Color.WHITE);
        }
        color_picker = getResources().getIntArray(R.array.Color_Picker);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_activity.setVisibility(View.GONE);
                pattern_bar.setVisibility(View.GONE);
                blur_layout.setVisibility(View.GONE);
                text_size_layout.setVisibility(View.GONE);
                text.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                text.getPaint().setMaskFilter(null);
                seek_Bar.setProgress(50);
                text.setTextColor(Color.BLACK);
                text.setTypeface(null);
                text.getPaint().setShader(null);
                text.setTextSize(25);
            }
        });
        effect_view_bar_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                effect_view_bar_layout.setVisibility(View.GONE);
            }
        });
        text_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {

                        text.setDrawingCacheEnabled(true);
                        text.buildDrawingCache();
                        Bitmap b = Bitmap.createBitmap(text.getDrawingCache());
                        text_sticker_Create(b);
                        text.setText("");
                        pattern_bar.setVisibility(View.GONE);
                        blur_layout.setVisibility(View.GONE);
                        text_size_layout.setVisibility(View.GONE);
                        text.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                        text.getPaint().setMaskFilter(null);
                        seek_Bar.setProgress(50);
                        text.setTextColor(Color.BLACK);
                        text.setTypeface(null);
                        text.getPaint().setShader(null);
                        text.setTextSize(25);
                        text_activity.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(Photo_Editing_Activity.this, "Please Add Text To Continue", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Photo_Editing_Activity.this, "Image Saved", Toast.LENGTH_SHORT).show();
                if (mCurrentView != null) {
                    mCurrentView.setInEdit(false);
                }
                frame.setDrawingCacheEnabled(true);
                frame.buildDrawingCache();
                bitmap = frame.getDrawingCache();
                saveToInternalSorage(bitmap);
                finish();
//                storeImage(bitmap);
            }
        });
        text_size_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_size_layout.setVisibility(View.GONE);
            }
        });
        text_color_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color_layout.setVisibility(View.GONE);
            }
        });
        seek_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                text.setTextSize(TypedValue.COMPLEX_UNIT_PX, i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                fs = text.getTextSize();
                seek_Bar.setProgress((int) fs);
                text.setTextSize(TypedValue.COMPLEX_UNIT_PX, seek_Bar.getProgress());
            }
        });
    }

    void Recycle_View() {
        Edit_Bar_Adapter edit_bar_adapter = new Edit_Bar_Adapter(Photo_Editing_Activity.this, list, image);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Photo_Editing_Activity.this, HORIZONTAL, false);
        edit_bar.setLayoutManager(layoutManager);
        edit_bar.setAdapter(edit_bar_adapter);
    }

    public void TextActivity() {
        text.setText("");
        text.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        text.getPaint().setMaskFilter(null);
        text.setTypeface(null);
        text.getPaint().setShader(null);
        text.setTextSize(25);
        text_activity.setVisibility(View.VISIBLE);
        Text_Bottom_Bar_Adapter text_BottomBar_adapter = new Text_Bottom_Bar_Adapter(Photo_Editing_Activity.this, list_text, text_img_list, editText);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(Photo_Editing_Activity.this, HORIZONTAL, false);
        text_effect.setLayoutManager(layoutManager1);
        text_effect.setAdapter(text_BottomBar_adapter);
    }

    public void blur() {
        blur_layout.setVisibility(View.VISIBLE);
        blur_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blur_layout.setVisibility(View.GONE);
                pattern_bar.setVisibility(View.VISIBLE);
            }
        });
        blur_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (none_blur.isChecked()) {
                    text.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                    text.getPaint().setMaskFilter(null);
                }
                if (inner_blur.isChecked()) {
                    apply_blur(BlurMaskFilter.Blur.INNER);
                }
                if (normal_blur.isChecked()) {
                    apply_blur(BlurMaskFilter.Blur.NORMAL);
                }
                if (outer_blur.isChecked()) {
                    apply_blur(BlurMaskFilter.Blur.OUTER);
                }
                if (solid_blur.isChecked()) {
                    apply_blur(BlurMaskFilter.Blur.SOLID);
                }
            }
        });
    }

    public void Pattern(int ptn) {
        text.setText(get_Text);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), ptn);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        text.getPaint().setShader(shader);
    }

    public void Text_Color() {
        ColorPickerDialogBuilder
                .with(Photo_Editing_Activity.this)
                .setTitle("Choose color")
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {

                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {

                        selected_color = selectedColor;
                        if (text != null) {
                            try {

                                text.setTextColor(selectedColor);
                                text.getPaint().setShader(null);
                            } catch (Exception e) {
                                Toast.makeText(Photo_Editing_Activity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Photo_Editing_Activity.this, "Something is Missing", Toast.LENGTH_SHORT).show();
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
//        text_color_layout.setVisibility(View.VISIBLE);
//        Text_Color_Adapter text_color_adapter=new Text_Color_Adapter(Photo_Editing_Activity.this,color_picker);
//        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(Photo_Editing_Activity.this,7);
//        rv_color_picker.setLayoutManager(layoutManager);
//        rv_color_picker.setAdapter(text_color_adapter);
    }

    void apply_blur(BlurMaskFilter.Blur blurMaskFilter) {
        int radius = (int) (text.getTextSize() / 10);
        text.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        BlurMaskFilter filter = new BlurMaskFilter(radius, blurMaskFilter);
        text.getPaint().setMaskFilter(filter);
    }

    void id() {
        img = findViewById(R.id.img);
        edit_bar = findViewById(R.id.edit_bar);
        effect_view_bar = findViewById(R.id.effect_view_bar);
        effect_image = findViewById(R.id.effect_image);
        text = findViewById(R.id.text);
        text_effect = findViewById(R.id.text_effect);
        text_back = findViewById(R.id.text_back);
        pattern_bar = findViewById(R.id.pattern_bar);
        frame = findViewById(R.id.frame);
        blur_layout = findViewById(R.id.blur_layout);
        blur_done = findViewById(R.id.blur_done);
        blur_group = findViewById(R.id.blur_group);
        none_blur = findViewById(R.id.none_blur);
        inner_blur = findViewById(R.id.inner_blur);
        normal_blur = findViewById(R.id.normal_blur);
        outer_blur = findViewById(R.id.outer_blur);
        solid_blur = findViewById(R.id.solid_blur);
        text_done = findViewById(R.id.text_done);
        text_size_layout = findViewById(R.id.text_size_layout);
        text_size_done = findViewById(R.id.text_size_done);
        seek_Bar = findViewById(R.id.seek_Bar);
        rv_color_picker = findViewById(R.id.rv_color_picker);
        text_color_done = findViewById(R.id.text_color_done);
        text_color_layout = findViewById(R.id.text_color_layout);
        save_btn = findViewById(R.id.save_btn);
        glare_image = findViewById(R.id.glare_image);
        effect_view_bar_layout = findViewById(R.id.effect_view_bar_layout);
        effect_view_bar_done = findViewById(R.id.effect_view_bar_done);
        text_activity = findViewById(R.id.text_activity);
    }


    public void sticker_Create(int img) {
        StickerView stickerView = new StickerView(Photo_Editing_Activity.this);
        stickerView.setImageResource(img);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        frame.addView(stickerView, layoutParams);
        setCurrentEdit(stickerView);
        stickerView.setOperationListener(new StickerView.OperationListener() {
            @Override
            public void onDeleteClick() {
                frame.removeView(stickerView);
            }

            @Override
            public void onEdit(StickerView stickerView) {
                mCurrentView.setInEdit(false);
                mCurrentView = stickerView;
                mCurrentView.setInEdit(true);
                frame.setOnTouchListener(new View.OnTouchListener() {
                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        mCurrentView.setInEdit(false);
                        return false;
                    }
                });
            }

            @Override
            public void onTop(StickerView stickerView) {

            }
        });
    }

    private void setCurrentEdit(StickerView stickerView) {
        if (mCurrentView != null) {
            mCurrentView.setInEdit(false);
        }
        mCurrentView = stickerView;
        stickerView.setInEdit(true);
    }

    public void text_sticker_Create(Bitmap bitmap) {
        StickerView stickerView = new StickerView(Photo_Editing_Activity.this);
        stickerView.setBitmap(bitmap);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        frame.addView(stickerView, layoutParams);
        text_setCurrentEdit(stickerView);
        stickerView.setOperationListener(new StickerView.OperationListener() {
            @Override
            public void onDeleteClick() {
                frame.removeView(stickerView);
            }

            @Override
            public void onEdit(StickerView stickerView) {
                mCurrentView.setInEdit(false);
                mCurrentView = stickerView;
                mCurrentView.setInEdit(true);
                frame.setOnTouchListener(new View.OnTouchListener() {
                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        mCurrentView.setInEdit(false);
                        return false;
                    }
                });
            }

            @Override
            public void onTop(StickerView stickerView) {
            }
        });
    }

    private void text_setCurrentEdit(StickerView stickerView) {
        if (mCurrentView != null) {
            mCurrentView.setInEdit(false);
        }
        mCurrentView = stickerView;
        stickerView.setInEdit(true);
    }

    public String saveToInternalSorage(Bitmap bitmapImage) {

        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File myDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyPixelEffect");
        myDirectory.mkdir();
        // Create imageDir
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-"+ n +".jpg";
        File mypath = new File(myDirectory, fname);

        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(mypath);
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
            new SingleMediaScanner(this, myDirectory);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return myDirectory.getAbsolutePath();
    }
    public class SingleMediaScanner implements MediaScannerConnection.MediaScannerConnectionClient {

        private MediaScannerConnection mMs;
        private File mFile;

        public SingleMediaScanner(Context context, File f) {
            mFile = f;
            mMs = new MediaScannerConnection(context, this);
            mMs.connect();
        }

        @Override
        public void onMediaScannerConnected() {
            mMs.scanFile(mFile.getAbsolutePath(), null);
        }

        @Override
        public void onScanCompleted(String path, Uri uri) {
            mMs.disconnect();
        }

    }
//    @SuppressLint("SimpleDateFormat")
//    public void createDirectoryAndSaveFile(Bitmap imageToSave) {
//        String nameFolder="mypixeleffect";
//        ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        File direct = new File(Environment.getExternalStorageDirectory() + "/"+nameFolder);
//
//        if (!direct.exists()) {
//            File wallpaperDirectory = new File("/sdcard/"+nameFolder+"/");
//            wallpaperDirectory.mkdirs();
//        }
//+
//
//        File file = new File("/sdcard/"+nameFolder+"/", ts+".jpeg");
//        if (file.exists()) {
//            file.delete();
//        }
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//        }
//
//        }
    @Override
    public void onBackPressed() {
        if (text_activity.getVisibility() == View.VISIBLE) {
            text_activity.setVisibility(View.GONE);
            text.setText("");
            text.setVisibility(View.GONE);
            text_size_layout.setVisibility(View.GONE);
            text_color_layout.setVisibility(View.GONE);
            blur_layout.setVisibility(View.GONE);
            pattern_bar.setVisibility(View.GONE);
            text_effect.setVisibility(View.GONE);

            text.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            text.getPaint().setMaskFilter(null);
            text.setTypeface(null);
            text.getPaint().setShader(null);
            text.setTextSize(25);
        } else {
            super.onBackPressed();
        }
    }
}