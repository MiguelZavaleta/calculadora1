package com.example.calculadora1;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
Button IMC;
EditText camp1,camp2;
TextView Resultado;

    double n1,n2;
    LinearLayout contenedor;
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
public boolean validar(){
        boolean bandera=true;
    if(camp1.getText().toString().isEmpty() && camp2.getText().toString().isEmpty()) {

bandera=false;
    }else  if(camp1.getText().toString().isEmpty() || camp2.getText().toString().isEmpty()) {

        bandera=false;
    }else{
        bandera=true;
    }
    return bandera;

}
    public void onclick(View view){

        try {
boolean bandera=false;
         /*  if(!validar()) {
               Toast.makeText(this, "Campos vacios verifica ", Toast.LENGTH_LONG).show();
           }else{*/
                n1 = Double.parseDouble((camp1.getText().toString()));
                n2 = Double.parseDouble((camp2.getText().toString()));
                switch (view.getId()) {
                    case R.id.btnSuma:
                        Resultado.setText(Imp("La Suma de " + n1 + " + " + n2 + " Es :", suma(n1, n2)));
                        contenedor.setBackgroundColor(getResources().getColor(R.color.md_red_700));
                        break;
                    case R.id.btnResta:
                        Resultado.setText(Imp("La Resta de " + n1 + " - " + n2 + " Es :", Resta(n1, n2)));
                        break;
                    case R.id.btnMultiplicacion:
                        Resultado.setText(Imp("La Multiplicacion de " + n1 + " x " + n2 + " Es :", Multiplicacion(n1, n2)));
                        break;
                    case R.id.btnDivision:
                        Resultado.setText((n2 < 0) ? "Tu segundo Numero debe ser mayor a 0 \npara la Division" : Imp("La Division de " + n1 + " / " + n2 + " Es :", Division(n1, n2)));
                        break;
                    case R.id.ButIMC:

                        bandera=true;
                        int i=0;


                        break;
                    case R.id.limp:
                        Limpiar();
                        break;
                    default:
                }
            //}
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public void Activar(View view){
        int c=0;
        switch (view.getId()){
            case R.id.ButIMC:


                Toast.makeText(this, "imc :D " +camp1.length(), Toast.LENGTH_LONG).show();

                camp1.setHint("Dame tu Altura ejemplo: 1.70 cm");
                camp1.setHint("Dame tu Peso en kilogramos");
                IMC.setText("Calcular :D");

                    if(camp2.getText().toString().length()>0 & camp1.getText().toString().length()>0) {
                        Resultado.setText(GradoPeso(imc((((n1 / 100) == n1) ? (n1 / 100) : n1), n2), n1, n2));

                    }

                break;

        }

    }
    public void Limpiar(){
        camp2.setText("");
        camp1.setText("");
       camp1.setHint("Dame tu primer numero");
       camp2.setHint("Dame tu segundo Numero");
       n1=0;
       n2=0;

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
    public double imc(double altura,double peso){
        return (peso/(Math.pow(altura,2)));
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
