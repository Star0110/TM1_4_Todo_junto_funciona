package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView text = findViewById(R.id.txt_about_body);
        text.setText(getString(R.string.about_body));

        Button btnVolver = findViewById(R.id.btn_about_volver);
        btnVolver.setOnClickListener(v -> finish());
    }
}
