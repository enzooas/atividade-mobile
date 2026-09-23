package com.ucsal.atividadeavaliativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonConfig = findViewById(R.id.button_configurar);
        Button buttonSair = findViewById(R.id.button_sair);
        buttonConfig.setOnClickListener(this);
        buttonSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.button_configurar) {
            Intent i = new Intent(this, ConfiguracaoActivity.class);
            startActivity(i);
        }

        if (id == R.id.button_sair) {
            finish();
        }
    }
}