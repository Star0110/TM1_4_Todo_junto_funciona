package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Widgets extends AppCompatActivity {

    ImageView img_imagen;
    WebView web_contenido;
    VideoView vid_video;
    Button btn_regresar;
    ProgressBar progHorizontal, progNormal;
    SeekBar seekNormal, seekDiscrete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_widgets);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Conexión con el layout (Instancias)
        img_imagen = findViewById(R.id.Wimg_imagen);
        web_contenido = findViewById(R.id.Wweb_contenido);
        vid_video = findViewById(R.id.Wvid_video);
        btn_regresar = findViewById(R.id.Wbtn_regresar);
        progHorizontal = findViewById(R.id.Wprog_horizontal);
        progNormal = findViewById(R.id.Wprog_normal);
        seekNormal = findViewById(R.id.Wseek_normal);
        seekDiscrete = findViewById(R.id.Wseek_discrete);

        // ImageView
        img_imagen.setImageResource(R.drawable.imagen);

        // WebView
        web_contenido.getSettings().setJavaScriptEnabled(true);
        web_contenido.loadUrl("https://www.google.com/");
        web_contenido.setNestedScrollingEnabled(true);
        web_contenido.setOnTouchListener((v, event) -> {
            v.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        });


        // VideoView
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        vid_video.setVideoURI(videoUri);

        // Mediacontroller para el VideoView
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vid_video);
        vid_video.setMediaController(mediaController);
        vid_video.setOnPreparedListener(mp -> vid_video.start());

        // SeekBar y Progress Bar Horizontal
        seekNormal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progHorizontal.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Widgets.this,
                        "Progreso ajustado a: " + seekBar.getProgress() + "%",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // SeekBar Discrete
        seekDiscrete.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Widgets.this,
                        "Nivel seleccionado: " + seekBar.getProgress(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Botón - Regresar
        btn_regresar.setOnClickListener(v -> {
            Intent intent=new Intent(this,Pantalla_principal.class);
            startActivity(intent);
            finishAffinity();
        });

    }
}