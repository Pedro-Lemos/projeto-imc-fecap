package br.com.fecapccp.calculadoraimc.calcularimc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.fecapccp.calculadoraimc.R;
import br.com.fecapccp.calculadoraimc.categoriasimc.AbaixoDoPesoActivity;
import br.com.fecapccp.calculadoraimc.categoriasimc.Obesidade1Activity;
import br.com.fecapccp.calculadoraimc.categoriasimc.Obesidade2Activity;
import br.com.fecapccp.calculadoraimc.categoriasimc.Obesidade3Activity;
import br.com.fecapccp.calculadoraimc.categoriasimc.PesoNormalActivity;
import br.com.fecapccp.calculadoraimc.categoriasimc.SobrepesoActivity;

public class CalculoImcActivity extends AppCompatActivity {

    private EditText campoAltura;
    private EditText campoPeso;

    private Button btnCalcularImc;
    private Button btnLimparImc;
    private Button btnFechar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imc);
        Log.i("Ciclo de vida", "Calculo Imc Activity - onCreate");


        btnCalcularImc = findViewById(R.id.btnCalcularImc);
        btnLimparImc = findViewById(R.id.btnLimparCalculoImc);
        btnFechar = findViewById(R.id.btnFecharCalculoImc);


        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);

        // Limpar os campos:
        btnLimparImc.setOnClickListener(view -> {
            view.startAnimation(scaleAnimation);
            limparCampos(view);
        });

        // Calcular imc:
        btnCalcularImc.setOnClickListener(view -> {
            view.startAnimation(scaleAnimation);
            calcularImc(view);
        });

        // Fechar e voltar pra tela inicial:
        btnFechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Metodo para calcular IMC e transferir informações para a próxima tela
    public void calcularImc(View view) {
        campoPeso = findViewById(R.id.editInputPeso);
        campoAltura = findViewById(R.id.editInputAltura);

        String pesoStr = campoPeso.getText().toString();
        String alturaStr = campoAltura.getText().toString();
        TextView mensagemErro = findViewById(R.id.mensagemErro);

        if (pesoStr.isEmpty() || alturaStr.isEmpty() || pesoStr.equals("0") || alturaStr.equals("0")) {
            mensagemErro.setText("O peso e altura não podem ser zero ou estarem vazios.");
            mensagemErro.setVisibility(View.VISIBLE);
            Log.e("Calculo IMC", "Campos de peso ou altura estão vazios ou com valor zero");
            return;
        } else {
            mensagemErro.setVisibility(View.GONE);
        }

        // Calculo do IMC para enviar para cada tela correspondente
        try {
            double peso = Double.parseDouble(pesoStr);
            double altura = Double.parseDouble(alturaStr);
            double calculoImc = peso / (altura * altura);
            String classificacao;

            Intent intent;
            if (calculoImc < 18.5) {
                Log.i("Calculo IMC", "Abaixo do peso");
                intent = new Intent(this, AbaixoDoPesoActivity.class);
                classificacao = "Abaixo do peso";
            } else if (calculoImc >= 18.5 && calculoImc < 25) {
                Log.i("Calculo IMC", "Peso normal");
                intent = new Intent(this, PesoNormalActivity.class);
                classificacao = "Peso normal";
            } else if (calculoImc >= 25 && calculoImc < 30) {
                Log.i("Calculo IMC", "Sobrepeso");
                intent = new Intent(this, SobrepesoActivity.class);
                classificacao = "Sobrepeso";
            } else if (calculoImc >= 30 && calculoImc < 35) {
                Log.i("Calculo IMC", "Obesidade Grau 1");
                intent = new Intent(this, Obesidade1Activity.class);
                classificacao = "Obesidade grau 1";
            } else if (calculoImc >= 35 && calculoImc < 40) {
                Log.i("Calculo IMC", "Obesidade Grau 2");
                intent = new Intent(this, Obesidade2Activity.class);
                classificacao = "Obesidade grau 2";
            } else {
                Log.i("Calculo IMC", "Obesidade Grau 3");
                intent = new Intent(this, Obesidade3Activity.class);
                classificacao = "Obesidade grau 3";
            }

            intent.putExtra("classificacao", classificacao);
            intent.putExtra("resultadoimc", calculoImc);
            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);

            startActivity(intent);
            finish();
        } catch (NumberFormatException e) {
            Log.e("Calculo IMC", "Erro ao converter peso ou altura para número", e);
        }
    }

    // Metodo para limpar os campos
    public void limparCampos(View view){
        campoPeso = findViewById(R.id.editInputPeso);
        campoAltura = findViewById(R.id.editInputAltura);

        campoPeso.setText("");
        campoAltura.setText("");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de vida", "Calculo Imc Activity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Calculo Imc Activity - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida", "Calculo Imc Activity - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "Calculo Imc Activity - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida", "Calculo Imc Activity - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de vida", "Calculo Imc Activity - onStart");
    }
}