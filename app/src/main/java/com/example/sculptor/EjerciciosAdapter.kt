package com.example.sculptor

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sculptor.Usuario
import com.example.sculptor.R
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class EjerciciosAdapter(private val ejerciciosList: ArrayList<Usuario>): RecyclerView.Adapter<EjerciciosAdapter.EjerciciosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjerciciosViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return EjerciciosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EjerciciosViewHolder, position: Int) {
        val currentitem = ejerciciosList[position]


        holder.nombre.text = currentitem.nombre
        holder.descripcion.text = currentitem.descripcion
        holder.imagen.text = currentitem.imagen




    }

    override fun getItemCount(): Int {
        return ejerciciosList.size
    }

    class EjerciciosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nombre: TextView = itemView.findViewById(R.id.txtNombre)
        val descripcion: TextView = itemView.findViewById(R.id.txtDescrip)
        val imagen: TextView = itemView.findViewById(R.id.txtimagen)
        val foto: ImageView = itemView.findViewById(R.id.imageView2)



    }


}