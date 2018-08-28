package com.example.logonrmlocal.estudo;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CoresActivity extends AppCompatActivity {

    RadioGroup rdgCor;
    RadioButton rdbRed;
    RadioButton rdbBlue;
    RadioButton rdbGreen;
    View viewCor;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cores);
        rdgCor = findViewById(R.id.rdgCor);
        rdbRed = findViewById(R.id.rdbRed);
        rdbBlue = findViewById(R.id.rdbBlue);
        rdbGreen = findViewById(R.id.rdbGreen);
        viewCor = findViewById(R.id.viewCor);
        sharedPreferences = getSharedPreferences("cores", MODE_PRIVATE);

        int valor = sharedPreferences.getInt("cor", 0);
        if (valor == 1){
            viewCor.setBackgroundColor(Color.RED);
        }else if (valor == 2){
            viewCor.setBackgroundColor(Color.BLUE);
        }else if(valor == 3){
            viewCor.setBackgroundColor(Color.GREEN);
        }

    }


    public void Salvar(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int cor = rdgCor.getCheckedRadioButtonId();
        switch (cor){
            case R.id.rdbRed:
                viewCor.setBackgroundColor(Color.RED);
                Toast.makeText(this, "Tema vermelho selecionado", Toast.LENGTH_SHORT).show();
                editor.putInt("cor", 1);
                break;
            case R.id.rdbBlue:
                viewCor.setBackgroundColor(Color.BLUE);
                Toast.makeText(this, "Tema azul selecionado", Toast.LENGTH_SHORT).show();
                editor.putInt("cor", 2);
                break;
            case R.id.rdbGreen:
                viewCor.setBackgroundColor(Color.GREEN);
                Toast.makeText(this, "Tema verde selecionado", Toast.LENGTH_SHORT).show();
                editor.putInt("cor", 3);
                break;
        }
    }
}
