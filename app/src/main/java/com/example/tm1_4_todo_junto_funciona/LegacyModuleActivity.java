package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LegacyModuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legacy_module);

        Button btnTexto = findViewById(R.id.btn_legacy_texto);
        Button btnLayouts = findViewById(R.id.btn_legacy_layouts);
        Button btnWidgets = findViewById(R.id.btn_legacy_widgets);
        Button btnVolver = findViewById(R.id.btn_legacy_volver);

        btnTexto.setOnClickListener(v -> startActivity(new Intent(this, MainActivity_Texto.class)));
        btnLayouts.setOnClickListener(v -> startActivity(new Intent(this, MainActivity_layout.class)));
        btnWidgets.setOnClickListener(v -> startActivity(new Intent(this, MainActivity_Widgets.class)));
        btnVolver.setOnClickListener(v -> finish());
    }
}
