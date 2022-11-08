package com.example.seriesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptadorper extends RecyclerView.Adapter<Adaptadorper.ViewHolder> {

    ArrayList<Series> listadoDatos;

    private OnItemClickListener onItemClickListener;

    public Adaptadorper(ArrayList<Series> listadoDatos) {
        this.listadoDatos = listadoDatos;
        this.onItemClickListener=null;
    }
    public void setListadoDatos (ArrayList<Series> listadoDatos){
        this.listadoDatos=listadoDatos;
        notifyDataSetChanged();

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrecycle,parent,false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cargarDatos(listadoDatos.get(position));


    }

    @Override
    public int getItemCount() {

        return listadoDatos.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView2;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.marca);
            textView2=itemView.findViewById(R.id.descripcion);
            imageView=itemView.findViewById(R.id.imageView);


        }

        public void cargarDatos(Series series) {
            textView.setText(series.getName() );
            textView2.setText(series.getDescripcion());
            Picasso.get().load(series.getURL()).resize(300,300).error(R.drawable.ic_launcher_background).into(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(imageView.getContext(),"Click en Imagen de "+ series.getName(),Toast.LENGTH_SHORT).show();

                }
            });

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(imageView.getContext(),"Click en Titulo de "+ series.getName(),Toast.LENGTH_SHORT).show();

                }
            });

            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(imageView.getContext(),"Click en Descripcion de "+ series.getName(),Toast.LENGTH_SHORT).show();
                }
            });

            if(onItemClickListener!=null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(series,getAdapterPosition());

                    }
                });

            }





        }
    }

    public interface OnItemClickListener{
        void onItemClick(Series series, int posicion);

    }
}
