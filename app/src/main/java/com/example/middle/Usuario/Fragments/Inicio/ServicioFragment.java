package com.example.middle.Usuario.Fragments.Inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middle.Proveedor.NewsItemsProveedor;
import com.example.middle.Proveedor.NewsItemsAdapterProveedor;
import com.example.middle.R;
import com.example.middle.Usuario.NewsItemsAdapterUsuario;
import com.example.middle.Usuario.NewsItemsUsuario;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServicioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServicioFragment newInstance(String param1, String param2) {
        ServicioFragment fragment = new ServicioFragment();
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
        View view = inflater.inflate(R.layout.fragment_producto, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.newsRecyclerViewProductos);
        List<NewsItemsUsuario> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            items.add(new NewsItemsUsuario("Maquillaje", "Se te arreglara la cara".concat(String.valueOf(i)), "S/15.00"));
        }
        recyclerView.setAdapter(new NewsItemsAdapterUsuario(items));
        return view;
    }
}