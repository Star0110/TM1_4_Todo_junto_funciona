package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pantalla_principal extends AppCompatActivity {

    Button Btn_textos, Btn_botones, Btn_botones2, Btn_widgets, Btn_layouts, Btn_containers, Btn_helpers, Btn_google, Btn_legacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_principal);
        Btn_textos = findViewById(R.id.Pbtn_textos);
        Btn_botones = findViewById(R.id.Pbtn_botones);
        Btn_botones2 = findViewById(R.id.Pbtn_botones2);
        Btn_widgets = findViewById(R.id.Pbtn_widgets);
        Btn_layouts=findViewById(R.id.Pbtn_layouts);
        Btn_helpers=findViewById(R.id.Pbtn_helpers);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Btn_textos.setOnClickListener(v -> {
            Intent intent=new Intent(this,MainActivity_Texto.class);
            startActivity(intent);
        });
        Btn_botones.setOnClickListener(v -> {
            Intent intent=new Intent(this,MainActivity_Botones.class);
            startActivity(intent);
        });
        Btn_botones2.setOnClickListener(v -> {
            Intent intent=new Intent(this,MainActivity_botones2.class);
            startActivity(intent);
        });
        Btn_widgets.setOnClickListener(v -> {
            Intent intent=new Intent(this,MainActivity_Widgets.class);
            startActivity(intent);
        });

        Btn_layouts.setOnClickListener(v -> {
            Intent intent=new Intent(this,MainActivity_layout.class);
            startActivity(intent);
        });
        Btn_helpers.setOnClickListener(v -> {
            Intent intent=new Intent(this,MainActivity_helpers.class);
            startActivity(intent);
        });




    }
}