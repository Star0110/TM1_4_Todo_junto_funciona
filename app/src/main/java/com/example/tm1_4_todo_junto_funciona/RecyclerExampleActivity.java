package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_example);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        List<MainActivity_Containers.ExampleItem> items = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            // Cambio realizado aquí: .ExampleItem
            items.add(new MainActivity_Containers.ExampleItem("Elemento " + i, "Item con CardView", ConstraintExampleActivity.class));
        }

        com.example.tm1_4_todo_junto_funciona.MenuAdapter adapter = new MenuAdapter(items, item ->
                Toast.makeText(this, "Click: " + item.title, Toast.LENGTH_SHORT).show()
        );
        recycler.setAdapter(adapter);
    }
}
