package es.cice.vehiculoslistview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.cice.vehiculoslistview.R;
import es.cice.vehiculoslistview.model.Vehiculo;

/**
 * Created by cice on 19/1/17.
 */

public class CarsAdapters extends ArrayAdapter<Vehiculo> {
    private Context context;
    private List<Vehiculo> datos;
    //private int LayoutResourceID;



    public CarsAdapters(Context context, int resource, List<Vehiculo> vehiculos) {
        super(context, resource, vehiculos);
        this.context = context;
        //this.LayoutResourceID = resource;
        this.datos = vehiculos;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = LayoutInflater.from(context);
        row=inflater.inflate(R.layout.car_row,null);

        ImageView carIV = (ImageView)row.findViewById(R.id.carThumbIV);
        TextView nameTV =(TextView)row.findViewById(R.id.carNameTV);

        carIV.setImageResource(datos.get(position).getIcon());
        nameTV.setText(datos.get(position).getModelo()+" "+ datos.get(position).getFabricante());
        return row;
    }
}
