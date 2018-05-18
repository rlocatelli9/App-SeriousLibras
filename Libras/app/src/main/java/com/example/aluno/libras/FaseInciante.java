package com.example.aluno.libras;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class FaseInciante extends AppCompatActivity implements View.OnClickListener {

    //private int fases;
    private int etapa;
    private ImageButton imgFase;
    private ImageButton imgFase2;
    private ImageButton imgback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_inciante);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Bundle bundle = getIntent().getExtras();

        //as imagens receberão o evento de click;
        imgFase = (ImageButton) findViewById(R.id.imageButton_faseum);
        imgFase.setOnClickListener(this);
        imgFase2 = (ImageButton) findViewById(R.id.imageButton_fasedois);
        imgFase2.setOnClickListener(this);
        imgback = (ImageButton) findViewById(R.id.imageButton_back);
        imgback.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageButton_faseum) {
            //Da um tempo para o usuário ler a mensagem
            try {
                //Leva o usuário para a Activity Alfabeto
                Intent alfa = new Intent(FaseInciante.this, iniciante.class);
                startActivity(alfa);
                Toast.makeText(getApplicationContext(), "Aguarde!", Toast.LENGTH_SHORT).show();
                finish();

            } catch (Exception e) {
                //Aconteceu algum erro
            }
        }

        if (view.getId() == R.id.imageButton_fasedois) {
            //Da um tempo para o usuário ler a mensagem
            try {
                //Leva o usuário para a Activity Alfabeto
                Intent alfa = new Intent(FaseInciante.this, InicianteFaseDois.class);
                startActivity(alfa);
                Toast.makeText(getApplicationContext(), "Aguarde!", Toast.LENGTH_SHORT).show();
                finish();

            } catch (Exception e) {
                //Aconteceu algum erro
            }
        }

        if (view.getId() == R.id.imageButton_back){
            try {
                //Leva o usuário para a Activity Alfabeto
                Intent alfa = new Intent(FaseInciante.this, Etapas.class);
                startActivity(alfa);
                Toast.makeText(getApplicationContext(), "Aguarde!", Toast.LENGTH_SHORT).show();
                finish();

            } catch (Exception e) {
                //Aconteceu algum erro
            }
        }
    }

    //método para não fechar a activity caso o usuário
    //pressione o botão voltar do celular.
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        startActivity(intent);

        return;
    }
}
