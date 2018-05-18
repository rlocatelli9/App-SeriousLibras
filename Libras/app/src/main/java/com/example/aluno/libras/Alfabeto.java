package com.example.aluno.libras;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Criado por robson em 19/06/2016.
 */
public class Alfabeto extends Activity implements View.OnClickListener {

    ImageView pro;

    //TextView nome;

    String cod;
    ImageView proximo;
    ImageView anterior;
    int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfabeto);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.proximo = (ImageView) findViewById(R.id.imageView3);
        this.proximo.setOnClickListener(this);

        this.anterior = (ImageView) findViewById(R.id.imageView2);
        this.anterior.setOnClickListener(this);

        //nome = (TextView) findViewById(R.id.textView1);
        pro = (ImageView) findViewById(R.id.imageView1);

        cont = 1;

        if (cont == 1) {
            pro.setImageResource(R.drawable.a);     //já seta a primeira imagem
            //nome.setText(getIntent().getStringExtra("nome"));
        }

    }

    @Override
    public void onClick(View view) {                //define o click nas imagens proximo e anterior
        if (view.getId() == R.id.imageView3) {      //verifica se a direção "proxima" foi clicada

            cont++;

            if (cont < 2) {
                cont = 2;
            }

            if (cont == 2) {
                pro.setImageResource(R.drawable.b);     //Seta a imagem correspondente
                //nome.setText("LETRA B");              //Seta o nome que corresponde a imagem
            }

            if (cont == 3) {
                pro.setImageResource(R.drawable.c);
            }

            if (cont == 4) {
                pro.setImageResource(R.drawable.cedilha);
            }

            if (cont == 5) {
                pro.setImageResource(R.drawable.d);
            }

            if (cont == 6) {
                pro.setImageResource(R.drawable.e);
            }

            if (cont == 7) {
                pro.setImageResource(R.drawable.f);
            }

            if (cont == 8) {
                pro.setImageResource(R.drawable.g);
            }

            if (cont == 9) {
                pro.setImageResource(R.drawable.h);
            }

            if (cont == 10) {
                pro.setImageResource(R.drawable.i);
                //nome.setText("LETRA I");
            }

            if (cont == 11) {
                pro.setImageResource(R.drawable.j);
            }

            if (cont == 12) {
                pro.setImageResource(R.drawable.k);
            }

            if (cont == 13) {
                pro.setImageResource(R.drawable.l);
            }

            if (cont == 14) {
                pro.setImageResource(R.drawable.m);
            }

            if (cont == 15) {
                pro.setImageResource(R.drawable.n);
            }

            if (cont == 16) {
                pro.setImageResource(R.drawable.o);
            }

            if (cont == 17) {
                pro.setImageResource(R.drawable.p);
            }

            if (cont == 18) {
                pro.setImageResource(R.drawable.q);
            }

            if (cont == 19) {
                pro.setImageResource(R.drawable.r);
            }

            if (cont == 20) {
                pro.setImageResource(R.drawable.s);
            }

            if (cont == 21) {
                pro.setImageResource(R.drawable.t);
            }

            if (cont == 22) {
                pro.setImageResource(R.drawable.u);
            }

            if (cont == 23) {
                pro.setImageResource(R.drawable.v);
            }

            if (cont == 24) {
                pro.setImageResource(R.drawable.w);
            }

            if (cont == 25) {
                pro.setImageResource(R.drawable.x);
            }

            if (cont == 26) {
                pro.setImageResource(R.drawable.y);
            }

            if (cont == 27) {
                pro.setImageResource(R.drawable.z);
            }

            if (cont > 27) {
                cont = 27;
            }
        }

        if (view.getId() == R.id.imageView2) {                   //verifica se a direção "anterior" foi clicada

            cont--;

            if (cont < 1) {
                cont = 1;
            }

            if (cont == 1) {
                pro.setImageResource(R.drawable.a);                 //Seta a imagem correspondente

            }

            if (cont == 2) {
                pro.setImageResource(R.drawable.b);
            }

            if (cont == 3) {
                pro.setImageResource(R.drawable.c);
            }

            if (cont == 4) {
                pro.setImageResource(R.drawable.cedilha);
            }

            if (cont == 5) {
                pro.setImageResource(R.drawable.d);
            }

            if (cont == 6) {
                pro.setImageResource(R.drawable.e);
            }

            if (cont == 7) {
                pro.setImageResource(R.drawable.f);
            }

            if (cont == 8) {
                pro.setImageResource(R.drawable.g);
            }

            if (cont == 9) {
                pro.setImageResource(R.drawable.h);
            }

            if (cont == 10) {
                pro.setImageResource(R.drawable.i);
            }

            if (cont == 11) {
                pro.setImageResource(R.drawable.j);
            }

            if (cont == 12) {
                pro.setImageResource(R.drawable.k);
            }

            if (cont == 13) {
                pro.setImageResource(R.drawable.l);
            }

            if (cont == 14) {
                pro.setImageResource(R.drawable.m);
            }

            if (cont == 15) {
                pro.setImageResource(R.drawable.n);
            }

            if (cont == 16) {
                pro.setImageResource(R.drawable.o);
            }

            if (cont == 17) {
                pro.setImageResource(R.drawable.p);
            }

            if (cont == 18) {
                pro.setImageResource(R.drawable.q);
            }

            if (cont == 19) {
                pro.setImageResource(R.drawable.r);
            }

            if (cont == 20) {
                pro.setImageResource(R.drawable.s);
            }

            if (cont == 21) {
                pro.setImageResource(R.drawable.t);
            }

            if (cont == 22) {
                pro.setImageResource(R.drawable.u);
            }

            if (cont == 23) {
                pro.setImageResource(R.drawable.v);
            }

            if (cont == 24) {
                pro.setImageResource(R.drawable.w);
            }

            if (cont == 25) {
                pro.setImageResource(R.drawable.x);
            }

            if (cont == 26) {
                pro.setImageResource(R.drawable.y);
            }

            if (cont == 27) {
                pro.setImageResource(R.drawable.z);
            }

            if (cont > 27) {
                cont = 27;
            }
        }
    }

    //Direcionar para as questões iniciantes
    public void resp_questões(View view){
        Intent ini = new Intent(this, FaseInciante.class);
        startActivity(ini);
        finish();
    }

    //método para não fechar a activity caso o usuário
    //pressione o botão voltar.
    public void onBackPressed() {
        Intent alfa = new Intent(Alfabeto.this, Etapas.class);
        startActivity(alfa);
        finish();

        return;
    }

}
