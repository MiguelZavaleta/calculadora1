package com.example.calculadora1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora1.Recursos.Operaciones;

public class Activity_imc extends AppCompatActivity {
    Button IMC;
    EditText camp1,camp2;
    TextView Resultado;
    double n1,n2;
    Intent miIntent=null;
    LinearLayout contenedor;
    Operaciones ctrl=new Operaciones();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imc);
        camp1=(EditText)findViewById(R.id.campo1);
        camp2=(EditText)findViewById(R.id.campo2);
        IMC=(Button)findViewById(R.id.ButIMC);
        Resultado=(TextView) findViewById(R.id.txtResultado);
        contenedor=(LinearLayout)findViewById(R.id.panelp);
        camp1.setHint("Dame tu Altura ejemplo: 1.70 cm");
        camp2.setHint("Dame tu Peso en kilogramos");
        IMC.setText("Calcular :D");
    }
    public void Activar(View view){

        if(!ctrl.validar(camp1.getText().toString(),camp2.getText().toString()))
            Toast.makeText(this, "Campos vacios verifica ", Toast.LENGTH_LONG).show();
            else
        switch (view.getId()){
            case R.id.ButIMC:
                n1 = Double.parseDouble((camp1.getText().toString()));
                n2 = Double.parseDouble((camp2.getText().toString()));
                Toast.makeText(this, "imc :D " +camp1.length(), Toast.LENGTH_LONG).show();
                    Resultado.setText(GradoPeso(ctrl.imc((((n1 / 100) == n1) ? n1:(n1 / 100) ), n2),(((n1 / 100) == n1) ? n1:(n1 / 100)), n2));
                break;

        }
    }
    public void funciones(View view){
        switch (view.getId()){
            case R.id.butRegresar:
                miIntent= new Intent(this,MainActivity.class);
                startActivity(miIntent);
                break;
            case R.id.Vaciar:
                camp1.setText("");
                camp2.setText("");
                n1=0;
                n2=0;
                contenedor.setBackgroundColor(getResources().getColor(R.color.md_blue_700));
                break;
        }
    }
    public String GradoPeso(double imc,double a, double b){
        String cadena="";
        if(imc<16){
            cadena="Altura: "+a+" Peso: "+b
                    +"\nTu Indice de Masa Corporal es = " +imc
                    +("\nInfrapeso: Delgadez Severa".toUpperCase());
            contenedor.setBackgroundColor(getResources().getColor(R.color.md_amber_700));
        }else if(imc>=16 & imc<17){
            cadena="Altura: "+a+" Peso: "+b
                    +"\nTu Indice de Masa Corporal es = " +imc
                    +("\nInfrapeso: Delgadez Moderada".toUpperCase());
            contenedor.setBackgroundColor(getResources().getColor(R.color.md_amber_700));

        }else if(imc>=17 & imc<18.50){
            cadena="Altura: "+a+" Peso: "+b
                    +"\nTu Indice de Masa Corporal es = " +imc
                    +("\nInfrapeso: Delgadez Aceptable".toUpperCase());
            contenedor.setBackgroundColor(getResources().getColor(R.color.md_amber_700));

        }else if(imc>=18.50 & imc<25){
            cadena="Altura: "+a+" Peso: "+b
                    +"\nTu Indice de Masa Corporal es = " +imc
                    +("\nInfrapeso: Peso Normal :D".toUpperCase());
            contenedor.setBackgroundColor(getResources().getColor(R.color.md_light_green_500_75));

        }else if(imc>=25 & imc<30){
            cadena="Altura: "+a+" Peso: "+b
                    +"\nTu Indice de Masa Corporal es = " +imc
                    +("\nSobrepeso :v".toUpperCase());
            contenedor.setBackgroundColor(getResources().getColor(R.color.md_yellow_A700));
        }else if(imc>=30 & imc<35){
            cadena="Altura: "+a+" Peso: "+b
                    +"\nTu Indice de Masa Corporal es = " +imc
                    +("\nObesidad: Tipo I Dx".toUpperCase());
            contenedor.setBackgroundColor(getResources().getColor(R.color.md_red_700));
        }else if(imc>=35 & imc<=40){
            cadena="Altura: "+a+" Peso: "+b
                    +"\nTu Indice de Masa Corporal es = " +imc
                    +("\nObesidad: Tipo II Dx".toUpperCase());
            contenedor.setBackgroundColor(getResources().getColor(R.color.md_red_800));
        }else if(imc>40){
            cadena="Altura: "+a+" Peso: "+b
                    +"\nTu Indice de Masa Corporal es = " +imc
                    +("\nObesidad: Tipo III Dx".toUpperCase());
            contenedor.setBackgroundColor(getResources().getColor(R.color.md_red_900));
        }
        return cadena;
    }

}
