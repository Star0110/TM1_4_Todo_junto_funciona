package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tm1_4_todo_junto_funciona.databinding.ActivityGuidelineBinding;


public class GuidelineActivity extends AppCompatActivity {
    private ActivityGuidelineBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityGuidelineBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
    }
}