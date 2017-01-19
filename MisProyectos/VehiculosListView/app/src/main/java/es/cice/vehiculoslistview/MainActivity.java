package es.cice.vehiculoslistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.cice.vehiculoslistview.adapters.CarsAdapters;
import es.cice.vehiculoslistview.model.Vehiculo;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity";
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.carListView);
        List<Vehiculo> data = getData();
        CarsAdapters carsAdapters = new CarsAdapters(this,R.layout.car_row,data);
        lv.setAdapter(carsAdapters);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"Click en item: "+position+"..");
               /* String iD = String.valueOf(lv.getItemIdAtPosition(position));
                int Id = Integer.valueOf(iD);
                List<Vehiculo> list = getData();*/
                String modelo = getData().get(position).getModelo();
                String des= getData().get(position).getDescripcion();
                int image = getData().get(position).getImage();
                Intent intent = new Intent(getApplication(), DecripcionCars.class);
                intent.putExtra("des",des);
                intent.putExtra("image",image);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Click en modelo: "+modelo+"..",Toast.LENGTH_LONG).show();


            }
        });

    }

    private List<Vehiculo> getData() {
        //String descripción, String fabricante, int icon, int image, String modelo
        List<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(new Vehiculo("Familiar","Audi",R.drawable.vehiculo1thum,R.drawable.vehiculo1,"A6"));
        vehiculoList.add(new Vehiculo("Sport","Opel",R.drawable.vehiculo2thum,R.drawable.vehiculo2,"Corsa"));
        vehiculoList.add(new Vehiculo("Furgoneta","Renault",R.drawable.vehiculo3thum,R.drawable.vehiculo3,"Kangoo"));
        vehiculoList.add(new Vehiculo("Turismo","Renault",R.drawable.vehiculo4thum,R.drawable.vehiculo4,"Twingo"));
        vehiculoList.add(new Vehiculo("Todoterreno","Chrisler",R.drawable.vehiculo5thum,R.drawable.vehiculo5,"Captiva"));

        return vehiculoList;
    }


}
