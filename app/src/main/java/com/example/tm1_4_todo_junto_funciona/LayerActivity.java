package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tm1_4_todo_junto_funciona.databinding.ActivityLayerBinding;


public class LayerActivity extends AppCompatActivity {
    private ActivityLayerBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityLayerBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.seekRotation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // de 0..60 a -30..+30
                b.layer.setRotation((float)(progress - 30));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}