package com.poli.proyecto;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Context context;


    private EditText user, password;
    private Button iniciarSesion,crearUsuario;

    private String userName, sPassword;
    FirebaseAuth miAuth;
    FirebaseAuth.AuthStateListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        iniciarSesion = (Button) findViewById(R.id.login);
        crearUsuario = (Button) findViewById(R.id.crearUsuario);

        iniciarSesion.setOnClickListener(this);
        crearUsuario.setOnClickListener(this);
        miAuth = FirebaseAuth.getInstance();
        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = miAuth.getCurrentUser();
                if (user == null){

                }
                else{


                }
            }
        };
    }


    public void onClick(View v) {


        ingresar();


        crearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent crearUser = new Intent(MainActivity.this, CrearUser.class);
                startActivity(crearUser);
            }
        });


    }

    private void ingresar() {
        final String userIngreso = user.getText().toString();
        String contrasena = password.getText().toString();

        if(userIngreso.isEmpty()&&contrasena.isEmpty()){
            Toast.makeText(getApplicationContext(), "Ingrese Datos", Toast.LENGTH_SHORT).show();
        }
        if(!userIngreso.isEmpty()&&!contrasena.isEmpty()){
            miAuth.signInWithEmailAndPassword(userIngreso,contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Bienvenido "+ userIngreso, Toast.LENGTH_LONG).show();
                        Intent inicio = new Intent(MainActivity.this, MapsActivity.class);
                        inicio.putExtra("user",userIngreso);
                        startActivity(inicio);

                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }
    }





        @Override

    protected  void onStart() {
        miAuth.addAuthStateListener(listener);

        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(listener!=null){
            miAuth.removeAuthStateListener(listener);
        }
    }

    public void insertUsuario(View v){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        String key = myRef.push().getKey();

    }
}

