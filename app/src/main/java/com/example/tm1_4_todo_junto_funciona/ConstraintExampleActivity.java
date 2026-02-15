package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConstraintExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_example);

        Button btnSeguir = findViewById(R.id.btnSeguir);
        Button btnMensaje = findViewById(R.id.btnMensaje);

        btnSeguir.setOnClickListener(v ->
                Toast.makeText(this, "Seguir: OK", Toast.LENGTH_SHORT).show()
        );

        btnMensaje.setOnClickListener(v ->
                Toast.makeText(this, "Mensaje: OK", Toast.LENGTH_SHORT).show()
        );
    }

}
