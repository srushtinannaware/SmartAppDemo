package com.example.smartappdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<String> titles;
    List<Integer> images;
    Context context;

    Adapter(Context context,List<String> titles,List<Integer> images){
        this.context = context;
        this.titles = titles;
        this.images = images;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.title.setText(titles.get(position));
        holder.gridicon.setImageResource(images.get(position));
        int positions = holder.getAdapterPosition();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //To switch activities when itemview is clicked

                Intent intent;
                switch (positions) {
                    case 0:
                        intent = new Intent(context,LivingRoom1.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context,BedRoom.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context,BathRoom.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context,LivingRoom2.class);
                        context.startActivity(intent);
                        break;

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView gridicon;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.textview);
            gridicon = itemView.findViewById(R.id.imageview);
        }
    }

}
