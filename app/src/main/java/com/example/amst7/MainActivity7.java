package com.example.amst7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

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
    public void click(View view){
        Intent pasar= new Intent(this,MainActivity4.class);
        pasar.putExtra("genero","terror");
        startActivity(pasar);
    }
}