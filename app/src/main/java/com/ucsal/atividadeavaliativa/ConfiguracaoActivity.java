package com.ucsal.atividadeavaliativa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ConfiguracaoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNome;
    private RadioButton radioMasculino;
    private RadioButton radioFeminino;
    private CheckBox checkHipolipidica;
    private CheckBox checkHipoglicidica;
    private CheckBox checkSemGluten;
    private Button buttonConfirmar;
    private Button buttonCancelar;

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor sharedPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        editNome = findViewById(R.id.edit_text_nome);
        radioMasculino = findViewById(R.id.radio_masculino);
        radioFeminino = findViewById(R.id.radio_feminino);
        checkHipolipidica = findViewById(R.id.cbHipolipidica);
        checkHipoglicidica = findViewById(R.id.cbHipoglicidica);
        checkSemGluten = findViewById(R.id.cbSemGluten);
        buttonConfirmar = findViewById(R.id.button_confirmar);
        buttonCancelar = findViewById(R.id.button_cancelar);

        buttonCancelar.setOnClickListener(this);
        buttonConfirmar.setOnClickListener(this);

        sharedPrefs = getSharedPreferences("MinhasPreferencias", MODE_PRIVATE);

        String nome = sharedPrefs.getString("nome", "Admin");
        String sexo = sharedPrefs.getString("sexo", "M");
        boolean hipolipidica = sharedPrefs.getBoolean("hipolipidica", false);
        boolean hipoglicidica = sharedPrefs.getBoolean("hipoglicidica", false);
        boolean semGluten = sharedPrefs.getBoolean("semGluten", false);

        editNome.setText(nome);
        if (sexo.equals("M")) {
            radioMasculino.setChecked(true);
        } else {
            radioFeminino.setChecked(true);
        }
        checkHipolipidica.setChecked(hipolipidica);
        checkHipoglicidica.setChecked(hipoglicidica);
        checkSemGluten.setChecked(semGluten);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirmar) {
            String nome = editNome.getText().toString();
            String sexo;
            if (radioMasculino.isChecked()) {
                sexo = "M";
            } else {
                sexo = "F";
            }

            sharedPrefsEditor = sharedPrefs.edit();
            sharedPrefsEditor.putString("nome", nome);
            sharedPrefsEditor.putString("sexo", sexo);
            sharedPrefsEditor.putBoolean("hipolipidica", checkHipolipidica.isChecked());
            sharedPrefsEditor.putBoolean("hipoglicidica", checkHipoglicidica.isChecked());
            sharedPrefsEditor.putBoolean("semGluten", checkSemGluten.isChecked());
            sharedPrefsEditor.commit();

            finish();
        }

        if (v.getId() == R.id.button_cancelar) {
            finish();
        }
    }

}