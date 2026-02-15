package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentHostActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_host);
        // El fragment se agrega desde XML con android:name en FragmentContainerView.
    }
}
