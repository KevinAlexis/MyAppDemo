package app.izzi.izzi.mx.myappdemo.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import app.izzi.izzi.mx.myappdemo.Modelos.Zapato;
import app.izzi.izzi.mx.myappdemo.MyInterfaces.MyConstants;
import app.izzi.izzi.mx.myappdemo.MyInterfaces.MyInterfaces;
import app.izzi.izzi.mx.myappdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoB extends Fragment implements View.OnClickListener{

    private Button mModificaBoton;
    private TextView mTextNombreZapato;
    private Zapato mZapato;
    MyInterfaces.ComunicateInterface mComunicateInterface;
    public static final String KEY_ZAPATO = "KEYZAPATO";

    public FragmentoB() {
        // Required empty public constructor
    }

    public static FragmentoB newInstance(Zapato zapato) {
        Bundle args = new Bundle();
        FragmentoB fragment = new FragmentoB();
        fragment.setArguments(args);
        args.putSerializable(KEY_ZAPATO,zapato);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mComunicateInterface = (MyInterfaces.ComunicateInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_b, container, false);
        mModificaBoton = view.findViewById(R.id.buttonModificaNombre);
        mTextNombreZapato = view.findViewById(R.id.textMuestraZapato);
        mZapato = (Zapato) getArguments().getSerializable(KEY_ZAPATO);
        mTextNombreZapato.setText(mZapato.getNombreZapato());
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.buttonModificaNombre:
                mZapato.setNombreZapato("converse de olga");
                mComunicateInterface.comunica(mZapato, MyConstants.FRAGMENT_DOs);
                break;
        }
    }

    public void setComunicateInterface(MyInterfaces.ComunicateInterface comunicateInterface) {
        mComunicateInterface = comunicateInterface;
    }
}
