package com.poli.proyecto;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;


public class Reserves3Activity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    Button btnFecha, btnHora, btnReservar;
    EditText etFecha, etHora;
    private int dia, mes, ano, hora, minuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserves3);
        btnFecha = (Button) findViewById(R.id.btnHora);
        btnHora = (Button) findViewById(R.id.btnHora);
        btnReservar = (Button) findViewById(R.id.btnReservar);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etHora = (EditText) findViewById(R.id.etHora);
        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);
        ((SeekBar)findViewById(R.id.barraNumero)).setOnSeekBarChangeListener(this);

        Bundle extras = getIntent().getExtras();
        String nombreRestaurante = extras.getString("Nombre");


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if(view==btnFecha){
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            ano = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                    etFecha.setText(dia+"/"+(mes+1)+"/"+ano);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }
        if(view==btnHora){
            final Calendar calendar = Calendar.getInstance();
            hora   = calendar.get(Calendar.HOUR_OF_DAY);
            minuto = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hora, int minuto) {
                    etHora.setText(hora+"/"+minuto);
                }
            }
            ,hora,minuto,false);
            timePickerDialog.show();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        ((TextView)findViewById(R.id.tvNumero)).setText("Numero de Personas: "+i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void reservar(){
        Toast.makeText(btnReservar.getContext(), "Reserva Exitosa", Toast.LENGTH_SHORT).show();
    }
}
