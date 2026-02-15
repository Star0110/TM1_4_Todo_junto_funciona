package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tm1_4_todo_junto_funciona.databinding.ActivityGroupBinding;


public class GroupActivity extends AppCompatActivity {
    private ActivityGroupBinding b;
    private boolean visible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityGroupBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.btnToggleGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visible = !visible;
                b.groupCard.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
    }
}