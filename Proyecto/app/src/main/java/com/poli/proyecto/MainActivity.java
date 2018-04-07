package com.poli.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (Button)findViewById(R.id.login);
        a.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId() == a.getId()){
            Intent ir = new Intent (MainActivity.this, MapsActivity.class);
            startActivity(ir);
        }
    }
}
