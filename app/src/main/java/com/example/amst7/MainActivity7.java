package com.example.amst7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity7 extends AppCompatActivity {
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Bundle bundle = getIntent().getExtras();
        usuario = bundle.getString("usuario".toString());
    }

    public void terror(View view){
        Intent pasar= new Intent(this,MainActivity4.class);
        pasar.putExtra("genero","Terror");
        pasar.putExtra("usuario",usuario.toString());
        startActivity(pasar);
    }

    public void romance(View view){
        Intent pasar= new Intent(this,MainActivity4.class);
        pasar.putExtra("genero","Romance");
        pasar.putExtra("usuario",usuario.toString());
        startActivity(pasar);
    }

    public void aventura(View view){
        Intent pasar= new Intent(this,MainActivity4.class);
        pasar.putExtra("genero","Aventura");
        pasar.putExtra("usuario",usuario.toString());
        startActivity(pasar);
    }

    public void juvenil(View view){
        Intent pasar= new Intent(this,MainActivity4.class);
        pasar.putExtra("genero","Juvenil");
        pasar.putExtra("usuario",usuario.toString());
        startActivity(pasar);
    }
}