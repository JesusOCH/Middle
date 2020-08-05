package com.example.middle.Usuario.Fragments.Inicio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.middle.Proveedor.Fragments.InicioFragment_Proveedor;
import com.example.middle.Usuario.Fragments.InicioFragment_Usuario;

public class InicioAdapter extends FragmentStateAdapter {
    public InicioAdapter(@NonNull InicioFragment_Usuario fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new TendenciasFragment();
            case 1:
                return new ProductoFragment();
            default:
                return new ServicioFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
