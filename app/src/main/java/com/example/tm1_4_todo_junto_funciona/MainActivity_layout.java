package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity_layout extends AppCompatActivity {

    private FrameLayout contentFrame;
    private Button BtnSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        BtnSalir = findViewById(R.id.btnSalir);
        contentFrame = findViewById(R.id.content_frame);

        // Inicializar botones con la nueva estructura
        configurarBoton(R.id.btnLinear, R.layout.layout_linear);
        configurarBoton(R.id.btnRelative, R.layout.layout_relative);
        configurarBoton(R.id.btnTable, R.layout.layout_table);
        configurarBoton(R.id.btnFrame, R.layout.layout_frame);
        configurarBoton(R.id.btnConstraint, R.layout.layout_constraint);

        // Cargar el primero por defecto
        mostrarLayout(R.layout.layout_linear);

        BtnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity_layout.this, Pantalla_principal.class);
               startActivity(intent);
               finishAffinity();
            }
        });
    }

    private void configurarBoton(int idBoton, final int idLayout) {
        findViewById(idBoton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarLayout(idLayout);
            }
        });
    }

    private void mostrarLayout(int layoutId) {
        contentFrame.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);
        // Inflamos el layout dentro del frame
        View vista = inflater.inflate(layoutId, contentFrame, false);
        contentFrame.addView(vista);
    }
}