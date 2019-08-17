package com.example.calculadora1.Recursos;

public class Operaciones {
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
   public String Imp(String mensaje,double resultado){
        return mensaje+" "+resultado;

    }
    public boolean validar(String c1,String c2){
        boolean bandera=true;
        if(c1.isEmpty() && c2.isEmpty()) {

            bandera=false;
        }else  if(c1.isEmpty() || c2.isEmpty()) {

            bandera=false;
        }else{
            bandera=true;
        }
        return bandera;

    }
}
