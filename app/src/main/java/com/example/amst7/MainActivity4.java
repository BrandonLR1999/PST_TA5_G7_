package com.example.amst7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4<i> extends AppCompatActivity {
    private ListView lista;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle bundle = getIntent().getExtras();
        usuario = bundle.getString("usuario".toString());
        TextView user = (TextView)findViewById(R.id.textView12);
        user.setText(usuario);
        String todo = bundle.getString("genero".toString());
        String query = "select * from Libros";
        if(!todo.equals("todo")){
            query = query+" where Genero = '"+todo+"'";
            Log.i("MENSAJE",query);
        }
        Log.i("MENSAJE",query);
        Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
        int contador = 0;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor fila = BaseDeDatos.rawQuery(query, null);
        int tamano = fila.getCount();
        String[][] listado = new String[tamano][6];
        fila.moveToFirst();
        do {
            String[] datos_libro = new String[6];
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
        lista = (ListView) findViewById(R.id.id_listView);
        lista.setAdapter(new Adaptador(this, listado,tamano));
    }

    public void verCategoria(View view) {
        Intent cat= new Intent(this,MainActivity7.class);
        startActivity(cat);
    }

    public void verPerfil(View view){
        Intent perfil = new Intent(this,MainActivity6.class);
        perfil.putExtra("usuario",usuario.toString());
        startActivity(perfil);
    }

    public String[][] obtenerDatos(String subquery){
        int contador = 0;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("Select * from Libros"+subquery, null);
        int tamano = fila.getCount();
        String[][] listado = new String[tamano][6];
        fila.moveToFirst();
        do {
            String[] datos_libro = new String[6];
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
