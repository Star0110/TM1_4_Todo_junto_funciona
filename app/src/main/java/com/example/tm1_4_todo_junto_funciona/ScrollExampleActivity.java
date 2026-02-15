package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ScrollExampleActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_example);

        EditText nombre = findViewById(R.id.edtNombre);
        EditText correo = findViewById(R.id.edtCorreo);
        Button enviar = findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(v -> {
            String n = nombre.getText().toString().trim();
            String c = correo.getText().toString().trim();
            Toast.makeText(this, "Enviado: " + n + " (" + c + ")", Toast.LENGTH_SHORT).show();
        });
    }
}
