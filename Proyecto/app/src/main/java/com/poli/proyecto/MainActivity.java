package com.poli.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user, password;
    private Button iniciarSesion;
    private String userName, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        iniciarSesion = (Button) findViewById(R.id.login);
        iniciarSesion.setOnClickListener(this);
    }

    public void onClick(View v) {

        userName = user.getText().toString();
        sPassword = password.getText().toString();

        if ((userName.equals("admin")) && (sPassword.equals("123456"))) {
            Intent inicio = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(inicio);
        } else {
            Toast.makeText(iniciarSesion.getContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
        }


    }

}

