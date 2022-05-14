package com.example.semana16

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    private var recyclerView:RecyclerView?=null
    private var recyclerViewAdapter: Reciclerview? = null
    private var lisamigos= mutableListOf<alma>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        lisamigos=ArrayList()
        recyclerView=findViewById(R.id.amiguitos)as RecyclerView
        recyclerViewAdapter=Reciclerview(lisamigos)
        val layoutManager: RecyclerView.LayoutManager= LinearLayoutManager(this)
        recyclerView!!.layoutManager=layoutManager
        recyclerViewAdapter!!.setOnItemClickListener(object:ClickListener<alma>{
            override fun onItemClick(data: alma) {
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:" + data.des)
                startActivity(dialIntent)

            }
        })
        recyclerView!!.adapter=recyclerViewAdapter
        laime()

    }
    //Se coloca las imagenes y las caracteriticas de mis amigos llamando friends la variable
    private fun laime() {
        var friends = alma(
            "jaime",
            R.drawable.jaime,
            "89008732"
        )
        lisamigos.add(friends)
        friends = alma("chamba", R.drawable.chamba, "77443201")
        lisamigos.add(friends)
        friends = alma("melvito", R.drawable.melvito, "66430892")
        lisamigos.add(friends)
        friends = alma("adiel", R.drawable.adiel, "66749302")
        lisamigos.add(friends)
        friends = alma("gabriel", R.drawable.gabriel, "99820192")
        lisamigos.add(friends)
        friends = alma("cristiano", R.drawable.cristiano, "77777777")
        lisamigos.add(friends)
        recyclerViewAdapter?.notifyDataSetChanged()


    }
}
