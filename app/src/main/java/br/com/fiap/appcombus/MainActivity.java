package br.com.fiap.appcombus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {
    private TextView gasolinaP;

    private SeekBar gasolinaSeekBar;

    private SeekBar etanolSeekBar;

    private TextView etanolP;

    private TextView resultado;

    private double pGasolina;

    private double pEtanol;

    private double result;

    private ImageView img;

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.validador);
        img = findViewById(R.id.imagem);

        gasolinaSeekBar = findViewById(R.id.gasolina);
        gasolinaP = findViewById(R.id.gasolinaP);

        etanolSeekBar = findViewById(R.id.alcool);
        etanolP = findViewById(R.id.etanolP);

        gasolinaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pGasolina = (float)progress/10.0;
                gasolinaP.setText(String.valueOf(currencyFormat.format(pGasolina)));
                result = pGasolina/pEtanol;
                if (result>=0.7){
                    resultado.setText("Etanol");
                    img.setImageResource(R.drawable.alcool);
                }else{
                    resultado.setText("Gasolina");
                    img.setImageResource(R.drawable.gasolina);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        etanolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pEtanol = (float)progress/10.0;
                etanolP.setText(String.valueOf(currencyFormat.format(pEtanol)));
                result = pEtanol/pGasolina;
                if (result>=0.7){
                    resultado.setText("Etanol");
                    img.setImageResource(R.drawable.alcool);
                }else{
                    resultado.setText("Gasolina");
                    img.setImageResource(R.drawable.gasolina);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
