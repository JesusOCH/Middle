package com.example.middle.Proveedor.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middle.Proveedor.NewsItems;
import com.example.middle.Proveedor.NewsItemsAdapter;
import com.example.middle.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment_Proveedor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment_Proveedor extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FloatingActionButton floatingActionButton;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InicioFragment_Proveedor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment_Proveedor newInstance(String param1, String param2) {
        InicioFragment_Proveedor fragment = new InicioFragment_Proveedor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio_proveedor, container, false);
        floatingActionButton = view.findViewById(R.id.solicitud);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear fragmento de tu clase
                Fragment fragment = new SolicitudFragment();
// Obtener el administrador de fragmentos a través de la actividad
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
// Definir una transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
// Remplazar el contenido principal por el fragmento
                fragmentTransaction.replace(R.id.fragmentInicioProveedor, fragment);
                fragmentTransaction.addToBackStack(null);
// Cambiar
                fragmentTransaction.commit();
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.newsRecyclerView);
        List<NewsItems> newsItems = new ArrayList<>();
        for (int i=0;i<15;i++){
            newsItems.add(new NewsItems("Maquillaje","Se te arreglara la cara".concat(String.valueOf(i)),"S/15.00"));
        }
        recyclerView.setAdapter(new NewsItemsAdapter(newsItems));
        return view;

    }
}