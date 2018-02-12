package app.izzi.izzi.mx.myappdemo.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import app.izzi.izzi.mx.myappdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZapatosFragment extends Fragment  {


    public ZapatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zapatos, container, false);
    }

}
