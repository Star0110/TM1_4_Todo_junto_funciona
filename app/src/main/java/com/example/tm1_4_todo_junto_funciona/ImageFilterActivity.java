package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tm1_4_todo_junto_funciona.databinding.ActivityImageFilterBinding;


public class ImageFilterActivity extends AppCompatActivity {
    private ActivityImageFilterBinding b;
    private boolean toggled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityImageFilterBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        // Seekbars -> ImageFilterView
        b.seekSaturation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b.imageFilter.setSaturation(progress / 100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        b.seekContrast.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b.imageFilter.setContrast(progress / 100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // ImageFilterButton: crossfade 0..1
        b.btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggled = !toggled;
                b.btnFilter.setCrossfade(toggled ? 1f : 0f);
            }
        });
    }
}