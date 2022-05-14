package com.example.semana16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Reciclerview constructor(private val lisamigos:List<alma>):
    RecyclerView.Adapter<Reciclerview.MyViewHolder>(){
    private  var clickListener:ClickListener<alma>?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main4,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: Reciclerview.MyViewHolder, position: Int) {
        val anashe=lisamigos[position]
        holder.personita.text=anashe.nombre
        holder.foto1.setBackgroundResource(anashe.foto)
        holder.Viewcard.setOnClickListener {
            clickListener!!.onItemClick(anashe)
        }

        holder.caracte.text="numero: ${anashe.des}"
    }
    override fun getItemCount(): Int {
        return lisamigos.size
    }
    fun setOnItemClickListener(myfriendClickListener:ClickListener<alma>?){
        clickListener=myfriendClickListener

    }
    //es como se llaman las clases en el mainactivity
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personita: TextView = itemView.findViewById(R.id.persona)
        val foto1: ImageView = itemView.findViewById(R.id.imagen)
        val Viewcard: CardView = itemView.findViewById(R.id.carView)
        val caracte: TextView = itemView.findViewById(R.id.caracteristicas)
    }
}
interface ClickListener<T> {
    fun onItemClick(data: T)
}