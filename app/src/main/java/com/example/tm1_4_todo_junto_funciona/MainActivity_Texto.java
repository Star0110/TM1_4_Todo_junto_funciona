package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_Texto extends AppCompatActivity {

    private Button buttonTexto;
    private Button buttonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_texto);

        buttonTexto = findViewById(R.id.buttonTexto);
        buttonSalir = findViewById(R.id.buttonSalir);

        buttonTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_Texto.this, TextExamplesActivity.class);
                startActivity(intent);
            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity_Texto.this, Pantalla_principal.class);
                startActivity(intent);
                finishAffinity();


            }

        });
    }
}