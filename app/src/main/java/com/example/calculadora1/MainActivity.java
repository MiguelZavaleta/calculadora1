package com.example.calculadora1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadora1.Recursos.Operaciones;

public class MainActivity extends AppCompatActivity {
Button IMC;
EditText camp1,camp2;
TextView Resultado;

    double n1,n2;
    LinearLayout contenedor;
    Operaciones ctrl=new Operaciones();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camp1=(EditText)findViewById(R.id.campo1);
        camp2=(EditText)findViewById(R.id.campo2);
        IMC=(Button)findViewById(R.id.ButIMC);
        Resultado=(TextView) findViewById(R.id.txtResultado);
        contenedor=(LinearLayout)findViewById(R.id.panelp);
n1=0;
n2=0;

        }
        public void Inicializar(){
            n1 = Double.parseDouble((camp1.getText().toString()));
            n2 = Double.parseDouble((camp2.getText().toString()));
        }

    public void onclick(View view){
        if(!ctrl.validar(camp1.getText().toString(),camp2.getText().toString())) {
            Toast.makeText(this, "Campos vacios verifica ", Toast.LENGTH_LONG).show();
        }else{
        try {
            Inicializar();
                switch (view.getId()) {
                    case R.id.btnSuma:
                        Resultado.setText(ctrl.Imp("La Suma de " + n1 + " + " + n2 + " Es :", ctrl.suma(n1, n2)));
                        break;
                    case R.id.btnResta:
                        Resultado.setText(ctrl.Imp("La Resta de " + n1 + " - " + n2 + " Es :", ctrl.Resta(n1, n2)));
                        break;
                    case R.id.btnMultiplicacion:
                        Resultado.setText(ctrl.Imp("La Multiplicacion de " + n1 + " x " + n2 + " Es :", ctrl.Multiplicacion(n1, n2)));
                        break;
                    case R.id.btnDivision:
                        Resultado.setText((n2 < 0) ? "Tu segundo Numero debe ser mayor a 0 \npara la Division" : ctrl.Imp("La Division de " + n1 + " / " + n2 + " Es :", ctrl.Division(n1, n2)));
                        break;


                    default:
                }
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    }
public void LIMPIA(View view){
        try {
            Intent IntentIMC =null;
            switch (view.getId()){
                case R.id.limp:
                    Limpiar("","","Dame tu primer Numero","Dame tu Segundo Numero");
                    Toast.makeText(this,"Campos Limpiados",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ButIMC:
                    IntentIMC = new Intent(this, Activity_imc.class);
                    startActivity(IntentIMC);
                    break;
                default:
            }
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }

}
    public void Limpiar(String caja,String caja2,String hint,String hint2){
        camp2.setText(caja);
        camp1.setText(caja2);
       camp1.setHint(hint);
       camp2.setHint(hint2);
       Resultado.setText("Resultado");
    }
   }
