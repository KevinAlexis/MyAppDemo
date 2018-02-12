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
public class FragmentUno extends Fragment implements View.OnClickListener{


    private Button mButtonCreaZapato;
    private TextView mTextzapatoregresado;
    public static final String KEY_ZAPATO = "keyZaatasada";


    MyInterfaces.ComunicateInterface mComunicateInterface;
    MyInterfaces.ComunicateInterfacedos mComunicateInterfacedos;

    public static FragmentUno newInstance(Zapato zapato) {
        Bundle args = new Bundle();
        FragmentUno fragment = new FragmentUno();
        args.putSerializable(KEY_ZAPATO,zapato);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentUno() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_uno, container, false);
        mButtonCreaZapato = view.findViewById(R.id.buttonCreaZapato);
        mButtonCreaZapato.setOnClickListener(this);
        mTextzapatoregresado = view.findViewById(R.id.textZapatoregresado);
        Bundle bundle = getArguments();

        if (getArguments() != null && bundle.containsKey(KEY_ZAPATO)){
            Zapato zapato = (Zapato) getArguments().getSerializable(KEY_ZAPATO);
            mTextzapatoregresado.setText(zapato.getNombreZapato());
        }
        else{
            mTextzapatoregresado.setText("No tengo la llave");
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mComunicateInterface = (MyInterfaces.ComunicateInterface) context;
        mComunicateInterfacedos = (MyInterfaces.ComunicateInterfacedos) context;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.buttonCreaZapato:
                Zapato zapato = new Zapato("nike");
                mComunicateInterface.comunica(zapato, MyConstants.FRAGMENT_UNO);
                mComunicateInterfacedos.comunica(zapato);
                break;
        }
    }

    public void setComunicateInterface(MyInterfaces.ComunicateInterface comunicateInterface) {
        mComunicateInterface = comunicateInterface;
    }
}
