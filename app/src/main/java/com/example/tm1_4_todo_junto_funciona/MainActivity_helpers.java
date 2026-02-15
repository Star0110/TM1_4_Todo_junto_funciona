package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity_helpers extends AppCompatActivity {
    Button BtnBarrier, BtnFlow, BtnGuideline, BtnLayer, BtnImageFilter, BtnGroup, BtnMockView, BtnSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_helpers);
        BtnBarrier = findViewById(R.id.btnBarrier);
        BtnFlow = findViewById(R.id.btnFlow);
        BtnGuideline = findViewById(R.id.btnGuideline);
        BtnLayer = findViewById(R.id.btnLayer);
        BtnImageFilter = findViewById(R.id.btnImageFilter);
        BtnGroup = findViewById(R.id.btnGroup);
        BtnMockView = findViewById(R.id.btnMockView);
        BtnSalir = findViewById(R.id.btnSalir);


        BtnBarrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_helpers.this, BarrierActivity.class));
            }
        });

        BtnFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_helpers.this, FlowActivity.class));
            }
        });

        BtnGuideline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_helpers.this, GuidelineActivity.class));
            }
        });

        BtnLayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_helpers.this, LayerActivity.class));
            }
        });

        BtnImageFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_helpers.this, ImageFilterActivity.class));
            }
        });

        BtnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_helpers.this, GroupActivity.class));
            }
        });

        BtnMockView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_helpers.this, MockViewActivity.class));
            }
        });
        BtnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_helpers.this, Pantalla_principal.class);
                startActivity(intent);
                finishAffinity();
            }
        });

    }
}