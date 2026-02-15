package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tm1_4_todo_junto_funciona.databinding.ActivityMockviewBinding;


public class MockViewActivity extends AppCompatActivity {
    private ActivityMockviewBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMockviewBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
    }
}