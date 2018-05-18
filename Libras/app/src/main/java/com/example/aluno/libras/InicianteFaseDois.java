package com.example.aluno.libras;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class InicianteFaseDois extends AppCompatActivity implements View.OnClickListener{

    /*No evento OnCreate() faremos atribuições às variáveis
    e invocaremos o método Listar() seguido de um Try..Catch.*/
    private ImageView imageView;
    private Button btnLer;
    private Button btnVoltar;
    private RadioButton resp1, resp2, resp3, resp4;
    private int fase;                   //Fase que o usuário está
    private int pontuacao;            //Potuação do usuário
    private int idQuestion;           //Talvez não precise dessa variável
    private int answer;             //Resposta escolhida pelo usuário
    private int [] correctAnswer;   //Vetor de repostas corretas
    private int currentCorrectAnswer;//Reposta correta atual
    private int [] idImage;    //Vetor de endereço das imagens
    private int currentImage;
    private ArrayList<String []> questions; //Banco de questões(opções)
    String [] respostas;
    private double percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciante_fase_dois);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = getIntent();

        this.pontuacao = 0;
        this.idQuestion = 0;                 //Primeira questão
        this.answer = 1;                    //contador para resposta

        imageView = (ImageView) findViewById(R.id.imageView2);
        btnLer = (Button) findViewById(R.id.button_seend_resp);
        btnLer.setOnClickListener(this);
        btnVoltar = (Button) findViewById(R.id.button_back_iniciante);
        btnVoltar.setOnClickListener(this);

        //Esse trecho receberá informações vindas da FaseIniciante
        Bundle bundle = getIntent().getExtras();


        getQuestions();                 //Carregando questões(opções/respostas)
        resp1 = (RadioButton) findViewById(R.id.resposta1);
        resp2 = (RadioButton) findViewById(R.id.resposta2);
        resp3 = (RadioButton) findViewById(R.id.resposta3);
        resp4 = (RadioButton) findViewById(R.id.resposta4);
        resp1.setOnClickListener(this);
        resp2.setOnClickListener(this);
        resp3.setOnClickListener(this);
        resp4.setOnClickListener(this);
        resp1.setChecked(true);

        respostas = questions.get(idQuestion);           //Atribuindo primeiro conjunto de resposta
        currentCorrectAnswer = correctAnswer[idQuestion];//Atribuindo resposta correta da questão atual
        currentImage = idImage[idQuestion];              //Atribuindo primeira imagem para o BACKGROUND

        imageView.setBackgroundResource(currentImage);
        resp1.setText(respostas[0]);
        resp2.setText(respostas[1]);
        resp3.setText(respostas[2]);
        resp4.setText(respostas[3]);

    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.button_seend_resp){

                if(answer == currentCorrectAnswer){
                    //Emite alert de feedback das respostas
                    Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT).show();
                    pontuacao++;
                    //Esperar alguns segundos antes de ir para próxima página
                    try{
                        Thread.sleep(Toast.LENGTH_SHORT);
                    }
                    catch(Exception e){
                        //Aconteceu algum erro
                    }

                    idQuestion++;
                    if(idQuestion > 8){
                        idQuestion = 8;
                        //Emite um alert mostrando que terminou o questionário
                        this.percent = (pontuacao*100)/9;
                        if (percent <= 35.0){
                            saudacao("Você ficou abaixo da margem aceitável.\nRefaça o teste.\nSua margem de acerto: " + percent + "%");
                        }
                        else if (percent >= 35.1 && percent <= 69.9){
                            saudacao("Você atingiu a meta necessária, mas ainda pode melhorar.\nSua margem de acerto: " + percent + "%");
                        }
                        else if (percent >= 70.0){
                            saudacao("Parabéns! Você está apto para avançar para o nível Intermediário.\nSua margem de acerto: " + percent + "%");
                        }
                    }
                    //Atualizando questões, respostas e imagem
                    this.answer = 1;
                    respostas = questions.get(idQuestion);           //Atribuindo primeiro conjunto de resposta
                    currentCorrectAnswer = correctAnswer[idQuestion];//Atribuindo resposta correta da questão atual
                    currentImage = idImage[idQuestion];              //Atribuindo primeira imagem para o BACKGROUND

                    imageView.setBackgroundResource(currentImage);   //Atribuindo imagem para a questão atual
                    resp1.setText(respostas[0]);
                    resp2.setText(respostas[1]);
                    resp3.setText(respostas[2]);
                    resp4.setText(respostas[3]);
                }
                else{
                    //Emite alert de feedback das respostas
                    Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT).show();
                    try{
                        Thread.sleep(Toast.LENGTH_SHORT);
                    }
                    catch(Exception e){
                        //Aconteceu algum erro
                    }

                    idQuestion++;
                    if(idQuestion > 8){
                        idQuestion = 8;
                        //Emite um alert mostrando que terminou o questionário
                        this.percent = (pontuacao*100)/9;
                        if (percent < 35.0){
                            saudacao("Você ficou abaixo da margem aceitável.\nRefaça o teste.\nSua margem de acerto: " + percent + "%");
                        }
                        else if (percent >= 35.1 && percent <= 69.9){
                            saudacao("Você atingiu uma nota Mediana, mas ainda pode melhorar.\nVolte e refaça o teste.\nSua margem de acerto: " + percent + "%");
                        }
                        else if (percent >= 70.0){
                            saudacao("Parabéns! Você está apto para avançar para o nível Intermediário.\nSua margem de acerto: " + percent + "%");
                        }
                    }
                    //Atualizando questões, respostas e imagem
                    this.answer = 1;
                    respostas = questions.get(idQuestion);           //Atribuindo primeiro conjunto de resposta
                    currentCorrectAnswer = correctAnswer[idQuestion];//Atribuindo resposta correta da questão atual
                    currentImage = idImage[idQuestion];              //Atribuindo primeira imagem para o BACKGROUND

                    imageView.setBackgroundResource(currentImage);   //Atribuindo imagem para a questão atual
                    resp1.setText(respostas[0]);
                    resp2.setText(respostas[1]);
                    resp3.setText(respostas[2]);
                    resp4.setText(respostas[3]);
                }
        }

        else if(view.getId() == R.id.resposta1){
            this.answer = 1;
        }

        else if(view.getId() == R.id.resposta2){
            this.answer = 2;
        }

        else if(view.getId() == R.id.resposta3){
            this.answer = 3;
        }

        else if(view.getId() == R.id.resposta4){
            this.answer = 4;
        }

        //TODO Ação do botão voltar
        if (view.getId() == R.id.button_back_iniciante){
            aviso("Você perderá a pontuação nesta fase.\nDeseja continuar?");
        }

    }

    public void getQuestions(){
        //Com o número da fase, escolher o banco de questões e imagens
        //Se fase == 1 faz o que tá abaixo,
        //senão se fase == 2 (CRIE OUTRAS QUESTÔES )
        this.questions = new ArrayList<String []>();
        String [] q1 = {"IVO", "EVA", "IGOR", "AVE"};
        questions.add(q1);
        String [] q2 = {"ELZA", "JOAO", "ELCIO", "MARIA"};
        questions.add(q2);
        String [] q3 = {"RICK", "FABIO", "MARIA", "PELE"};
        questions.add(q3);
        String [] q4 = {"IGOR", "IVO", "EVA", "ROSA"};
        questions.add(q4);
        String [] q5 = {"BETO", "FABIO", "JOAO", "JOSE"};
        questions.add(q5);
        String [] q6 = {"JOSE", "MARA", "JOEL", "LUAN"};
        questions.add(q6);
        String [] q7 = {"MAIA", "RITA", "MAICON", "MARA"};
        questions.add(q7);
        String [] q8 = {"PEDRO", "JUCA", "PELE", "PABLO"};
        questions.add(q8);
        String [] q9 = {"RENAN", "ROSE", "RITA", "ROSA"};
        questions.add(q9);


        this.correctAnswer = new int[9];    //resposta correta terá um vetor com 5 respostas já setada
        correctAnswer[0] = 2;
        correctAnswer[1] = 1;
        correctAnswer[2] = 2;
        correctAnswer[3] = 1;
        correctAnswer[4] = 3;
        correctAnswer[5] = 1;
        correctAnswer[6] = 4;
        correctAnswer[7] = 3;
        correctAnswer[8] = 4;

        this.idImage =new int [9];          //idImage terá um vetor com 5 valores para o drawable setada
        idImage[0] = R.drawable.eva;
        idImage[1] = R.drawable.elza;
        idImage[2] = R.drawable.fabio;
        idImage[3] = R.drawable.igor;
        idImage[4] = R.drawable.joao;
        idImage[5] = R.drawable.jose;
        idImage[6] = R.drawable.mara;
        idImage[7] = R.drawable.pele;
        idImage[8] = R.drawable.rosa;

    }

    private void saudacao(String s) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("SAUDAÇÕES");
        //define a mensagem
        builder.setMessage(s);
        //Configura Icon para AlertDialog
        builder.setIcon(R.drawable.icon);
        //define um boto como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Chamar a nova Activity Etapas
                Intent fases = new Intent(InicianteFaseDois.this, Etapas.class);
                startActivity(fases);
                finish();
                //Toast.makeText(MainActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

    private void aviso(String s) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("AVISO!");
        //define a mensagem
        builder.setMessage(s);
        // cofigura Icon para o AlertDialog
        builder.setIcon(R.drawable.atention);
        //define um boto como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                InicianteFaseDois.this.pontuacao=0;
                Toast.makeText(InicianteFaseDois.this, "AGUARDE!", Toast.LENGTH_SHORT).show();
                //Chamar a nova Activity Etapas
                Intent fases = new Intent(InicianteFaseDois.this, FaseInciante.class);
                startActivity(fases);
                finish();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //   Toast.makeText(MainActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

    //método para não fechar a activity caso o usuário
    //pressione o botão voltar.
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        startActivity(intent);

        return;
    }

}