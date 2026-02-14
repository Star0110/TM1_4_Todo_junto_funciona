package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    Button Btn_acceder, Btn_cerrar;
    EditText Let_usuario, Let_contrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        Btn_acceder = findViewById(R.id.Lbtn_acceder);
        Btn_cerrar = findViewById(R.id.Lbtn_cerrar);
        Let_usuario = findViewById(R.id.Let_usuario);
        Let_contrasenia=findViewById(R.id.Let_contrasenia);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Btn_acceder.setOnClickListener(v -> {
            if(Let_usuario.getText().toString().equals("Equipo_Botones") && Let_contrasenia.getText().toString().equals("12345")) {
                Intent intent=new Intent(this,Pantalla_principal.class);
                startActivity(intent);
                finishAffinity();
            }
            else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
        Btn_cerrar.setOnClickListener(v -> {
            Toast.makeText(this, "Cerrando sesión", Toast.LENGTH_SHORT).show();
            finishAffinity();
        });
    }

}