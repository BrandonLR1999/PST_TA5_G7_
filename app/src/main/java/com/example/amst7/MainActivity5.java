package com.example.amst7;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    TextView titulo,descripcion;
    ImageView portada;

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        titulo = (TextView)findViewById(R.id.textViewTitulo_Libro);
        descripcion = (TextView)findViewById(R.id.textViewDescripcion_Libro);

        Intent datos = getIntent();
        Bundle b = datos.getExtras();

        DisplayMetrics medidaVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);
        int ancho = medidaVentana.widthPixels;
        int alto = medidaVentana.heightPixels;
        getWindow().setLayout((int)(ancho*0.8),(int)(alto*0.5));

        titulo.setText(b.getString("Titulo").toString());
        descripcion.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        descripcion.setText(b.getString("Descripcion").toString());

    }
    /*
    public void cerrar(View view){
        finish();
    }*/
}