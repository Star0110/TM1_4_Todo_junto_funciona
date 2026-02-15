package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SimpleTextFragment extends Fragment {
    private static final String ARG_TEXT = "text";

    public static SimpleTextFragment newInstance(String text) {
        SimpleTextFragment f = new SimpleTextFragment();
        Bundle b = new Bundle();
        b.putString(ARG_TEXT, text);
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_text, container, false);
        TextView t = v.findViewById(R.id.txt);
        String text = getArguments() != null ? getArguments().getString(ARG_TEXT) : "Inicio";
        t.setText(text);
        return v;

    }
}
