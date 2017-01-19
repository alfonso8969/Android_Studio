package es.cice.vehiculoslistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DecripcionCars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decripcion_cars);
        Intent intent = getIntent();
        String des=intent.getStringExtra("des");
        int image = intent.getIntExtra("image",0);
        TextView tvDes = (TextView)findViewById(R.id.desTv);
        ImageView ivCar =(ImageView)findViewById(R.id.carImage);
        ivCar.setImageResource(image);
        tvDes.setText(des);

    }
}
