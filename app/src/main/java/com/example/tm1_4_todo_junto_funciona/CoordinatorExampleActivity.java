package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CoordinatorExampleActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        View root = findViewById(android.R.id.content);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(v ->
                Snackbar.make(root, "¡Funciona el Snackbar!", Snackbar.LENGTH_LONG)
                        .setAction("OK", vv -> {})
                        .show()
        );
    }
}
