package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tm1_4_todo_junto_funciona.databinding.ActivityBarrierBinding;


public class BarrierActivity extends AppCompatActivity {
    private ActivityBarrierBinding b;
    private boolean longLabel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBarrierBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.btnToggleLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                longLabel = !longLabel;
                b.tvEmail.setText(longLabel ?
                        "Correo Electrónico (obligatorio para registro):" :
                        "Correo Electrónico:");
            }
        });
    }
}