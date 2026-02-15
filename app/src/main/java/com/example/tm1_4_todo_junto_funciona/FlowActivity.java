package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tm1_4_todo_junto_funciona.databinding.ActivityFlowBinding;

import java.util.Arrays;
import java.util.List;

public class FlowActivity extends AppCompatActivity {
    private ActivityFlowBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityFlowBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        List<Button> buttons = Arrays.asList(
                b.btn1, b.btn2, b.btn3, b.btn4,
                b.btn5, b.btn6, b.btn7, b.btn8
        );

        for (Button btn : buttons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FlowActivity.this,
                            "Click: " + btn.getText(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}