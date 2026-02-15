package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Containers extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_containers);

        RecyclerView recycler = findViewById(R.id.recyclerMenu);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        List<ExampleItem> items = new ArrayList<>();
        items.add(new ExampleItem("ConstraintLayout", "Alineación con constraints", ConstraintExampleActivity.class));
        items.add(new ExampleItem("ScrollView", "Formulario largo con scroll", ScrollExampleActivity.class));
        items.add(new ExampleItem("RecyclerView", "Lista eficiente con Adapter", RecyclerExampleActivity.class));
        items.add(new ExampleItem("DrawerLayout", "Menú lateral (NavigationView)", DrawerExampleActivity.class));
        items.add(new ExampleItem("FragmentContainerView", "Host para Fragments (XML)", FragmentHostActivity.class));
        items.add(new ExampleItem("CoordinatorLayout", "FAB + Snackbar coordinados", CoordinatorExampleActivity.class));

        MenuAdapter adapter = new MenuAdapter(items, item -> {
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, item.activityClass));
        });

        recycler.setAdapter(adapter);
    }

    public static class ExampleItem {
        public final String title;
        public final String desc;
        public final Class<? extends AppCompatActivity> activityClass;

        public ExampleItem(String title, String desc, Class<? extends AppCompatActivity> activityClass) {
            this.title = title;
            this.desc = desc;
            this.activityClass = activityClass;
        }
    }

    public interface OnExampleClick {
        void onClick(@NonNull ExampleItem item);
    }

}
