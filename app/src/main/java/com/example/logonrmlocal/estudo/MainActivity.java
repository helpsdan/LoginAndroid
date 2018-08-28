package com.example.logonrmlocal.estudo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUser;
    EditText edtPass;
    CheckBox chkConnect;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        chkConnect = findViewById(R.id.chkConnect);
        sp = getSharedPreferences("login", MODE_PRIVATE);

        edtUser.setText(sp.getString("user", null));
        edtPass.setText(sp.getString("pass", null));
    }

    public void Login(View view) {
        String user = edtUser.getText().toString();
        String pass = edtPass.getText().toString();
        SharedPreferences.Editor e = sp.edit();
        if (user.equals("fiap")&&pass.equals("ads")){
            if (chkConnect.isChecked()){
                e.putString("user", user);
                e.putString("pass", pass);
                e.putBoolean("connect", true);
                e.commit();
            }else {
                e.putString("user", null);
                e.putString("pass", null);
                e.putBoolean("connect", false);
                e.commit();
            }
            abrirCores();
        }

    }

    private void abrirCores() {
        Intent it = new Intent(this, CoresActivity.class);
        startActivity(it);
    }
}
