package com.example.amst7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity implements View.OnClickListener {
    private TextView nomUsuario;
    private String nombreUsuario;
    private TextView name;
    private TextView lastname;
    private TextView email;
    private TextView phone;
    private TextView fav;
    AdminSQLiteOpenHelper1 admin=new AdminSQLiteOpenHelper1(this, "datosregistro1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        nomUsuario = (TextView)findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        nombreUsuario = bundle.getString("usuario".toString());
        Log.i("Nombre",nombreUsuario);
        nomUsuario.setText(nombreUsuario);
        name= (TextView)findViewById(R.id.textView7);
        lastname= (TextView)findViewById(R.id.textView8);
        email= (TextView)findViewById(R.id.textView9);
        phone= (TextView)findViewById(R.id.textView10);
        fav= (TextView)findViewById(R.id.textView11);
        //avatarUsuario();
        mostrarDatos();
        ImageButton exit = (ImageButton)findViewById(R.id.imageButton);
        //exit.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity6.this);
        builder.setMessage("¿Seguro que desea salir?");
        builder.setCancelable(true);
        builder.setNegativeButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent salir = new Intent(MainActivity6.this, MainActivity.class);
                startActivity(salir);
                finish();
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialogAlerta = builder.create();
        dialogAlerta.show();
    }

    public void avatarUsuario(){
    }

    public void mostrarDatos(){
        SQLiteDatabase baseDatos = admin.getReadableDatabase();
        Cursor fila = baseDatos.rawQuery("select nombre,apellido,correo,celular,categoriafav from usuarios1 where usuario = " + "'"+nombreUsuario+"'", null);
        if (fila.moveToFirst()){
            name.setText(fila.getString(0));
            lastname.setText(fila.getString(1));
            email.setText(fila.getString(2));
            phone.setText(fila.getString(3));
            fav.setText(fila.getString(4));
            baseDatos.close();
        }else{
            name.setText("");
            lastname.setText("");
            email.setText("");
            phone.setText("");
            fav.setText("");
            baseDatos.close();
            Toast.makeText(this, "VACIO", Toast.LENGTH_SHORT).show();
        }
    }
}