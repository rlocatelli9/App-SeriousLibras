package com.example.aluno.libras;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Etapas extends AppCompatActivity implements View.OnClickListener{
    public boolean retorno;
    //private int fases;
    private AlertDialog alerta;
    private ImageButton nivel_iniciante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retorno = false;
        setContentView(R.layout.activity_etapas);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //pegar os dados enviados
        Intent intent = getIntent();

        //informo que a imagem terá um evento de click
        nivel_iniciante = (ImageButton) findViewById(R.id.imageButton_iniciante);
        nivel_iniciante.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageButton_iniciante) {

            this.alert();                        //chama o método para emitir  um AlertDialog

        }

    }

    private void alert() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);//Cria o gerador do AlertDialog
        builder.setTitle("AVISO");//define o titulo
        builder.setMessage("Deseja aprender o alfabeto LIBRAS antes de responder as questões?");//define a mensagem
        // cofigura Icon para o AlertDialog
        builder.setIcon(R.drawable.icon);
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(Etapas.this, "Aguarde!", Toast.LENGTH_SHORT).show();
                try{
                    //Leva o usuário para a Activity Alfabeto
                    Intent alfa = new Intent(Etapas.this, Alfabeto.class);
                    startActivity(alfa);
                    finish();
                }catch (Exception e){

                }
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                try{
                    //Leva o usuário para responder as questões na Activity Iniciante
                    Intent inici = new Intent(Etapas.this, FaseInciante.class);
                    startActivity(inici);
                    Toast.makeText(Etapas.this, "Você optou por não aprender o alfabeto LIBRAS.", Toast.LENGTH_SHORT).show();
                    finish();
                }catch (Exception e){

                }
            }
        });
        alerta = builder.create();//cria o AlertDialog
        alerta.show();//Exibe
    }

    private void aviso(String s) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("SAUDAÇÕES");
        //define a mensagem
        builder.setMessage(s);
        // cofigura Icon para o AlertDialog
        builder.setIcon(R.drawable.icon);
        //define um boto como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //   Toast.makeText(MainActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

    /*Aqui começo o código do Alert Dialog das etapas em construção
    só para saber que ainda está em construção e que em breve estará funcionando*/
    public void alertconstrucao(View View) {
        AlertDialog AlertDialog;
        //cria o AlertDialog
        AlertDialog = new AlertDialog.Builder(this).create();
        //seto o título do Alert
        AlertDialog.setTitle("Em construção!");
        //seta a mensagem de informação
        AlertDialog.setMessage("Em breve a função será adicionada.\nObrigado pela paciência.");
        // cofigura Icon para o AlertDialog
        AlertDialog.setIcon(R.drawable.construction);
        AlertDialog.show();
    }
}
