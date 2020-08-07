package com.example.middle.Proveedor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middle.R;

import java.util.List;

public class NewsItemsAdapter extends RecyclerView.Adapter<NewsItemsAdapter.NewsItemViewHolder> {
    private List<NewsItems> newsItems;

    public NewsItemsAdapter(List<NewsItems> newsItems) {
        this.newsItems = newsItems;
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
        holder.nombre.setText(newsItems.get(position).getNombre());
        holder.descripcion.setText(newsItems.get(position).getDescripcion());
        holder.precio.setText(newsItems.get(position).getPrecio());


    }

    @Override
    public int getItemCount() {
        return newsItems.size();
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
