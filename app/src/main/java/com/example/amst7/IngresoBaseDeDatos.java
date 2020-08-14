package com.example.amst7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class IngresoBaseDeDatos extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "TA5"; //Poner en el activity 4
    private EditText codigo,titulo, autor, editorial, url_imagen,descripcion;
    private Spinner genero;
    String usuario;
    String[] generos = {"Género","Romance","Terror","Aventura","Juvenil"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_base_de_datos);

        codigo = (EditText)findViewById(R.id.editTextCodigo);
        titulo = (EditText)findViewById(R.id.editTextTitulo);
        genero = (Spinner)findViewById(R.id.Generos);
        autor = (EditText)findViewById(R.id.editTextAutor);
        url_imagen = (EditText)findViewById(R.id.editTextImagen);
        descripcion = (EditText)findViewById(R.id.editTextDescripcion);
        editorial = (EditText)findViewById(R.id.editTextEditorial);
        Bundle bundle = getIntent().getExtras();
        usuario = bundle.getString("usuario".toString());
        generarPrimerosLibros("1","Cazadores de sombras: Ciudad de Hueso","Juvenil","Cassandra Clare","Destino Infantil & Juvenil","En el Pandemonium, la discoteca de moda de Nueva York, Clary sigue a un atractivo chico de pelo azul hasta que presencia su muerte a manos de tres jóvenes cubiertos de extraños tatuajes. Desde esa noche, su destino se une al de esos tres cazadores de sombras, guerreros dedicados a liberar a la tierra de demonios y, sobre todo, al de Jace, un chico con aspecto de ángel y tendencia a actuar como un idiota.","https://static2planetadelibroscom.cdnstatics.com/usuaris/libros/fotos/212/m_libros/portada_ciudad-de-hueso_cassandra-clare_201602251706.jpg");
        generarPrimerosLibros("2","La leyenda de Sleepy Hollow", "Terror","Washington Irving","Editorial Valdemar.","La leyenda narra el relato de Ichabod Crane, un profesor de escuela extremadamente supersticioso de Connecticut que se enamora de la joven de 18 años Katrina Van Tassel, hija única de Baltus Van Tassel, un adinerado granjero del pueblo, y de su fortuna, a la que también pretende el joven y rudo Abraham \"Brom Bones\" Van Brunt. ","https://eslamoda.com/wp-content/uploads/sites/2/2015/08/La-leyenda-de-Sleepy-Hollow.jpg");
        generarPrimerosLibros("3", "Uno mas uno","Romance","Jojo Moyes","SUMA DE LETRAS","Una madre soltera. Con dos trabajos y dos hijos, Jess Thomas hace lo que puede para sobrevivir día tras día. Pero no es fácil hacerlo sola. Y a veces eso te obliga a correr riesgos que no deberías… porque no tienes más remedio. Una familia caótica. Su peculiar y superdotada hija Tanzie es extraordinaria con los números, pero sin ayuda nunca logrará una oportunidad para demostrarlo. Y Nicky, su hijastro adolescente, no puede enfrentarse solo a los abusones de su colegio. A veces Jess siente que se hunden. Un atractivo desconocido. A sus vidas llega Ed Nicholls, un hombre cuyo presente es un absoluto caos, y que trata de escapar de un futuro totalmente incierto. Pero Ed tiene mucho tiempo en sus manos. Sabe lo que es estar solo. Y quiere ayudar...","http://quelibroleo.com/images/libros/SL58420.jpg");
        generarPrimerosLibros("4","La vuelta al mundo en ochenta días","Aventura","Julio Verne","Pierre-Jules Hetzel","El señor Phileas Fogg, un misterioso y solitario caballero inglés, abandonará su vida disciplinada para cumplir una apuesta con los miembros del Reform Club, en la que arriesgará una parte de su fortuna comprometiéndose a dar la vuelta al mundo en ochenta días utilizando los medios disponibles en la época.","https://imagessl.tagusbooks.com/a/l/t0/48/9788026834748.jpg");
    }
    //
    public void generarPrimerosLibros(String Codigo,String Titulo,String Genero,String Autor,String Editorial,String Descripcion,String Imagen){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("Codigo",Codigo);
        registro.put("Titulo",Titulo);
        registro.put("Genero",Genero);
        registro.put("Autor",Autor);
        registro.put("Editorial",Editorial);
        registro.put("Descripcion",Descripcion);
        registro.put("Imagen",Imagen);
        BaseDeDatos.insert("Libros", null, registro);
        BaseDeDatos.close();
    }

    //Envio a la base de datos
    public void registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String codigo_s = codigo.getText().toString();
        String titulo_s = titulo.getText().toString();
        String genero_s = genero.getSelectedItem().toString();
        String autor_s = autor.getText().toString();
        String url_imagen_s = url_imagen.getText().toString();
        String descripcion_s = descripcion.getText().toString();
        String editorial_s = editorial.getText().toString();

        if((!codigo_s.isEmpty()) && (!titulo_s.isEmpty()) && (!genero_s.isEmpty()) && (!autor_s.isEmpty()) && (!url_imagen_s.isEmpty()) && (!descripcion_s.isEmpty())){
            ContentValues registro = new ContentValues();
            registro.put("Codigo",codigo_s);
            registro.put("Titulo",titulo_s);
            registro.put("Genero",genero_s);
            registro.put("Autor",autor_s);
            registro.put("Editorial",editorial_s);
            registro.put("Descripcion",descripcion_s);
            registro.put("Imagen",url_imagen_s);

            BaseDeDatos.insert("Libros", null, registro);
            BaseDeDatos.close();

            codigo.setText("");
            titulo.setText("");
            autor.setText("");
            genero.setSelection(0);
            url_imagen.setText("");
            descripcion.setText("");
            editorial.setText("");

            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Deben llenarse todos los campos",Toast.LENGTH_LONG).show();
        }
    }

    //Consulta a la base de datos
    public void buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String codigo_s = codigo.getText().toString();

        if (!codigo_s.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("Select * from Libros where Codigo ="+codigo_s, null);
            if(fila.moveToFirst()){
                titulo.setText(fila.getString(1));
                int cont=0;
                for(String gen: generos){
                    if(gen.equals(fila.getString(2))){
                        genero.setSelection(cont);
                    }
                    cont +=1;
                }
                autor.setText(fila.getString(3));
                editorial.setText(fila.getString(4));
                descripcion.setText(fila.getString(5));
                url_imagen.setText(fila.getString(6));
            }else{
                Toast.makeText(this,"No existe el artículo buscado",Toast.LENGTH_LONG).show();
            }
            BaseDeDatos.close();
        }else{
            Toast.makeText(this,"Ingrese un código",Toast.LENGTH_LONG).show();
        }
    }

    public void visualizar(View view){
        Intent visualizar1 = new Intent(this,MainActivity4.class);
        visualizar1.putExtra("usuario",usuario);
        visualizar1.putExtra("genero","todo");
        startActivity(visualizar1);
    }

    public void volver(View view){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    public void borrarDB(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        BaseDeDatos.delete("Libros",null,null);
    }
}