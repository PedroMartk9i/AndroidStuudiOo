package com.example.seriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class FormularioActivity extends AppCompatActivity {

    private EditText Editname,Editdescripcion,EditUrl;
    private Button Guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        referenciarElementos();
    }


    private void referenciarElementos(){
        Editname= findViewById(R.id.Editname);
        Editdescripcion=findViewById(R.id.Editdescrip);
        EditUrl=findViewById(R.id.EditUrl);
        Guardar=findViewById(R.id.Guardar);

    }

    public void guardar(View view){
        String name= Editname.getText().toString();
        String descripcion= Editdescripcion.getText().toString();
        String Url=EditUrl.getText().toString();

        if("".equals(name)){
            Editname.setError("Digita un nombre cachon");
            return;
        }

        if("".equals(descripcion)){
            Editdescripcion.setError("Digita una Descripcion cachon");
            return;
        }

        if("".equals(Url)){
            EditUrl.setError("Digita un URL cachon");
            return;
        }
        Series series= new Series(name, descripcion, Url);
        Intent datos = new Intent();
        datos.putExtra("Datos de la serie",series);
        setResult(RESULT_OK,datos);

        //Vamos a hacer la insercion en la base de datos

        BaseDatos miBaseDatos= BaseDatos.obtenerInstancia(this);
        SerieDAO serieDAO= miBaseDatos.serieDAO();
        //SerieDAO.insertarElemento(series);

        //Intent regresar= new Intent(FormularioActivity.this,MainActivity.class);
        //startActivity(regresar);
        finish();
    }

}