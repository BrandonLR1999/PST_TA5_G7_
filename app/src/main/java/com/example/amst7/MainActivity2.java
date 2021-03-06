package com.example.amst7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public EditText etnombre, etapellido, etusuarioreg, etcontraus, etcorreo, etcell, etcategoriafav;
    public Spinner spinner;
    AdminSQLiteOpenHelper1 admin=new AdminSQLiteOpenHelper1(this, "datosregistro1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.sexo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        etnombre=(EditText)findViewById(R.id.editTextNombre);
        etapellido=(EditText)findViewById(R.id.editTextApellido);
        etusuarioreg=(EditText)findViewById(R.id.editTextNombUsu);
        etcontraus=(EditText)findViewById(R.id.editTextContra);
        etcorreo=(EditText)findViewById(R.id.editTextEmail);
        etcell=(EditText)findViewById(R.id.editTextCell);
        etcategoriafav=(EditText)findViewById(R.id.editTextCatFav);
    }

    public void confirmar(View view){
        registro(view);
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
    public void volver(View view){
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void registro(View view){
        admin.abrir();
        SQLiteDatabase Basedatos=admin.getWritableDatabase();
        String nombre=etnombre.getText().toString();
        String apellido=etapellido.getText().toString();
        String userreg=etusuarioreg.getText().toString();
        String contra=etcontraus.getText().toString();
        String correo=etcorreo.getText().toString();
        String celular=etcell.getText().toString();
        String categ=etcategoriafav.getText().toString();
        String sexo=spinner.getSelectedItem().toString();;

        if(!nombre.isEmpty() && !apellido.isEmpty() && !userreg.isEmpty()
                && !contra.isEmpty() && !correo.isEmpty() && !celular.isEmpty()
                && !categ.isEmpty() && !sexo.isEmpty()){
            admin.insertarregistro(userreg,nombre,apellido,contra,correo,celular,categ,sexo);
            admin.cerrar();
            Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
            etnombre.setText("");
            etapellido.setText("");
            etusuarioreg.setText("");
            etcontraus.setText("");
            etcorreo.setText("");
            etcell.setText("");
            etcategoriafav.setText("");

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}