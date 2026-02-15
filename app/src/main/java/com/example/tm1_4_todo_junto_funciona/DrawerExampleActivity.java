package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerExampleActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawer = findViewById(R.id.drawer);
        NavigationView nav = findViewById(R.id.navView);

        // Toolbar + botón ☰
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.open_drawer, R.string.close_drawer
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Contenido inicial
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentFrame, SimpleTextFragment.newInstance("Inicio"))
                .commit();

        nav.setNavigationItemSelectedListener(item -> {
            String txt;
            int id = item.getItemId();

            if (id == R.id.nav_home) txt = "Inicio";
            else if (id == R.id.nav_settings) txt = "Ajustes";
            else txt = "Acerca de";

            item.setChecked(true);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentFrame, SimpleTextFragment.newInstance(txt))
                    .commit();

            drawer.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
