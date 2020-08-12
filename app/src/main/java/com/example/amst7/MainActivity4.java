package com.example.amst7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity4<i> extends AppCompatActivity {
    private ListView lista;
    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        String[][] listado = obtenerDatos();
        lista = (ListView) findViewById(R.id.id_listView);
        lista.setAdapter(new Adaptador(this, listado));
        Bundle bundle = getIntent().getExtras();
        usuario = bundle.getString("usuario".toString());
        String todo = bundle.getString("genero".toString());
        TextView texto= (TextView)findViewById(R.id.textView12);
        texto.setText(todo);
    }

    public void verCategoria(View view) {
        Intent cat= new Intent(this,MainActivity7.class);
        startActivity(cat);
    }
    public void verPerfil(View view){
        Intent perfil = new Intent(this,MainActivity6.class);
        perfil.putExtra("usuario",usuario);
        startActivity(perfil);
    }
    public String[][] obtenerDatos(){
        int contador = 0;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("Select * from Libros", null);
        int tamano = fila.getCount();
        String[][] listado = new String[tamano][6];
        fila.moveToFirst();
        do {
            String[] datos_libro = new String[5];
            datos_libro[0] = fila.getString(1);
            datos_libro[1] = fila.getString(3);
            datos_libro[2] = fila.getString(4);
            datos_libro[3] = fila.getString(2);
            datos_libro[4] = fila.getString(5);
            datos_libro[5] = fila.getString(6);
            listado[contador] = datos_libro;
            contador += 1;
        } while (fila.moveToNext());
        BaseDeDatos.close();
        admin.close();
        return listado;
    }
}
