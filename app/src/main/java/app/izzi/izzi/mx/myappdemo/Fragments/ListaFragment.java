package app.izzi.izzi.mx.myappdemo.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.izzi.izzi.mx.myappdemo.Modelos.Zapato;
import app.izzi.izzi.mx.myappdemo.MyAdapters.MyAdapter;
import app.izzi.izzi.mx.myappdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {


    public ListaFragment() {

    }

    private ArrayList<Zapato> mZapatoes;
    private RecyclerView  mRecyclerLugares;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        mZapatoes = new ArrayList<>();
        addZapatos();
        mRecyclerLugares = view.findViewById(R.id.recyclerLugares);
        MyAdapter myAdapter = new MyAdapter(getActivity(),mZapatoes);
        mRecyclerLugares.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerLugares.setLayoutManager(linearLayoutManager);
        return view;
    }

    public void addZapatos(){
        for (int i = 0 ; i < 10 ; i++){
            String nombre = "zapato" + i;
            Zapato zapato = new Zapato(nombre);
            mZapatoes.add(zapato);
        }
    }

}
