package com.example.cl01_introduccion.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.cl01_introduccion.R;
import com.example.cl01_introduccion.db.entity.NotaEntity;

import java.util.ArrayList;
import java.util.List;


public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private MyNotaRecyclerViewAdapter adapterNotas;
    private List<NotaEntity> notaList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
            if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180){
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
                int numeroColumnas = (int) (dpWidth/180);

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
            }

            notaList = new ArrayList<>();
            notaList.add(new NotaEntity("Lista de la compra", "comprar pan tostado", true, android.R.color.holo_blue_light));
            notaList.add(new NotaEntity("Recordar", "He aparcado el coche en la calle República Argenina, no olvidarme de pagar en el parquímetro", false, android.R.color.holo_green_light));
            notaList.add(new NotaEntity("Cumpleaños (fiesta)", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", true, android.R.color.holo_orange_light));

            adapterNotas = new MyNotaRecyclerViewAdapter(notaList, getActivity());
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }


}