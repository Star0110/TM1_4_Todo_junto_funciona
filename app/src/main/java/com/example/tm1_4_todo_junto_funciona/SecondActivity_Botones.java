package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.transition.Fade;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SecondActivity_Botones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_botones);

        // Recibir los datos del Intent
        String username = getIntent().getStringExtra("USERNAME");
        if (username == null) username = "Usuario";

        String message = getIntent().getStringExtra("MESSAGE");
        if (message == null) message = "";

        long timestamp = getIntent().getLongExtra("TIMESTAMP", 0);
        int counter = getIntent().getIntExtra("COUNTER", 0);

        String difficulty = getIntent().getStringExtra("DIFFICULTY");
        if (difficulty == null) difficulty = "No seleccionada";

        // Formatear la fecha
        Date date = new Date(timestamp);
        SimpleDateFormat formatter =
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        String formattedDate = formatter.format(date);

        // Mostrar los datos recibidos
        ((TextView) findViewById(R.id.txtWelcome))
                .setText("¡Hola, " + username + "!");
        ((TextView) findViewById(R.id.txtMessage))
                .setText(message);
        ((TextView) findViewById(R.id.txtTimestamp))
                .setText("Hora de acceso: " + formattedDate);
        ((TextView) findViewById(R.id.txtCounterInfo))
                .setText("Contador en MainActivity: " + counter + " clicks");
        ((TextView) findViewById(R.id.txtDifficulty))
                .setText("Dificultad seleccionada: " + difficulty);

        // Información adicional
        ((TextView) findViewById(R.id.txtInfo)).setText(
                "Segunda Actividad (SecondActivity)\n\n" +
                        "Esta pantalla demuestra cómo pasar datos entre Activities usando Intent.\n\n" +
                        "Datos recibidos:\n" +
                        "• Nombre de usuario: " + username + "\n" +
                        "• Mensaje personalizado\n" +
                        "• Timestamp de acceso\n" +
                        "• Contador de clicks\n" +
                        "• Dificultad del juego\n\n" +
                        "ℹ Esta navegación se realizó usando:\n" +
                        "Intent + putExtra() + startActivity()"
        );

        // Botón Material para regresar
        MaterialButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            getWindow().setExitTransition(new Fade());
            finishAfterTransition();
        });

    }


}
