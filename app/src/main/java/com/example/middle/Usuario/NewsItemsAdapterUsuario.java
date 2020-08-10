package com.example.middle.Usuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middle.R;

import java.util.List;

public class NewsItemsAdapterUsuario extends RecyclerView.Adapter<NewsItemsAdapterUsuario.NewsItemViewHolder> {
    private List<NewsItemsUsuario> newsItemsUsuarios;

    public NewsItemsAdapterUsuario(List<NewsItemsUsuario> newsItemsUsuarios) {
        this.newsItemsUsuarios = newsItemsUsuarios;
    }

    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsItemViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.news_items_container_usuarios,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder holder, int position) {
        holder.nombre.setText(newsItemsUsuarios.get(position).getNombre());
        holder.nombreEmpresa.setText(newsItemsUsuarios.get(position).getNombreEmpresa());
        holder.precio.setText(newsItemsUsuarios.get(position).getPrecio());


    }

    @Override
    public int getItemCount() {
        return newsItemsUsuarios.size();
    }

    class NewsItemViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre, nombreEmpresa, precio;

        NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            nombreEmpresa = itemView.findViewById(R.id.nombre_empresa);
            precio = itemView.findViewById(R.id.precio);

        }
    }
}
