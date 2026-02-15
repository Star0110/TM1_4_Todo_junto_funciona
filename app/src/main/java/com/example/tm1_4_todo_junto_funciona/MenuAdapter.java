package com.example.tm1_4_todo_junto_funciona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.VH> {
    private final List<com.example.tm1_4_todo_junto_funciona.MainActivity_Containers.ExampleItem> data;
    private final com.example.tm1_4_todo_junto_funciona.MainActivity_Containers.OnExampleClick click;

    public MenuAdapter(List< com.example.tm1_4_todo_junto_funciona.MainActivity_Containers.ExampleItem> data, com.example.tm1_4_todo_junto_funciona.MainActivity_Containers.OnExampleClick click ){
        this.data = data;
        this.click = click;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        MainActivity_Containers.ExampleItem item = data.get(position);
        holder.title.setText(item.title);
        holder.desc.setText(item.desc);

        holder.itemView.setOnClickListener(v -> click.onClick(item));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView title, desc;
        VH(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitulo);
            desc = itemView.findViewById(R.id.txtDesc);
        }
    }
}
