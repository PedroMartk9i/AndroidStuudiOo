package com.example.seriesapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Series.class},version = 1)
public abstract class BaseDatos extends RoomDatabase {
    public abstract SerieDAO serieDAO();

    public static  BaseDatos instas=null;

    public static BaseDatos obtenerInstancia(Context miContexto){
        if (instas==null){
            instas= Room.databaseBuilder(miContexto,BaseDatos.class,"Seriesapp.database").allowMainThreadQueries().build();
        }
        return instas;
    }



}
