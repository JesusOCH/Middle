package com.example.middle.Proveedor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middle.R;

import java.util.List;

public class NewsItemsAdapterProveedor extends RecyclerView.Adapter<NewsItemsAdapterProveedor.NewsItemViewHolder> {
    private List<NewsItemsProveedor> newsItemProveedors;

    public NewsItemsAdapterProveedor(List<NewsItemsProveedor> newsItemProveedors) {
        this.newsItemProveedors = newsItemProveedors;
    }

    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsItemViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.news_items_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder holder, int position) {
        holder.nombre.setText(newsItemProveedors.get(position).getNombre());
        holder.descripcion.setText(newsItemProveedors.get(position).getDescripcion());
        holder.precio.setText(newsItemProveedors.get(position).getPrecio());


    }

    @Override
    public int getItemCount() {
        return newsItemProveedors.size();
    }

    class NewsItemViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre,descripcion, precio;

        NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            precio = itemView.findViewById(R.id.precio);

        }
    }
}
