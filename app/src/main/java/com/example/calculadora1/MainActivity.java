package com.example.calculadora1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button IMC;
EditText camp1,camp2;
TextView Resultado;
    double n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camp1=(EditText)findViewById(R.id.campo1);
        camp2=(EditText)findViewById(R.id.campo2);
        IMC=(Button)findViewById(R.id.IMC);
        Resultado=(TextView) findViewById(R.id.txtResultado);
n1=0;
n2=0;
        }

    public void onclick(View view){
        try {
            if(camp1.getText().toString().isEmpty() && camp2.getText().toString().isEmpty())
                Toast.makeText(this,"Campos vacios",Toast.LENGTH_LONG).show();
            else
            n1=Double.parseDouble((camp1.getText().toString()));
            n2=Double.parseDouble((camp2.getText().toString()));
        switch (view.getId()){
            case R.id.btnSuma:
                Resultado.setText(Imp("La Suma de "+n1+" + "+n2+" Es :", suma(n1,n2)));
                break;
            case R.id.btnResta:
                Resultado.setText(Imp("La Resta de "+n1+" - "+n2+" Es :",   Resta(n1,n2)));
                break;
            case R.id.btnMultiplicacion:
                Resultado.setText(Imp("La Multiplicacion de "+n1+" x "+n2+" Es :", Multiplicacion(n1,n2)));
                break;
            case R.id.btnDivision:
                Resultado.setText((n2<0)?"Tu segundo Numero debe ser mayor a 0 \npara la Division":Imp("La Division de "+n1+" / "+n2+" Es :",  Division(n1,n2)));
              break;
            case R.id.IMC:
                Toast.makeText(this,"imc :D",Toast.LENGTH_LONG).show();
                break;
        }
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    String Imp(String mensaje,double resultado){
        return mensaje+" "+resultado;

    }
    public double suma(double a, double b){
        return a+b;
    }
    public double Resta(double a, double b){
        return a-b;
    }
    public double Multiplicacion(double a, double b){
        return a*b;
    }
    public double Division(double a, double b){
        if(b<0 || a<0)
        return 0;
        else
            return a/b;
    }
}
