package es.cice.calculadoralinearlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public final static int INTRODUCIENDO_VALORES=0;
    public final static int INTRODUCIENDO_OPERADORES=1;
    private TextView tvPantalla;
    private Double res=null;
    private Double operando;
    private String operador;
    private int estado;
    private boolean opCont=false;
    Button btnLimpiar;
    Button btnMasMenos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPantalla = (TextView)findViewById(R.id.tvPantalla);
        configurarBotonesNumericos();
        configurarBotonesOperaciones();
        estado=MainActivity.INTRODUCIENDO_VALORES;
        btnLimpiar = (Button)findViewById(R.id.btnAC);
        btnLimpiar.setOnClickListener(v->{
            operador=null;
            operando=0.0;
            tvPantalla.setText("0");
            res=0.0;
        });
        btnMasMenos = (Button)findViewById(R.id.btnMasMenos);
        btnMasMenos.setOnClickListener(v->{
            if(tvPantalla.getText().toString().startsWith("-"))
                tvPantalla.setText(tvPantalla.getText().toString().replace("-",""));
            else
                tvPantalla.setText(String.format("-%s",tvPantalla.getText().toString()));
        });
    }

    private void configurarBotonesOperaciones() {
        Button[] opeButtons =
                {(Button) findViewById(R.id.btnMasMenos), (Button) findViewById(R.id.btnDivision),
                (Button) findViewById(R.id.btnRestar), (Button) findViewById(R.id.btnMultiplicar),
                (Button) findViewById(R.id.btnSumar), (Button) findViewById(R.id.btnigual),
                        (Button)findViewById(R.id.btnPorcentaje)};
        for (Button button : opeButtons) {
            button.setOnClickListener(v -> {
                switch (v.getId()) {
                    case R.id.btnigual:
                        if (operador != null) {
                            switch (operador) {
                                case "+":
                                    res = operando + getOperandoDos();
                                    break;
                                case "-":
                                    res = operando - getOperandoDos();
                                    break;
                                case "*":
                                    res = operando * getOperandoDos();
                                    break;
                                case "/":
                                    res = operando / getOperandoDos();
                                    break;
                                case "%":
                                    res = (operando * getOperandoDos())/100;
                                break;
                            }
                        }
                        break;
                    case R.id.btnSumar:
                        operador = "+";
                        if (operando != null) {
                            res = operando + getOperandoDos();
                        }

                        break;
                    case R.id.btnRestar:
                        operador = "-";

                        break;
                    case R.id.btnMultiplicar:
                        operador = "*";

                        break;
                    case R.id.btnDivision:
                        operador = "/";

                        break;
                    case R.id.btnPorcentaje:
                        operador = "%";
                        break;
                }
                estado = MainActivity.INTRODUCIENDO_OPERADORES;
                operando = Double.parseDouble(tvPantalla.getText().toString());

                if (res != null && res != 0) {
                    if (String.valueOf(res).endsWith(".0") || String.valueOf(res).endsWith(".0+"))
                        tvPantalla.setText(String.valueOf(res.intValue()));
                    else
                        tvPantalla.setText(String.valueOf(res));
                }
            });
        }
    }

    private void configurarBotonesNumericos() {
        Button[] numericButtons={(Button)findViewById(R.id.btn0),(Button)findViewById(R.id.btn1),(Button)findViewById(R.id.btn2),(Button)findViewById(R.id.btn3),
                (Button)findViewById(R.id.btn4),(Button)findViewById(R.id.btn5),(Button)findViewById(R.id.btn6),(Button)findViewById(R.id.btn7),(Button)findViewById(R.id.btn8),
                (Button)findViewById(R.id.btn9),(Button)findViewById(R.id.btncoma)};
        for(Button btn:numericButtons){
            btn.setOnClickListener(v -> {
                if(estado==MainActivity.INTRODUCIENDO_VALORES){
                    String value = tvPantalla.getText().toString() + ((Button) v).getText().toString();
                    tvPantalla.setText(value.replaceAll("^0+", ""));
                }
                else if(estado==MainActivity.INTRODUCIENDO_OPERADORES){
                    estado=MainActivity.INTRODUCIENDO_VALORES;
                    tvPantalla.setText(((Button) v).getText().toString());
                }
            });
        }
    }
    public Double getOperandoDos(){
        Double operando2;
        if(!tvPantalla.getText().toString().isEmpty()) {
            operando2 = Double.parseDouble(tvPantalla.getText().toString());
        }else
            operando2=null;
        return operando2;
    }
}
