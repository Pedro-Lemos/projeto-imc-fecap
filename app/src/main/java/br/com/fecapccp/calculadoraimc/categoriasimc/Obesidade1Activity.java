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

public class Obesidade1Activity extends AppCompatActivity {

    private TextView classificacaoImc;
    private TextView resultadoImcAltura;
    private TextView resultadoImcPeso;
    private TextView resultadoImc;
    private TextView mensagemApoioImc;
    private Button btnFecharImc;

    public static final class CompanionObject {
        public static final String MENSAGEM_APOIO = "\uD83D\uDCA1 Pequenas mudanças geram grandes resultados! Se você quer melhorar sua saúde, vá com calma e sem cobranças. Não precisa ser perfeito, só consistente. Movimente-se de um jeito que você goste, coma de forma equilibrada e celebre cada conquista. Seu corpo merece cuidado, e você merece se sentir bem em cada fase! \uD83D\uDC96\uD83D\uDCAA";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade1);
        Log.i("Ciclo de vida", "Obesidade 1 activity - onResume");

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
        popupClassification.setText("Obesidade grau 1");
        popupMessage.setText("Procure um nutricionista para orientações sobre uma dieta saudável e equilibrada");

        popupButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de vida", "Obesidade 1 activity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Obesidade 1 activity - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida", "Obesidade 1 activity - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "Obesidade 1 activity - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida", "Obesidade 1 activity - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de vida", "Obesidade 1 activity - onStart");
    }
}