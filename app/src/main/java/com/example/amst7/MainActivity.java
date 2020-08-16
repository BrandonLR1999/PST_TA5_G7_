package com.example.amst7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText campousuario;
    public EditText campopass;
    AdminSQLiteOpenHelper1 admin=new AdminSQLiteOpenHelper1(this, "datosregistro1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campousuario=(EditText)findViewById(R.id.nomusu);
        campopass= (EditText)findViewById(R.id.contras);
        //juvenil
        generarPrimerosLibros("1","Cazadores de sombras: Ciudad de Hueso","Juvenil","Cassandra Clare","Destino Infantil & Juvenil","En el Pandemonium, la discoteca de moda de Nueva York, Clary sigue a un atractivo chico de pelo azul hasta que presencia su muerte a manos de tres jóvenes cubiertos de extraños tatuajes. Desde esa noche, su destino se une al de esos tres cazadores de sombras, guerreros dedicados a liberar a la tierra de demonios y, sobre todo, al de Jace, un chico con aspecto de ángel y tendencia a actuar como un idiota.","https://static2planetadelibroscom.cdnstatics.com/usuaris/libros/fotos/212/m_libros/portada_ciudad-de-hueso_cassandra-clare_201602251706.jpg");
        generarPrimerosLibros("2","La Selección","Juvenil","Kiera Cass","N.A","La oportunidad de escapar de la vida que les ha tocado por nacer en una determinada familia. La oportunidad de que las trasladen a un mundo de trajes preciosos y joyas que no tienen precio. La oportunidad de vivir en un palacio y de competir por el corazón del guapísimo príncipe Maxon.","https://www.rocalibros.com/archivos/imagenes/mayores/1522.jpg");
        generarPrimerosLibros("3","Invisible","Juvenil","Eloy Moreno","Nube de Tinta","¿Quién no ha deseado alguna vez ser invisible?\n" +
                "¿Quién no ha deseado alguna vez dejar de serlo?\n" +
                "El problema es que nunca he llegado a controlar bien ese poder:\n" +
                "A veces, cuando más ganas tenía de ser invisible, era cuando más gente me veía, y en cambio, cuando deseaba que todos me vieran, era cuando a mi cuerpo le daba por desaparecer.","https://static.megustaleer.com/images/libros_650_x/ENT88572.jpg");
        //terror
        generarPrimerosLibros("4","La leyenda de Sleepy Hollow", "Terror","Washington Irving","Editorial Valdemar.","La leyenda narra el relato de Ichabod Crane, un profesor de escuela extremadamente supersticioso de Connecticut que se enamora de la joven de 18 años Katrina Van Tassel, hija única de Baltus Van Tassel, un adinerado granjero del pueblo, y de su fortuna, a la que también pretende el joven y rudo Abraham \"Brom Bones\" Van Brunt. ","https://eslamoda.com/wp-content/uploads/sites/2/2015/08/La-leyenda-de-Sleepy-Hollow.jpg");
        generarPrimerosLibros("5","IT","Terror","Stephen King","Viking Press","It (en español, «Eso») es una novela de terror publicada en 1986 por el escritor estadounidense Stephen King. Cuenta la historia de un grupo de siete niños que son aterrorizados por un malvado monstruo -al que llaman «Eso»- que es capaz de cambiar de forma, alimentándose del terror que produce en sus víctimas.","https://static.megustaleer.com/images/libros_650_x/EL354038.jpg");
        generarPrimerosLibros("6","Festival de la Blasfemia","Terror","Ángel David Revilla Lenoci","Ediciones Temas de Hoy","Bienaventurados aquellos que profanan porque de ellos será el Reino de las Tinieblas. Bienaventurado aquel que repudia a Dios, porque de él serán los secretos del lado oscuro.","https://images-na.ssl-images-amazon.com/images/I/41hPDXAvUoL.jpg");
        //romance
        generarPrimerosLibros("7", "Uno mas uno","Romance","Jojo Moyes","SUMA DE LETRAS","Una madre soltera. Con dos trabajos y dos hijos, Jess Thomas hace lo que puede para sobrevivir día tras día. Pero no es fácil hacerlo sola. Y a veces eso te obliga a correr riesgos que no deberías… porque no tienes más remedio. Una familia caótica. Su peculiar y superdotada hija Tanzie es extraordinaria con los números, pero sin ayuda nunca logrará una oportunidad para demostrarlo. Y Nicky, su hijastro adolescente, no puede enfrentarse solo a los abusones de su colegio. A veces Jess siente que se hunden. Un atractivo desconocido. A sus vidas llega Ed Nicholls, un hombre cuyo presente es un absoluto caos, y que trata de escapar de un futuro totalmente incierto. Pero Ed tiene mucho tiempo en sus manos. Sabe lo que es estar solo. Y quiere ayudar...","http://quelibroleo.com/images/libros/SL58420.jpg");
        generarPrimerosLibros("8","Para siempre","Romance","Judith McNaught","B DE BOLSILLO","La estadounidense Victoria Seaton atraviesa el vasto océano ansiosa por recuperar su patrimonio perdido hace tiempo. Al llegar a destino, conocerá el amor y la traición, cuando había soñado que el primero triunfaría... para siempre.","https://static.megustaleer.com/images/libros_200_x/BB06572.jpg");
        generarPrimerosLibros("9","Una pareja casi perfecta","Romance","Marian Keyes","Plaza & Janés","Amy tiene el marido perfecto. Hugh es guapo, es un buen tipo y un padre maravilloso. Pero un día, de pronto, le dice que quiere que se tomen un descanso. Que necesita estar seis meses lejos de casa, de ella y de la familia, y viajar un tiempo como soltero. Aunque asegura que solo será medio año y que volverá, pues no dejado de amarla, Amy teme que no sea así.\n" +
                "Porque en seis meses pueden pasar muchas cosas... ¿Y si cuando Hugh vuelva, si es que vuelve, ya no es el mismo? ¿Y si ella también ha cambiado? Pero lo peor es qué hacer mientras tanto. ¿Debe seguir siéndole fiel o puede dejarse llevar? Está claro que en la vida no hay que dar nada por sentado, y Amy está a punto de averiguarlo por sí misma.","https://static.megustaleer.com/images/libros_650_x/EL020834.jpg");
        //aventura
        generarPrimerosLibros("10","La vuelta al mundo en ochenta días","Aventura","Julio Verne","Pierre-Jules Hetzel","El señor Phileas Fogg, un misterioso y solitario caballero inglés, abandonará su vida disciplinada para cumplir una apuesta con los miembros del Reform Club, en la que arriesgará una parte de su fortuna comprometiéndose a dar la vuelta al mundo en ochenta días utilizando los medios disponibles en la época.","https://imagessl.tagusbooks.com/a/l/t0/48/9788026834748.jpg");
        generarPrimerosLibros("11","Moby-Dick","Aventura","Herman Melville","DEBATE","Moby Dick , la novela que William Faulkner hubiera querido escribir, ha alcanzado el reconocimiento y el elogio constante que merece una construcción narrativa impecable. La lucha del capitán Ahab, su terrible obsesión y la mítica persecución de la enorme ballena han traspasado fronteras, consiguiendo así la indiscutible categoría de obra maestra de la literatura universal.","https://imagessl2.casadellibro.com/a/l/t5/52/9788499086552.jpg");
        generarPrimerosLibros("12","El señor de Ballantrae","Aventura","Robert Louis Stevenson","Cassell","Es la historia de los dos hijos de Lord Durrisdeer, a los que el destino enfrentó de la cuna a la sepultura con la ceguera de lo inexplicable. Es una novela dinámica y aventurera en la que Stevenson engarza la nostalgia por la lejana Escocia, a la que nunca más regresaría, con sus experiencias y viajes por Norteamérica.","https://m.media-amazon.com/images/I/51Gz9aylPOL.jpg");

        //generarAdmin
        AdminSQLiteOpenHelper1 admin=new AdminSQLiteOpenHelper1(this, "datosregistro1",null,1);
        admin.abrir();
        SQLiteDatabase Basedatos=admin.getWritableDatabase();
        admin.insertarregistro("admin","Grupo7","Administrador","admin","adminG7@espol.edu.ec","0999999999","Terror","Femenino");
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

    public void registro(View view){
        Intent i=new Intent(this, MainActivity2.class);
        startActivity(i);
        finish();
    }

    public void ingresar(View view){
        if(!(campousuario.getText().toString().isEmpty() || campousuario.getText().toString().isEmpty()) ){
            try {
                Cursor cursor = admin.validar(campousuario.getText().toString(),campopass.getText().toString());
                if(cursor.getCount()>0){
                    if(campousuario.getText().toString().equals("admin")) {
                        Intent pasar = new Intent(this, IngresoBaseDeDatos.class);
                        pasar.putExtra("usuario",campousuario.getText().toString());
                        startActivity(pasar);
                    }
                    else{
                        Intent pasar1 = new Intent(this, MainActivity4.class);
                        pasar1.putExtra("usuario",campousuario.getText().toString());
                        pasar1.putExtra("genero","todo");
                        startActivity(pasar1);
                    }
                }   else {
                    Toast.makeText(this, "Usuario no existe, por favor regístrese.", Toast.LENGTH_SHORT).show();
                }
                campousuario.setText("");
                campopass.setText("");
            }

            catch(SQLException e){
                e.printStackTrace();
            }
        } else{
            Toast.makeText(this, "Ingrese usuario o contraseña.", Toast.LENGTH_SHORT).show();
        }
    }
}