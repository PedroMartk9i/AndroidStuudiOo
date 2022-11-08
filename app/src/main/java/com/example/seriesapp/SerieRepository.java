package com.example.seriesapp;

public class SerieRepository {

    public void actualizarSerie (Series miSerie) {
        BaseDatos miBaseDatos= BaseDatos.obtenerInstancia(miSerie);

    }

    public void eliminarSerie (Series miSerie) {
        serieDAO.editar(miSerie);
    }


    public void consultorSerie (Series miSerie) {
        serieDAO.editar(miSerie);

     }



}
