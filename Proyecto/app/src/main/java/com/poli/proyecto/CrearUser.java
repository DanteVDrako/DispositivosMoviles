package com.poli.proyecto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrearUser extends AppCompatActivity {
    private EditText editMail, editCont,editNombre,editApellido;
    private Button ingresarusuario;
   private ProgressBar PbProgress;
    FirebaseAuth miAuth;
    FirebaseAuth.AuthStateListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_user);
        ingresarusuario = (Button) findViewById(R.id.ingresarUsuario);
        editMail = (EditText) findViewById(R.id.editMail);
        editCont = (EditText) findViewById(R.id.editCont);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
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


        ingresarusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
                insertUsuario();
                Intent menu = new Intent(CrearUser.this, MainActivity.class);
                startActivity(menu);
            }
        });

    }



    private void registrarUsuario() {

        final String usuario = editMail.getText().toString();
        final String contrasena = editCont.getText().toString();
        if(usuario.isEmpty()&&contrasena.isEmpty()){
            Toast.makeText(getApplicationContext(), "Ingrese Datos", Toast.LENGTH_SHORT).show();
        }
        if (!usuario.isEmpty() && !contrasena.isEmpty()){

            //pbProgreso.show();
            miAuth.createUserWithEmailAndPassword(usuario,contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Error al registrar usuario",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Usuario Registrado",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }





    }
    public void insertUsuario() {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        String key = myRef.push().getKey();

        String valorNombre = editNombre.getText().toString();
        String ValorApe = editApellido.getText().toString();
        String valorCorreo = editMail.getText().toString();
        String valorContra= editCont.getText().toString();

        User nuevoUser = new User(valorNombre, ValorApe, valorCorreo, valorContra);
        myRef.child(key).setValue(nuevoUser);
        //Toast.makeText(getApplicationContext(),"Usuario ingresado", Toast.LENGTH_SHORT).show();
    }


}
