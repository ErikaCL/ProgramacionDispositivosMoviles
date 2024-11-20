package com.example.activity_06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AvionAdapter extends RecyclerView.Adapter<AvionAdapter.AvionHolder> {
    Plano plano;

    public AvionAdapter(Plano plano) {
        this.plano = plano;
    }

    @NonNull
    @Override
    public AvionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.avion_view, parent, false);
        return new AvionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvionHolder holder, int position) {
        int row = position / plano.col;
        int col = position % plano.col;

        Avion avion = plano.aviones.stream().filter(a -> a.x == col && a.y == row).findFirst().orElse(null);
        boolean isCollision = plano.colisiones.stream().anyMatch(c -> c.x == col && c.y == row);

        if (isCollision) {
            holder.imgAvion.setImageResource(R.mipmap.collision);
        } else if (avion != null) {
            holder.imgAvion.setImageResource(avion.getImage());
        } else {
            holder.imgAvion.setImageResource(0); // Vacío
        }
    }

    @Override
    public int getItemCount() {
        return plano.col * plano.row;
    }

    static class AvionHolder extends RecyclerView.ViewHolder {
        ImageView imgAvion;

        public AvionHolder(@NonNull View itemView) {
            super(itemView);
            imgAvion = itemView.findViewById(R.id.imgAvion);
        }
    }
}

