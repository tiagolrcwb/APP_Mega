package com.example.tiago.app_mega;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int acumulado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void mostraDezenas(View view){

        List<Integer> premios = new ArrayList<Integer>();

        List<Integer> sorteados = new ArrayList<Integer>();
        sorteados.add(10);
        sorteados.add(11);
        sorteados.add(15);
        sorteados.add(27);
        sorteados.add(35);
        sorteados.add(59);

        List<Integer> dezenas = new ArrayList<Integer>();
        int numero1 = numero();
        int numero2 = numero();
        if(numero2==numero1){
            numero2 = numero();
        }
        int numero3 = numero();
        if((numero3==numero1) || (numero3 == 1)){
            numero3 = numero();
        }
        int numero4 = numero();
        if(((numero4==numero3)||(numero4 == numero2)||(numero4==numero1))){
            numero4 = numero();
        }
        int numero5 = numero();
        if(((numero5==numero4)||(numero5 == numero3)||(numero5==numero2)||(numero5==numero1))){
            numero5 = numero();
        }
        int numero6 = numero();
        if(((numero6==numero5)||(numero6 == numero4)||(numero6==numero3)||(numero6==numero2)||numero6==numero1)){
            numero5 = numero();
        }
        dezenas.add(numero1);
        dezenas.add(numero2);
        dezenas.add(numero3);
        dezenas.add(numero4);
        dezenas.add(numero5);
        dezenas.add(numero6);

        if(sorteados.containsAll(dezenas)){

            Toast.makeText(this, "Parabéns Ganhou!!", Toast.LENGTH_SHORT).show();


        }else{
            this.acumulado = this.acumulado + 1000000;
            Toast.makeText(this, "Perdeu!! - Acumulado = R$" + acumulado + ",00", Toast.LENGTH_SHORT).show();
        }

        TextView adez1 = (TextView) findViewById(R.id.dez1);
        adez1.setText(String.valueOf(dezenas.get(0)));
        TextView adez2 = (TextView) findViewById(R.id.dez2);
        adez2.setText(String.valueOf(dezenas.get(1)));
        TextView adez3 = (TextView) findViewById(R.id.dez3);
        adez3.setText(String.valueOf(dezenas.get(2)));
        TextView adez4 = (TextView) findViewById(R.id.dez4);
        adez4.setText(String.valueOf(dezenas.get(3)));
        TextView adez5 = (TextView) findViewById(R.id.dez5);
        adez5.setText(String.valueOf(dezenas.get(4)));
        TextView adez6 = (TextView) findViewById(R.id.dez6);
        adez6.setText(String.valueOf(dezenas.get(5)));
    }
    public static int numero() {
        int min = 1;
        int max = 60;
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
