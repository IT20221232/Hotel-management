package com.example.foodordering;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class homehoradapter extends RecyclerView.Adapter<homehoradapter.ViewHolder> {

     Context context;
     List<homehormodels> list;

    public homehoradapter(Context context, List<homehormodels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public homehoradapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull homehoradapter.ViewHolder holder, int position) {
      holder.imageview.setImageResource(list.get(position).getImage());
      holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageview;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.pizza);
            name=itemView.findViewById(R.id.ptext);
        }
    }
}
