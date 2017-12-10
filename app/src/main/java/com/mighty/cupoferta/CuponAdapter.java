package com.mighty.cupoferta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mighty.cupoferta.model.Coupon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeanp on 07/12/2017.
 */

public class CuponAdapter extends RecyclerView.Adapter<CuponAdapter.ViewHolder>{
    /*
    private LayoutInflater layoutInflater;
    public CuponAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }
    */
    private List<Coupon> cuponList = new ArrayList<>();

    public CuponAdapter(List<Coupon> cuponList) {
        this.cuponList = cuponList;
    }
    public CuponAdapter(){
        this.cuponList = new ArrayList<>();
    }
    public void setAddListCupones(List<Coupon> cuponListe){
        cuponList.addAll(cuponListe);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        //View view = layoutInflater.inflate(R.layout.card_row, parent, false);
        View v = layoutInflater.inflate(R.layout.card_row, parent, false);
        //ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Coupon coupon = cuponList.get(position);
        holder.getTv_titulo().setText(coupon.getTitulo());
        holder.getTv_descripcion().setText(coupon.getDescripcion());
        holder.getTv_empresa().setText(coupon.getEmpresa());
        /*
        holder.tv_titulo.setText(cupon.get(i).getTitulo());
        holder.tv_empresa.setText(cupon.get(i).getEmpresa());
        holder.tv_descripcion.setText(cupon.get(i).getDescripcion());
        */
    }

    @Override
    public int getItemCount() {
        return cuponList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_titulo, tv_descripcion, tv_empresa;
        public ViewHolder(View iteView){
            super(iteView);
            tv_titulo = (TextView) iteView.findViewById(R.id.tv_titulo);
            tv_descripcion = (TextView) iteView.findViewById(R.id.tv_descripcion);
            tv_empresa = (TextView) iteView.findViewById(R.id.tv_empresa);
        }

        public TextView getTv_titulo() {
            return tv_titulo;
        }

        public TextView getTv_descripcion() {
            return tv_descripcion;
        }

        public TextView getTv_empresa() {
            return tv_empresa;
        }
    }
    /*
    private ArrayList<Cupon> cupon;

    public CuponAdapter(ArrayList<Cupon> cupon) {
        this.cupon = cupon;
    }

    @Override
    public CuponAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.tv_titulo.setText(cupon.get(i).getTitulo());
        holder.tv_empresa.setText(cupon.get(i).getEmpresa());
        holder.tv_descripcion.setText(cupon.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return cupon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_titulo, tv_descripcion, tv_empresa;

        public ViewHolder(View view) {
            super(view);
            tv_titulo = (TextView) view.findViewById(R.id.tv_titulo);
            tv_descripcion = (TextView) view.findViewById(R.id.tv_descripcion);
            tv_empresa = (TextView) view.findViewById(R.id.tv_empresa);
        }
    }*/
}
