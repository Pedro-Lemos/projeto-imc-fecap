package br.com.fecapccp.calculadoraimc.categoriasimc;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

import br.com.fecapccp.calculadoraimc.R;

public class SobrepesoActivity extends AppCompatActivity {

    private TextView classificacaoImc;
    private TextView resultadoImcAltura;
    private TextView resultadoImcPeso;
    private TextView resultadoImc;
    private TextView mensagemApoioImc;
    private Button btnFecharImc;

    public static final class CompanionObject {
        public static final String MENSAGEM_APOIO = "\uD83D\uDD25 Seu corpo te sustenta todos os dias, valorize isso! Se quiser fazer mudanças, faça por você, sem pressa e sem pressão. Pequenos passos levam a grandes resultados. Mexa-se por prazer, alimente-se com consciência e lembre-se: você merece se sentir bem agora, não só quando atingir um objetivo. Você já é incrível! \uD83D\uDE4C";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobrepeso);
        Log.i("Ciclo de vida", "Sobrepeso activity - onResume");

        classificacaoImc = findViewById(R.id.classificacaoAbaixoPeso);
        resultadoImcAltura = findViewById(R.id.resultadoAltura);
        resultadoImcPeso = findViewById(R.id.resultadoPeso);
        resultadoImc = findViewById(R.id.resultadoImc);
        mensagemApoioImc = findViewById(R.id.mensagemApoioAbaixoPeso);
        btnFecharImc = findViewById(R.id.btnFecharAbaixoPeso);

        mostrarPopup();

        // Recebendo os dados
        Bundle bundle = getIntent().getExtras();

        // Garante que o bundle não é nulo
        assert bundle != null;

        double altura              = bundle.getDouble("altura");
        double peso                = bundle.getDouble("peso");
        double resultadoCalculoImc = bundle.getDouble("resultadoimc");
        String classificacao       = bundle.getString("classificacao");

        // Mostrar a classificação
        classificacaoImc.setText(classificacao);

        // Mostrar o resultado
        String resultadoAlturaCalculada = "Sua altura é: " + altura + "m";
        resultadoImcAltura.setText(resultadoAlturaCalculada);
        String resultadoPesoCalculada = "Seu peso é: " + peso + "kg";
        resultadoImcPeso.setText(resultadoPesoCalculada);

        String imcDoubleFormatado = String.format("%.2f", resultadoCalculoImc);
        String resultadoImcCalculado = "Seu IMC é: " + imcDoubleFormatado;
        resultadoImc.setText(resultadoImcCalculado);

        // Mostrar a mensagem de apoio
        mensagemApoioImc.setText(CompanionObject.MENSAGEM_APOIO);


        // Fechar a tela
        btnFecharImc.setOnClickListener(v -> finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void mostrarPopup() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        double resultadoBundle = bundle.getDouble("resultadoimc");
        String resultadoFormatado = String.format("%.2f", resultadoBundle);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup_imc);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT)
        );

        TextView popupResultadoImc = dialog.findViewById(R.id.popupTitulo);
        TextView popupClassification = dialog.findViewById(R.id.popupClassificacao);
        TextView popupMessage = dialog.findViewById(R.id.popupMensagem);
        Button popupButton = dialog.findViewById(R.id.popupButton);

        // Configurar os dados do pop-up
        popupResultadoImc.setText(resultadoFormatado);
        popupClassification.setText("Sobrepeso");
        popupMessage.setText("Procure um nutricionista para orientações sobre uma dieta saudável e equilibrada");

        popupButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de vida", "Sobrepeso activity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Sobrepeso activity - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida", "Sobrepeso activity - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "Sobrepeso activity - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida", "Sobrepeso activity - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de vida", "Sobrepeso activity - onStart");
    }
}