package com.example.seriesapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "series")
public class Series implements Serializable {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "nombre")
    private String name;
    @ColumnInfo(name = "descripcion")
    private String descripcion;
    @ColumnInfo(name = "url_imagen")
    private String URL;


    public Series(String name, String descripcion, String URL) {
        this.id=0;
        this.name = name;

        this.descripcion = descripcion;
        this.URL = URL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }


}
