package com.example.seriesapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SerieDAO {
    @Query("select * from series")
    List<Series>obtenerTodo();
    @Insert
    void insertarElemento(Series miSeries);
    @Update
    void editar(Series miSeries);
    @Delete
    void eliminar (Series miSeries);

    @Query("select * from series where id=:parametro")
    Series obtenerPorIdentificador(int parametro);



}
