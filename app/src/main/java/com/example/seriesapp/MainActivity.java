package com.example.seriesapp;

import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvSeries;
    private ArrayList<Series>listadoSeries;
    private Button nvserie;
    private Adaptadorper adaptador;


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navbar,menu);
        return super.onCreateOptionsMenu(menu);
        //fabian suarez

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.it_id:
                SharedPreferences sharedPreferences=getSharedPreferences("preferences",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putBoolean("loged in",false);
                editor.apply();
                Intent intent= new Intent(MainActivity.this,LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatosInicialesBasesDatos();
        nvserie =findViewById(R.id.nvserie);
        rvSeries= findViewById(R.id.listadoSeries);
        rvSeries.setLayoutManager(new LinearLayoutManager(this));
        //Creamos nuestro propio Adapter
        adaptador= new Adaptadorper(listadoSeries);
        rvSeries.setAdapter(adaptador);


        adaptador.setOnItemClickListener(new Adaptadorper.OnItemClickListener() {

            @Override
            public void onItemClick(Series series, int posicion) {
                Toast.makeText(MainActivity.this, "Click "+series.getName(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    private  void cargarDatosInicialesBasesDatos(){

        BaseDatos miBaseDatos= BaseDatos.obtenerInstancia(this);
        SerieDAO serieDAO= miBaseDatos.serieDAO();
        listadoSeries= (ArrayList<Series>) serieDAO.obtenerTodo();
        if(listadoSeries.isEmpty()){
            Creopordefecto();
        }
    }

    private void Creopordefecto() {

        BaseDatos miBaseDatos= BaseDatos.obtenerInstancia(this);
        SerieDAO serieDAO= miBaseDatos.serieDAO();
        listadoSeries= new ArrayList<>();
        Series ejemplo1= new Series("PORSCHE", "El Porsche 911 S 2.4 Targa cuidadosamente restaurado regresa en forma impresionante. Durante la restauraci??n de este cl??sico se logr?? una especial reinterpretaci??n del deportivo. La ic??nica firma de FA Porsche", "2012");
        Series ejemplo2= new Series("NISSAN","Si consideramos que durante esta ??poca convivieron los R32, R33 y R34 ser??a injusto solo volcarse a un solo modelo. Como sea, es en esta d??cada en la que este bestial autom??vil gana el sobrenombre de Godzilla. El R32, era un tracci??n trasera, pero a partir del R33 a??ade un sofisticado sistema de tracci??n integral. De hecho, se puede decir que el R34 es la culminaci??n y perfeccionamiento de las tecnolog??as experimentadas en sus antecesores. Esto lo llev?? a establecer r??cords en diferentes circuitos alrededor del mundo, N??rburgring, incluido. Desde entonces, es el terror de Porsche.","2020");
        Series ejemplo3= new Series("VOLKSWAGEN","producido por el fabricante alem??n Volkswagen desde 1979. El Jetta existe en versiones sed??n y familiar (familiar Variant); era una variante del Volkswagen Golf (hasta el A6/Golf VI). Hasta 2019, a lo largo de todas sus generaciones se han fabricado 6 millones de unidades.\u200B\n" +
                "\n" +
                "Actualmente el Jetta abarca siete generaciones, todas han sido comercializadas bajo ese nombre en Am??rica del Norte y Sud??frica. En Europa, la tercera generaci??n fue denominada Vento, y la cuarta se llam?? Bora. En M??xico, solamente la primera generaci??n se llam?? Atlantic y debido a que la cuarta generaci??n continu?? en producci??n y retuvo el nombre Jetta, la quinta se comercializ?? como Bora; cuando la sexta generaci??n recuper?? el nombre Jetta, la cuarta que continu?? a la venta hasta el 2014 cambi?? su nombre a Cl??sico.","2020");
        Series ejemplo4= new Series("TOYOTA","lanzado en 1993, el modelo m??s emblem??tico, siendo la estrella de la primera entrega de Fast and the Furious. M??s all?? de su atractiva carrocer??a tipo targa, este auto encontraba en el robusto seis cilindros en l??nea twin turbo 2JZ-GTE de 3.0 litros (capaz de entregar 320 Hp), su principal atractivo. Para las versiones base, estaba disponible este mismo propulsor, pero sin la inclusi??n de un turbo solo era capaz de entregar 220 caballos. Un auto emblem??tico, y bastante codiciado por los coleccionistas. ","2020");
        serieDAO.insertarElemento(ejemplo1);
        serieDAO.insertarElemento(ejemplo2);
        serieDAO.insertarElemento(ejemplo3);
        serieDAO.insertarElemento(ejemplo4);

        listadoSeries= (ArrayList<Series>) serieDAO.obtenerTodo();


    }

    private void cargarDatosIni() {

        BaseDatos miBaseDatos= BaseDatos.obtenerInstancia(this);
        SerieDAO serieDAO= miBaseDatos.serieDAO();
        listadoSeries= new ArrayList<>();
        Series ejemplo1= new Series("PORSCHE", "El Porsche 911 S 2.4 Targa cuidadosamente restaurado regresa en forma impresionante. Durante la restauraci??n de este cl??sico se logr?? una especial reinterpretaci??n del deportivo. La ic??nica firma de FA Porsche", "2012");
        Series ejemplo2= new Series("NISSAN","Si consideramos que durante esta ??poca convivieron los R32, R33 y R34 ser??a injusto solo volcarse a un solo modelo. Como sea, es en esta d??cada en la que este bestial autom??vil gana el sobrenombre de Godzilla. El R32, era un tracci??n trasera, pero a partir del R33 a??ade un sofisticado sistema de tracci??n integral. De hecho, se puede decir que el R34 es la culminaci??n y perfeccionamiento de las tecnolog??as experimentadas en sus antecesores. Esto lo llev?? a establecer r??cords en diferentes circuitos alrededor del mundo, N??rburgring, incluido. Desde entonces, es el terror de Porsche.","2020");
        Series ejemplo3= new Series("VOLKSWAGEN","producido por el fabricante alem??n Volkswagen desde 1979. El Jetta existe en versiones sed??n y familiar (familiar Variant); era una variante del Volkswagen Golf (hasta el A6/Golf VI). Hasta 2019, a lo largo de todas sus generaciones se han fabricado 6 millones de unidades.\u200B\n" +
                "\n" +
                "Actualmente el Jetta abarca siete generaciones, todas han sido comercializadas bajo ese nombre en Am??rica del Norte y Sud??frica. En Europa, la tercera generaci??n fue denominada Vento, y la cuarta se llam?? Bora. En M??xico, solamente la primera generaci??n se llam?? Atlantic y debido a que la cuarta generaci??n continu?? en producci??n y retuvo el nombre Jetta, la quinta se comercializ?? como Bora; cuando la sexta generaci??n recuper?? el nombre Jetta, la cuarta que continu?? a la venta hasta el 2014 cambi?? su nombre a Cl??sico.","2020");
        Series ejemplo4= new Series("TOYOTA","lanzado en 1993, el modelo m??s emblem??tico, siendo la estrella de la primera entrega de Fast and the Furious. M??s all?? de su atractiva carrocer??a tipo targa, este auto encontraba en el robusto seis cilindros en l??nea twin turbo 2JZ-GTE de 3.0 litros (capaz de entregar 320 Hp), su principal atractivo. Para las versiones base, estaba disponible este mismo propulsor, pero sin la inclusi??n de un turbo solo era capaz de entregar 220 caballos. Un auto emblem??tico, y bastante codiciado por los coleccionistas. ","2020",);
        listadoSeries.add(ejemplo1);
        listadoSeries.add(ejemplo2);
        listadoSeries.add(ejemplo3);
        listadoSeries.add(ejemplo4);


    }
    public void Clickformulario(View view){
        Intent irFormulario= new Intent(MainActivity.this,FormularioActivity.class);
       startActivity(irFormulario);




    }





        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==RESULT_OK);{
                Series serieAtrapada= (Series) result.getData().getSerializableExtra("Datos de la serie");

                listadoSeries.add(serieAtrapada);
                adaptador.setListadoDatos(listadoSeries);
            }

        }
    }
