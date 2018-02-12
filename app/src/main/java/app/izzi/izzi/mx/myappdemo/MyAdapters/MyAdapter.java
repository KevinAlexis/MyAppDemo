package app.izzi.izzi.mx.myappdemo.MyAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.izzi.izzi.mx.myappdemo.Modelos.Zapato;
import app.izzi.izzi.mx.myappdemo.R;

/**
 * Created by qualtop on 11/02/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<Zapato> mZapatoes;
    private boolean isUserAlreadyTapIcon = false;

    public MyAdapter(Context context,ArrayList<Zapato> zapatoes) {
        mContext = context;
        mZapatoes = zapatoes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewLista = LayoutInflater.from(mContext).inflate(R.layout.item_view_zapatos,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(viewLista);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Zapato zapato = mZapatoes.get(position);
        holder.mTextNombreZapato.setText(zapato.getNombreZapato());
        holder.mImageIcono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUserAlreadyTapIcon = !isUserAlreadyTapIcon;
                notifyDataSetChanged();
            }
        });
        if (!isUserAlreadyTapIcon){
            if(position == 0 | position == 1){
                holder.mImageIcono.setVisibility(View.INVISIBLE);
                holder.mTextNombreZapato.setVisibility(View.VISIBLE);
                if (position == 1){
                    holder.mImageIcono.setVisibility(View.VISIBLE);
                }
            }
            else{
                holder.mImageIcono.setVisibility(View.INVISIBLE);
                holder.mTextNombreZapato.setVisibility(View.INVISIBLE);

            }
        }
        else {
            if (position == 1 || position == 2){
                holder.mImageIcono.setVisibility(View.VISIBLE);
                holder.mTextNombreZapato.setVisibility(View.VISIBLE);
                if (position == 1){holder.mImageIcono.setImageResource(R.drawable.ic_palomita);}

            }
            else {
                holder.mImageIcono.setVisibility(View.INVISIBLE);
                holder.mTextNombreZapato.setVisibility(View.INVISIBLE);

            }
        }




    }

    @Override
    public int getItemCount() {
        return mZapatoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        final TextView mTextNombreZapato;
        final ImageView mImageIcono;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextNombreZapato = itemView.findViewById(R.id.textNombreZapato);
            mImageIcono = itemView.findViewById(R.id.imageicono);
        }
    }
}
